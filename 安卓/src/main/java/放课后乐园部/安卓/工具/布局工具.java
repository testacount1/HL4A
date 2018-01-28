package 放课后乐园部.安卓.工具;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.视图.实现.*;
import 放课后乐园部.工具.*;
import 放课后乐园部.收集.*;
import java.util.*;

public class 布局工具 {

    static final boolean 可直接 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;

    public static void 打开(Activity $界面,View $视图) {
        Window $窗口 = $界面.getWindow();
        $窗口.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); //Then call setStatusBarColor. 
        $窗口.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (可直接) {
            $窗口.setStatusBarColor(视图工具.检查颜色(主题工具.取主题颜色().取基本深色()));
            $界面.setContentView($视图);
            return;
        }
        if ($视图 instanceof ViewGroup) {
            if ($视图.findViewWithTag("$状态栏") != null) {
                $界面.setContentView($视图);
                return;
            }
        }
        $界面.setContentView(加入沉浸状态栏($界面, $视图));
    }

    public static View 加入沉浸状态栏(Activity $上下文,View $视图) {
        线性布局 $内容 = new 线性布局($上下文);
        $内容.置背景颜色(主题工具.取主题颜色().取基本深色());
        $内容.置宽度("最大");
        $内容.置高度(应用工具.取状态栏高度($上下文));
        线性布局 $状态栏 = new 线性布局($上下文);
        $状态栏.置标签("$状态栏");
        $状态栏.加入子元素($内容);
        $状态栏.加入子元素($视图);
        return $状态栏;
    }

    public static String[] 视图来源 = {
        "视图","视图.扩展","资源.布局",
    };

    public static View 解析(List $表,ViewGroup $父视图) {
        集合 $列表 = new 集合($表);
        Object $视图参数 = $列表.读取(0);
        Class<?> $类 = null;
        if ($视图参数 instanceof Class) {
            $类 = (Class<?>)$视图参数;
            if (!View.class.isAssignableFrom($类)) {
                throw new RuntimeException("解析布局:" + $类.getName() + "不是视图！");
            }
        } else if ($视图参数 instanceof String) {
            String $类名 = (String)$视图参数;
            $循环:for (String $单个 : 视图来源) {
                $类 = 反射工具.取类("放课后乐园部.安卓." + $单个 + "." + $类名);
                if ($类 != null) {
                    break $循环;
                }
            }
            if ($类 == null) {
                throw new RuntimeException("解析布局:找不到类" + $视图参数);
            }
        }
        Object $视图对象 = 反射工具.实例化($类, $父视图.getContext());
        View $视图 = (View)$视图对象;
        if ($父视图 != null) {
            $父视图.addView($视图);
        }
        $列表.删除(0);
        for (Object $参数 : $列表) {
            if ($参数 instanceof Map) {
                解析参数($视图, (Map)$参数);
            } else if ($参数 instanceof List) {
                if (!($视图 instanceof ViewGroup)) {
                    throw new RuntimeException("不能给不是布局的视图加入子元素！");
                } else {
                    解析((List)$参数, (ViewGroup)$视图);
                }
            }
        }
        return (View)$视图对象;
    }

    public static void 解析参数(View $视图,Map<String,Object> $参数) {
        Set<String> $设置 = $参数.keySet();
        for (String $单个 : $设置) {
            String $名称 = "置"+ $单个;
            //if (反射工具.有方法($视图, $名称)) {
                反射工具.调用方法($视图,$名称,$参数.get($单个));
            //}
        }
    }

}

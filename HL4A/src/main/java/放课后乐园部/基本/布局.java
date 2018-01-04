package 放课后乐园部.基本;

import android.content.Context;
import android.view.View;
import 放课后乐园部.视图.线性布局;
import android.app.Activity;
import 放课后乐园部.视图.实现.基本视图;
import android.view.ViewGroup;
import android.view.*;
import android.os.*;

public class 布局 {

    布局() {}
    
    public static void 打开(Activity $界面,View $视图) {
        if ($视图 instanceof ViewGroup) {
            if ($视图.findViewWithTag("$状态栏") != null) {
                $界面.setContentView($视图);
                return;
            }
        }
        $界面.setContentView(加入沉浸状态栏($界面, $视图));
    }

    public static View 加入沉浸状态栏(Activity $上下文,View $视图) {
        return new 线性布局($上下文)
            .置标签("$状态栏")
            .加入子元素(new 线性布局($上下文)
                   .置背景颜色(主题.基本深色())
                   .置宽度("最大")
                   .置高度(应用.取状态栏高度($上下文)))
            .加入子元素($视图);
    }

}

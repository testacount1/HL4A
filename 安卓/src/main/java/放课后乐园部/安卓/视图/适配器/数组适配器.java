package 放课后乐园部.安卓.视图.适配器;

import android.content.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.util.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.资源.布局.*;
import 放课后乐园部.收集.*;

public class 数组适配器 extends 基本适配器 {

    public 数组适配器(Context $上下文,String[] $数组) {
        this($上下文, 集合.到集合($数组));
    }

    public 数组适配器(Context $上下文,List<String> $数据) {
        super($上下文, $数据);
    }

    public void 添加(String $项目) {
        哈希表 $参数 = new 哈希表();
        $参数.设置("内容", $项目);
        数据.添加($参数);
        发送更新事件();
    }

    public void 添加(String... $项目) {
        for (String $单个 : $项目) {
            哈希表<String,String> $参数 = new 哈希表<>();
            $参数.设置("内容", $单个);
            数据.添加($参数);
        }
        发送更新事件();
    }
    
    public void 添加(List<String> $项目) {
        添加($项目.toArray(new String[$项目.size()]));
    }
    
    public void 设置(String... $项目) {
        数据 = 转换(new 集合<String>($项目));
        发送更新事件();
    }

    @Override
    public 集合<哈希表<String,String>> 转换(List<String> $数据) {
        集合<哈希表<String,String>> $返回 = new 集合<>();
        for (Object $单个 : $数据) {
            $返回.添加(new 哈希表<String,String>().设置("内容", $单个.toString()));
        }
        return $返回;
    }

    @Override
    public View 创建() {
        return new 布局_适配器_数组(上下文);
    }

    private ViewGroup 预测布局;;

    public int 预测宽度() {

        // 从 android源码 MenuPopupHelper 抄来的

        int maxWidth = 0;
        View itemView = null;
        int itemType = 0;

        final int widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        final int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        final int count = getCount();
        for (int i = 0; i < count; i++) {
            final int positionType = getItemViewType(i);
            if (positionType != itemType) {
                itemType = positionType;
                itemView = null;
            }

            if (预测布局 == null) {
                预测布局 = new FrameLayout(上下文);
            }

            itemView = getView(i, itemView, 预测布局);
            itemView.measure(widthMeasureSpec, heightMeasureSpec);

            final int itemWidth = itemView.getMeasuredWidth();
            if (itemWidth > maxWidth) {
                maxWidth = itemWidth;
            }
        }

        return maxWidth;
    }

    @Override
    public View 处理(View $视图,哈希表 $参数) {
        文本视图 $内容 = ((布局_适配器_数组)$视图).文本;
        $内容.置文本((String)$参数.读取("内容"));
        return $视图;
    }

}

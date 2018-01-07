package 放课后乐园部.基本;

import android.content.*;
import android.widget.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.事件.*;
import android.view.*;
import 放课后乐园部.收集.*;

public class 菜单 extends PopupWindow {

    View 控件;
    Context 上下文;
    线性布局 布局;
    集合 所有;

    public 菜单(View $控件) {
        super($控件);
        所有 = new 集合();
        控件 = $控件;
        上下文 = $控件.getContext();
        setWidth(-2);
        setHeight(-2);
        setFocusable(true);
        setBackgroundDrawable(绘画.颜色转绘画(颜色.白色));
        卡片视图 $卡片 = new 卡片视图(上下文);
		$卡片.置背景(颜色.白色);
		$卡片.置圆角("4dp");
		$卡片.置宽度("自动");
		$卡片.置高度("自动");
        setContentView($卡片);
        布局 = new 线性布局(上下文);
		布局.置宽度("自动");
		布局.置高度("自动");
		布局.置方向("垂直");
		布局.加入到($卡片);

    }

    public 菜单 添加(String $内容,通用方法 $单击) {
        添加($内容)
            .置单击事件($单击);
        return this;
    }

    public 菜单 添加(String $内容,通用方法 $单击,通用方法 $长按) {
        线性布局 $菜单 = 添加($内容);
		$菜单.置单击事件($单击);
		$菜单.置长按事件($长按);
        return this;
    }

    public 线性布局 添加(String $内容) {
        while ($内容.length() < 20)
            $内容 = $内容 + "  ";
        线性布局 $布局 = new 线性布局(上下文);
		$布局.置宽度("自动");
		$布局.置高度("自动");
		$布局.置背景("透明");
		$布局.置重力("中间垂直");
		$布局.置填充("14dp", "14dp", "16dp", "16dp");
		$布局.加入到(布局);
        文本控件 $文本 = new 文本控件(上下文);
		$文本.置标签("文本");
		$文本.置文本($内容);
		$文本.加入到($布局);

        所有.添加($布局);
        return $布局;
    }

    private void 更新() {
        for (线性布局 v : 所有) {
            v.置宽度("最大");
        }
    }

    public 菜单 显示(String $位置) {
        switch ($位置) {
            case "右上":
                showAsDropDown(控件, 2 * 视图.检查大小("-4dp") - 布局.getWidth(), 视图.检查大小("-4dp") - 布局.getHeight());
                break;
            case "右下":
                showAsDropDown(控件, 2 * 视图.检查大小("-4dp") - 布局.getWidth(), 视图.检查大小("4dp") - 控件.getHeight());
                break;
            case "左下":
                showAsDropDown(控件, 2 * 视图.检查大小("-4dp") - 控件.getWidth(), 视图.检查大小("4dp") - 控件.getHeight());
                break;
            case "右下":default:
                showAsDropDown(控件, 2 * 视图.检查大小("4dp") - 布局.getWidth(), 视图.检查大小("4dp") - 控件.getHeight());
                break;
        }

        更新();
        return this;

    }

    public 菜单 隐藏() {
        dismiss();
        return this;
    }

}

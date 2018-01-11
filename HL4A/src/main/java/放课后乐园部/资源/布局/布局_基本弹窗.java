package 放课后乐园部.资源.布局;

import android.content.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.视图.扩展.*;
import 放课后乐园部.基本.*;
import android.view.*;

public class 布局_基本弹窗 extends 线性布局 {

    public 标题栏 标题;

    public 线性布局 底层;
    public 线性布局 控制;

    public 布局_弹窗按钮 左按钮;
    public 布局_弹窗按钮 中按钮;
    public 布局_弹窗按钮 右按钮;

    public 布局_基本弹窗(Context $上下文) {
        super($上下文);

        标题 = new 标题栏(this);
        标题.置背景(颜色.白色);
        标题.标题对象.置文本颜色(主题.基本色());
        标题.隐藏();

        底层 = new 线性布局(this);
        底层.置高度("自动");

        控制 = new 线性布局(this);
        控制.置方向("水平");
        控制.置高度("自动");
        控制.置填充("8dp");
        控制.隐藏();

        左按钮 = new 布局_弹窗按钮(控制);
        
        线性布局 $右布局 = new 线性布局(控制);
        $右布局.置方向("水平");
        $右布局.置重力("右边");
        
        中按钮 = new 布局_弹窗按钮($右布局);
        右按钮 = new 布局_弹窗按钮($右布局);

    }
    
    public static class 布局_弹窗按钮 extends 线性布局 {

        public 文本视图 文本;

        public 布局_弹窗按钮(Context $上下文) {
            super($上下文);
            置宽度("自动");
            置高度("自动");
            置填充("8dp","8dp","16dp","16dp");
            置重力("中间");
            置背景("透明");
            文本 = new 文本视图(this);
            文本.置文本大小("4dp");
        }

        public 布局_弹窗按钮(ViewGroup $父视图) {
            this($父视图.getContext());
            加入到($父视图);
        }

    }

}

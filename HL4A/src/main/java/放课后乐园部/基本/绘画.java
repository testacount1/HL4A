package 放课后乐园部.基本;

import android.graphics.drawable.*;
import 放课后乐园部.绘画.*;

public class 绘画 {

    绘画() {}

    public static Drawable 透明() {
        return 生成背景(颜色.透明, 颜色.半透明);
    }

    public static Drawable 白色() {
        return 生成背景(颜色.白色, 颜色.白透明);
    }

    public static Drawable 黑色() {
        return 生成背景(颜色.黑色, 颜色.黑透明);
    }
    
    public static Drawable 主题() {
        return 生成背景(主题.基本色(),主题.基本深色());
    }

    public static Drawable 生成背景(Object $普通,Object $按下) {
        return new 按下变色绘画($普通, $按下);
    }

    public static Drawable 颜色转绘画(Object $颜色) {
        return new ColorDrawable(视图.检查颜色($颜色));
    }

    public static Drawable 图片转绘画(String $文件) {
        return new BitmapDrawable(图片.读取($文件));
    }

    public static Drawable 点九图转绘画(String $文件) {
        return new 点九图绘画(图片.读取($文件));
    }

}

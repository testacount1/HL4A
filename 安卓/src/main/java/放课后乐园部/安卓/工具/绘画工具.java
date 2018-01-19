package 放课后乐园部.安卓.工具;

import android.graphics.drawable.*;
import 放课后乐园部.安卓.绘画.*;
import 放课后乐园部.安卓.图形.*;

public class 绘画工具 {

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
        return 生成背景(主题工具.取主题颜色().取基本色(),主题工具.取主题颜色().取基本深色());
    }

    public static Drawable 生成背景(Object $普通,Object $按下) {
        return new 按下变色绘画($普通, $按下);
        //return new 涟漪绘画($普通,$按下);
    }

    public static Drawable 颜色转绘画(Object $颜色) {
        return new ColorDrawable(视图工具.检查颜色($颜色));
    }

    public static Drawable 图片转绘画(String $文件) {
        return new BitmapDrawable(图片工具.读取($文件));
    }

    public static Drawable 点九图转绘画(String $文件) {
        return new 点九图绘画(图片工具.读取($文件));
    }

}

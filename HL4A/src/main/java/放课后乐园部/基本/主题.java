package 放课后乐园部.基本;

import android.graphics.drawable.Drawable;
import 放课后乐园部.收集.集合;

public class 主题 {

    主题() {}

    public static 集合 当前颜色列表 = 集合.到集合(颜色.靛蓝);

    public static String 基本色() {
        return (String)当前颜色列表.get(5);
    }
    
    public static String 基本深色() {
        return (String) 当前颜色列表.读取(7);
    }
    
    public static String 强调色() {
        return (String) 当前颜色列表.读取(12);
    }
    
    public static String 强调深色() {
        return (String) 当前颜色列表.读取(13);
    }
    
    public static String 文本大小() {
        return "8dp";
    }
    
    public static String 大文本() {
        return "13dp";
    }

}

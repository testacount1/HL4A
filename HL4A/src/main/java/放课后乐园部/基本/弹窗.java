package 放课后乐园部.基本;

import android.widget.*;
import android.content.*;
import 放课后乐园部.事件.*;

public class 弹窗 {

    弹窗() {}

    public static Long 上次提示;
    public static Toast 提示对象;
    public static TextView 文本对象;

    public static void 初始化(Context $环境) {
        提示对象 = Toast.makeText($环境, "", Toast.LENGTH_SHORT);
        文本对象 = (TextView)提示对象.getView()
            .findViewById(android.R.id.message);
        上次提示 = 时间.时间戳() - 2333;
        颜色(主题.文字());
    }

    public static void 提示(Object $内容) {
        long $上次 = 上次提示;
        if ((上次提示 = 时间.时间戳()) - $上次 < 2333) {
            文本(文本() + "\n" + $内容.toString());
        } else 文本($内容.toString());
        显示();
    }
    
    public static void 线程提示(Object $内容) {
        处理.主线程(new 通用方法(){
                @Override
                public Object 调用(Object[] $参数) {
                    弹窗.提示($参数[0]);
                    return null;
                }
            },$内容);
    }

    public static void 文本(String $文本) {
        文本对象.setText($文本);
    }

    public static String 文本() {
        return (String) 文本对象.getText();
    }

    public static void 颜色(Object $颜色) {
        文本对象.setTextColor(视图.检查颜色($颜色));
    }

    public static void 显示() {
        提示对象.show();
    }

}

package 放课后乐园部.弹窗;

import android.content.*;
import android.widget.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.资源.布局.*;

public class 提示 {

    public static Toast 提示对象;
    public static 文本视图 文本对象;
    public static float 上次提示;

    public static void 初始化(Context $环境) {
        提示对象 = Toast.makeText($环境, "", Toast.LENGTH_SHORT);
        布局_提示 $视图 = new 布局_提示($环境);
        文本对象 = $视图.文本;
        提示对象.setView($视图);
        上次提示 = 时间.时间戳();
    }

    public static void 指定(final Object $内容,final String $颜色) {
        处理.主线程(new 通用方法(){
                @Override
                public Object 调用(Object[] $参数) {
                    Object $文本 = $内容;
                    if ($文本 == null) $文本 = "null";
					Float 上次 = new Float(上次提示);
					if (上次 - (上次提示 = 时间.时间戳()) < 233) {
						文本对象.置文本(文本对象.取文本() + $文本.toString());
					} else {
						文本对象.置文本($文本.toString());
					}
					上次提示 = 上次;
                    文本对象.置文本颜色(主题.基本色());
                    提示对象.show();
                    return null;
                }
            });
    }
	
	public static void 普通(final Object $内容) {
        指定($内容,主题.基本色());
    }

    public static void 警告(final Object $内容) {
        指定($内容,颜色.红色[5]);
    }

}

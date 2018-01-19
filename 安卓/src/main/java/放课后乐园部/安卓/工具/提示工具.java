package 放课后乐园部.安卓.工具;

import android.content.*;
import android.widget.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.安卓.图形.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.资源.布局.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.工具.*;

public class 提示工具 {

    public static Toast 提示对象;
    public static 文本视图 文本对象;
    public static long 上次提示;

    protected static void 初始化(Context $环境) {
        提示对象 = Toast.makeText($环境, "", Toast.LENGTH_SHORT);
        布局_提示 $视图 = new 布局_提示($环境);
        文本对象 = $视图.文本;
        提示对象.setView($视图);
        上次提示 = 时间工具.时间戳() - 233;
    }

    public static void 指定(final Object $内容,final Object $颜色) {
        处理工具.主线程(new 通用方法(){
                @Override
                public Object 调用(Object[] $参数) {
                    Object $文本 = $内容;
                    if ($文本 == null) $文本 = "null";
					long 上次 = 上次提示;
					if ((上次提示 = 时间工具.时间戳()) - 上次 < 233) {
						文本对象.置文本(文本对象.取文本() + "\n" + $内容.toString());
					} else {
						文本对象.置文本($内容.toString());
					}
                    文本对象.置文本颜色($颜色);
                    提示对象.show();
                    return null;
                }
            });
    }

	public static void 普通(final Object $内容) {
        指定($内容, 主题工具.取主题颜色().取基本色());
    }

    public static void 警告(final Object $内容) {
        指定($内容, 颜色.红色.取基本色());
    }

}

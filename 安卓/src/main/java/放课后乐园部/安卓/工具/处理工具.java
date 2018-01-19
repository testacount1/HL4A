package 放课后乐园部.安卓.工具;

import android.app.*;
import android.os.*;
import 放课后乐园部.事件.*;

public class 处理工具 {

    public static Looper 主处理 = Looper.getMainLooper();

    public static void 主线程(通用方法 $运行,Object... $参数) {
        指定(主处理, $运行, $参数);
    }

    public static void 指定(Looper $处理,通用方法 $方法,Object... $参数) {
        new Handler($处理).post(new 可运行类($方法, $参数));
    }



}

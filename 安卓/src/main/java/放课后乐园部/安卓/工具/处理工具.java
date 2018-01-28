package 放课后乐园部.安卓.工具;

import android.app.*;
import android.os.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.线程.*;
import 放课后乐园部.安卓.线程.*;
import 放课后乐园部.安卓.组件.*;
import 放课后乐园部.安卓.接口.*;

public class 处理工具 {

    public static Looper 主处理 = Looper.getMainLooper();

    public static void 主线程(通用方法 $运行,Object... $参数) {
        指定(主处理, $运行, $参数);
    }

    public static void 指定(Looper $处理,通用方法 $方法,Object... $参数) {
        new Handler($处理).post(new 可运行类($方法, $参数));
    }

    
    public static Object 同步(可处理的 $处理,final 通用方法 $方法,Object... $参数) {
        final 回调<Object> $回调 = new 回调<>();
        指定($处理.取处理器(), new 通用方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    $回调.返回(调用方法.事件($方法,$参数));
                    return null;
                }
            }, $参数);
        return $回调.等待();
    }
    
    public static Object 同步(final 通用方法<?> $方法,Object... $参数) {
        final 回调<Object> $回调 = new 回调<>();
        指定(主处理, new 通用方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    $回调.返回(调用方法.事件($方法,$参数));
                    return null;
                }
            }, $参数);
        return $回调.等待();
    }


}

package 放课后乐园部.组件;

import android.app.*;
import android.content.*;
import android.content.res.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.收集.*;

public class 基本应用 extends Application {

    public 集合 所有界面 = new 集合();
    
    public 通用方法 内存不足事件;
    public 通用方法 清理内存事件;
    public 通用方法 设置改变事件;
    public 通用方法 应用销毁事件;
    public 通用方法 附加上下文事件;

    public 通用方法 错误处理 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            错误.普通((Throwable)$参数[1]);
            return null;
        }
    };

    public 错误处理 处理 = new 错误处理(new 通用方法() {
            @Override
            public Object 调用(Object[] $参数) {
                调用方法.事件(错误处理, $参数);
                return null;
            }
        });

    @Override
    protected void attachBaseContext(Context $上下文) {
        super.attachBaseContext($上下文);
        调用方法.事件(附加上下文事件, $上下文);
    }

    @Override
    public void onConfigurationChanged(Configuration $新设置) {
        super.onConfigurationChanged($新设置);
        调用方法.事件(设置改变事件, $新设置);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        调用方法.事件(应用销毁事件);
    }
    
    public void 结束() {
        结束界面();
        onTerminate();
    }
    
    public void 结束界面() {
        for (基本界面 $界面 : 所有界面) {
            $界面.结束();
        }
    }


    @Override
    public void onLowMemory() {
        super.onLowMemory();
        调用方法.事件(内存不足事件);
    }

    @Override
    public void onTrimMemory(int $级别) {
        调用方法.事件(清理内存事件, $级别);
        super.onTrimMemory($级别);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        注入.最新加载器 = getClassLoader();
        Thread.setDefaultUncaughtExceptionHandler(处理);
        环境.设置(this);
        弹窗.初始化(this);
        签名检验();
        主题.置主题(颜色.靛蓝);
    }

    public static void 签名检验() {
        Class $MT = 反射.取类("cc.binmt.signature.PmsHookApplication");
        if ($MT != null) 弹窗.提示("您可能是盗版应用的受害者！");
    }

}

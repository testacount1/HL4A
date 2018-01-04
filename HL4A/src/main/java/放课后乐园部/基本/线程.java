package 放课后乐园部.基本;

import android.os.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.组件.*;

public class 线程 extends Thread {

    private 可运行类 启动方法;
    private Object 返回参数;
    public Looper L;

    private Long 启动延时;

    boolean 已结束 = false;

    public 线程(通用方法 $方法,Object... $参数) {
        启动方法 = new 可运行类($方法, $参数);
    }

    public 线程(long $延时,通用方法 $方法,Object... $参数) {
        this($方法, $参数);
        启动延时 = $延时;
    }

    @Override
    public void run() {
        Looper.prepare();
        L = Looper.myLooper();
        置错误处理对象(环境.读取().错误处理);
        if (启动延时 != null)
            线程.暂停(启动延时);
        返回参数 = 启动方法.执行();
        已结束 = true;
        Looper.loop();
    }

    public void 启动() {
        start();
    }

    public void 停止() {
        stop();
    }

    public void 让步() {
        yield();
    }
    
    public static void 暂停(long $毫秒) {
        try {
            Thread.sleep($毫秒);
        } catch (Exception $错误) {}

    }
    
    public static Thread 取当前线程() {
        return Thread.currentThread();
    }
    
    public static boolean 是线程() {
        return 取当前线程() instanceof 线程;
    }
    
    public static boolean 是主线程() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void 置错误处理(通用方法 $处理) {
        置错误处理对象(new 错误处理($处理));
    }

    public static void 置错误处理对象(错误处理 $处理) {
        Thread.setDefaultUncaughtExceptionHandler($处理);
    }

}

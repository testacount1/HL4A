package 放课后乐园部.线程;

import 放课后乐园部.事件.*;

public class 线程 extends Thread {

    private long 启动延时 = 0;
    private 通用方法 方法;
    private Object[] 参数 = new Object[0];
    private boolean 已完成 = false;
    private Object 返回值;

    public 线程(通用方法 $方法) {
        方法 = $方法;
    }

    public 线程(long $延时, 通用方法 $方法) {
        this($方法);
        启动延时 = $延时;
    }

    @Override
    public void run() {
        返回值 = 调用方法.事件(方法, 参数);
        已完成 = true;
    }

    public Object 等待() {
        while (!已完成) {
            暂停(100);
        }
        return 返回值;
    }

    public void 启动(Object... $参数) {
        参数 = $参数;
        start();
    }

    public void 暂停() {
        suspend();
    }

    public void 重启() {
        resume();
    }

    public static void 暂停(long $长度) {
        try {
            Thread.sleep($长度);
        } catch (InterruptedException $错误) {
        }
    }

    public static Thread 取当前线程() {
        return Thread.currentThread();
    }

    public static boolean 是线程() {
        return 取当前线程() instanceof 线程;
    }

    public static void 置错误处理(通用方法 $处理) {
        置错误处理对象(new 错误处理($处理));
    }

    public static void 置错误处理对象(错误处理 $处理) {
        Thread.setDefaultUncaughtExceptionHandler($处理);
    }

    public 通用方法 启动 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            启动();
            return null;
        }
    };

}

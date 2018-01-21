package 放课后乐园部.事件;

public class 错误处理 implements Thread.UncaughtExceptionHandler {

    public 通用方法 处理;
    
    public 错误处理(通用方法 $方法) {
        处理 = $方法;
    }
    
    @Override
    public void uncaughtException(Thread $线程,Throwable $错误) {
        调用方法.安全(处理,$线程,$错误);
    }

}

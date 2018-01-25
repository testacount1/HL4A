package 放课后乐园部.线程;

public class 回调<类型> {

    private volatile 类型 内容;

    public 类型 等待() {
        synchronized (this) {
            if (内容 != null)
                return 内容;
            try {
                wait();
            } catch (InterruptedException $错误) {
                throw new RuntimeException($错误);
            }
            return 内容;
        }
    }

    public void 返回(类型 $内容) {
        synchronized (this) {
            内容 = $内容;
            notifyAll();
        }
    }

}

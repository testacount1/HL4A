package 放课后乐园部.线程;

public class 轮询回调<类型> implements 可回调的<类型> {

    private volatile 类型 内容;
    private int 速度;

    public 轮询回调(int $速度) {
        速度 = $速度;
    }

    @Override
    public 类型 等待() {
        while (内容 == null) {
            线程.暂停(速度);
        }
        return 内容;
    }

    @Override
    public void 返回(类型 $内容) {
        内容 = $内容;
    }

}

package 放课后乐园部.基本;

import java.util.concurrent.atomic.*;
import 放课后乐园部.事件.*;

public class 计数 {
    
    AtomicInteger 数量 = new AtomicInteger(0);
    
    public 通用方法 加一事件;
    
    synchronized void 处理(int $数量) {
        调用方法.事件(加一事件,$数量);
    }
    
    public void 加一() {
        处理(数量.addAndGet(1));
    }
    
    public int 读取() {
        return 数量.get();
    }
    
}

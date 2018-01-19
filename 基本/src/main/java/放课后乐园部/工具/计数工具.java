package 放课后乐园部.工具;

import java.util.concurrent.atomic.*;
import 放课后乐园部.事件.*;

public class 计数工具 {
    
    AtomicInteger 数量 = new AtomicInteger(0);
        
    public void 加一() {
       数量.addAndGet(1);
    }
    
    public int 读取() {
        return 数量.get();
    }
    
}

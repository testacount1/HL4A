package 放课后乐园部.网络;

import 放课后乐园部.基本.*;
import 放课后乐园部.事件.*;

public class 网络线程 extends Thread {
    
    String 地址;
    通用方法 回调;
    网络连接 连接;
    
    public 网络线程(String $地址,通用方法 $处理,通用方法 $回调) {
        地址 = $地址;
        回调 = $回调;
        网络连接 $连接 = new 网络连接(地址);
        调用方法.安全($处理,$连接);
    }

    @Override
    public void run() {
       连接.取输出流();
       处理.主线程(回调,连接);
    }
    
}

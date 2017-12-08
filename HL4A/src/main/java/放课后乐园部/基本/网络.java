package 放课后乐园部.基本;
import 放课后乐园部.网络.*;

public class 网络 {
    
    网络() {}
    
    public static String 取源(String $地址) {
        return new 网络连接($地址).读取字符();
    }
    
    
}

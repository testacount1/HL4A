package 放课后乐园部.基本;

import 放课后乐园部.脚本.*;

public class 脚本 {
    
    脚本() {}
    
    public static JavaScript JS() {
        return new JavaScript();
    }
    
    public static BeanShell BSH() {
        return new BeanShell();
    }
    
}

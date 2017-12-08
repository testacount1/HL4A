package 放课后乐园部.反射;

import java.lang.reflect.*;
import 放课后乐园部.基本.*;

public class 变量 {
    
    Field 变量对象;
    Object 实例对象;
    
    public 变量(Field $变量) {
        变量对象 = $变量;
    }
    
    public 变量(Field $变量,Object $实例) {
        变量对象 = $变量;
        实例对象 = $实例;
    }
    
    public Object 读取() {
        return 反射.读变量(变量对象,实例对象);
    }
    
    public void 设置(Object $内容) {
        反射.改变量(变量对象,实例对象,$内容);
    }
    
}

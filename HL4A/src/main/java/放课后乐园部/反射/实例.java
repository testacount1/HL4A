package 放课后乐园部.反射;

import java.lang.reflect.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.收集.*;

public class 实例 {

    哈希表 变量表 = new 哈希表();
    Class 类对象;
    Object 实例对象;

    public static 实例 取实例(Object $实例) {
        return new 实例($实例.getClass(), $实例);
    }

    public 实例(Class $类,Object $实例) {
        类对象 = $类;
        实例对象 = $实例;
    }

    public Object 取实例() {
        return 实例对象;
    }

    public Class 取类() {
        return 类对象;
    }

    public 方法 取方法(String $方法名,Object... $参数) {
        Method $方法 = 反射.取方法(类.取类(类对象).取类对象(), $方法名, $参数);
        return new 方法(this, $方法, $参数);
    }

    public 变量 取变量(String $变量名) {
        try {
            Field $变量 = 反射.取变量(类对象, $变量名);
            if ($变量 == null)return null;
            if (!变量表.检查($变量))
                变量表.设置($变量,new 变量($变量,实例对象));
            return (变量)变量表.读取($变量);
        } catch (Exception $错误) {}
        return null;
    }
    

}

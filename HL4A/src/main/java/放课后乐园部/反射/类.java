package 放课后乐园部.反射;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import 放课后乐园部.基本.反射;
import 放课后乐园部.收集.哈希表;

public class 类 {

    public static 哈希表 类表 = new 哈希表();

    public 哈希表 变量表 = new 哈希表();

    Class 类对象;

    实例 单例;

    public static 类 取类(Class $类) {
        if (!类表.检查($类))
            类表.设置($类, new 类($类));
        return (类) 类表.读取($类);
    }

    public static 类 取类(String $类名) {
        Class $类 = 反射.取类($类名);
        return 取类($类);
    }

    public static 类 取类(String $类名,ClassLoader $类加载器) {
        Class $类 = 反射.取类($类名, $类加载器);
        return 取类($类);
    }

    public 类(Class $类) {
        类对象 = $类;
    }

    public 类(String $类名) {
        Class $类 = 反射.取类($类名);
        类对象 = $类;
    }

    public 类(String $类名,ClassLoader $类加载器) {
        Class $类 = 反射.取类($类名, $类加载器);
        类对象 = $类;
    }

    public Class 取类对象() {
        return 类对象;
    }

    public 变量 取变量(String $变量名) {
        try {
            Field $变量 = 反射.取变量(类对象, $变量名);
            if ($变量 == null)return null;
            if (!变量表.检查($变量))
            变量表.设置($变量,new 变量($变量));
            return (变量)变量表.读取($变量);
        } catch (Exception $错误) {}
        return null;
    }

    public 方法 取方法(String $方法名) {
        Method $方法 = 反射.取方法(类对象, $方法名);
        if ($方法 == null)return null;
        return new 方法($方法);
    }

    public 方法 取方法(String $方法名,Object... $参数) {
        Method $方法 = 反射.取方法(类对象, $方法名, $参数);
        if ($方法 == null)return null;
        return new 方法($方法, $参数);
    }

    public 实例 取实例(Object... $参数) {
        if (单例 == null)
            单例 = new 实例(this.getClass(), 反射.实例化(类对象, $参数));
        return 单例;
    }

    public 实例 取新实例(Object... $参数) {
        return new 实例(this.getClass(), 反射.实例化(类对象, $参数));
    }

}

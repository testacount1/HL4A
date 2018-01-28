package 放课后乐园部.事件;

import java.lang.reflect.*;
import java.util.*;
import 放课后乐园部.收集.*;

public class 动态代理 implements InvocationHandler {

    public static Class v = void.class;

    public 哈希表<String,通用方法> 方法表;

    public 动态代理(Map<String,通用方法> $列表) {
        方法表 = new 哈希表<>($列表);
    }

    public Object 代理(Class<?> $类) {
        return Proxy.newProxyInstance(getClass().getClassLoader(), $类.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object $对象,Method $方法,Object[] $参数) {
        
        Class<?> $返回类型 = $方法.getReturnType();
        
        通用方法 $通用方法 = null;
        
        Object $方法对象 = 方法表.读取($方法.getName());
        
        if ($方法对象 instanceof 通用方法) {
            
            $通用方法 = (通用方法)$方法对象;
            
        }
        
        Object $返回值 = 调用方法.事件($通用方法,$参数);
        
        if ($返回类型 == v) $返回值 = null;
        
        return $返回值;
       
    }

}

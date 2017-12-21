package 放课后乐园部.反射;

import java.lang.reflect.Method;
import 放课后乐园部.基本.反射;

public class 方法 {

    private Object 实例对象 = null;;
    private Method 方法对象;
    private Object 参数[];
    private Boolean 是静态方法;

    public static 方法 取方法(Object $实例,String $方法名,Object... $参数) {

        Method $方法 = 反射.取方法($实例.getClass(), $方法名, $参数);

        if ($方法 == null)return null;

        return new 方法($实例, $方法, $参数);
    }

    public 方法(Object $实例,Method $方法,Object... $参数) {

        实例对象 = $实例;
        方法对象 = $方法;
        if ($参数 != null) 参数 = $参数;
        是静态方法 = 反射.是静态方法($方法);
    }

    public 方法(Method $方法,Object... $参数) {
        方法对象 = $方法;
        if ($参数 != null) 参数 = $参数;
        是静态方法 = 反射.是静态方法($方法);
    }

    public Method 取方法对象() {
        return 方法对象;
    }

    public Object 调用() {
        return 反射.调用方法(实例对象, 方法对象, 参数);
    }

    public Object 执行(Object... $参数) {
        return 反射.调用方法(实例对象, 方法对象, $参数);
    }

}

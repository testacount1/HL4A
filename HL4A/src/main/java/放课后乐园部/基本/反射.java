package 放课后乐园部.基本;

import 放课后乐园部.注解.状态.*;
import 放课后乐园部.注解.注释.*;
import java.lang.reflect.*;


public class 反射  {

    private 反射() {}


    public static Class 取类(String $类名) {
        try {
            Class $类 =  Class.forName($类名);
            if ($类 == null) {
                for (注入.类加载器 $加载器 : 注入.所有加载器) {
                    if ($类 != null)break;
                    Class.forName($类名, false, $加载器);
                }
            }
            return $类;
        } catch (Exception $错误) {}
        return null;
    }


    public static Class 取类(String $类名,ClassLoader $类加载器) {
        try {
            Class $类 = Class.forName($类名, false, $类加载器);
            if ($类 == null)
                $类 = 取类($类名);
            return $类;
        } catch (Exception $错误) {}
        return null;
    }
    

    public static Object 实例化(
        @参数("类") Class $类,
        @参数("参数") Object... $参数) {
        try {
            Class[] $参数类组 = 取参数类组($参数);
            Constructor cons = $类.getConstructor($参数类组);   
            return cons.newInstance($参数);
        } catch (Exception $错误) {}
        return null;
    }


    public static Field 取变量(
        @参数("类") Class $类,
        @参数("变量") String $变量名) {
        try {
            Field $变量 = $类.getDeclaredField($变量名);
            return  $变量;
        } catch (Exception $错误) {}
        return null;
    }


    @不建议使用

    public static Method 取方法(
        @参数("类") Class $类,
        @参数("参数长度") int $参数长度,
        @参数("方法名") String $方法名) {
        Method $所有[] = $类.getDeclaredMethods();
        for (Method $方法 : $所有) {
            if (!$方法.getName().equals($方法名)) continue;
            Class $类型组[] = $方法.getParameterTypes();
            int $需要长度 = $类型组.length;
            if ($参数长度 != $需要长度) continue;
            return $方法;
        }
        return null;
    }


    public static Method 取方法(
        @参数("类") Class $类,
        @参数("方法名") String $方法名,
        @参数("参数") Object... $参数) {
        Method $所有[] = $类.getDeclaredMethods();
        for (Method $方法 : $所有) {
            if (!$方法.getName().equals($方法名)) continue;
            int $参数长度 = $参数.length;
            Class $类型组[] = $方法.getParameterTypes();
            int $需要长度 = $类型组.length;
            if ($参数长度 < $需要长度) continue;
            boolean $结束 = false;
            for (int $键值 = 0;$键值 == $参数长度 - 1;$键值 ++) {
                Class $值;
                if ($键值 > $需要长度 - 1)
                    $值 = $类型组[$需要长度 - 1];
                else $值 = $类型组[$键值];
                if (!$值.isAssignableFrom($参数[$键值].getClass())) {
                    $结束 = true;break;
                }
            }
            if ($结束) continue;
            return $方法;
        }
        return null;
    }


    public static Object 调用方法(
        @参数("实例 可NULL") Object $实例,
        @参数("方法对象") Method $方法,
        @参数("传入参数") Object... $参数) {
        try {
            return $方法.invoke($实例, $参数);
        } catch (Exception $错误) {}
        return null;
    }

    @无法使用

    @出错("所有都返回一个结果,为什么呢？")
    public static boolean 是静态方法(
        @参数("方法对象") Method $方法) {
        return Modifier.isStatic($方法.getModifiers());
    }

    public static boolean 是静态变量(
        @参数("变量对象") Field $变量) {
        return Modifier.isStatic($变量.getModifiers());
    }


    public static Class[] 取参数类组(Object... $参数) {
        Class[] $参数类组 = new Class[$参数.length];
        for (int i = 0, j = $参数.length; i < j; i++) {
            $参数类组[i] = $参数[i].getClass();
        }
        return $参数类组;
    }


}

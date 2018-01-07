package 放课后乐园部.基本;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class 反射  {

    反射() {}

    public static Class<?> 取自身类(String $相对) {
        return 取类(应用.取包名() + "." + $相对);
    }

    public static Class<?> 取类(String $类名) {
        return 取类($类名, 注入.最新加载器);
    }

    public static Class<?> 取类(String $类名,ClassLoader $类加载器) {
        try {
            Class<?> $类 = Class.forName($类名, false, $类加载器);
            return $类;
        } catch (Exception $错误) {}
        return null;
    }


    public static Object 实例化(Class $类,Class[] $类组,Object... $参数) {
        try {
            Constructor cons = $类.getConstructor($类组);   
            return cons.newInstance($参数);
        } catch (Exception $错误) {
            错误.抛出($错误);
        }
        return null;
    }


    public static Field 取变量(Object $实例,String $变量名) {
        Class $类 = $实例.getClass();
        Field $变量 = null;
        while ($类 != null && $变量 == null) {
            try {
                $变量 = $类.getDeclaredField($变量名);
                $变量.setAccessible(true);
                return $变量;
            } catch (NoSuchFieldException $错误) {
                $类 = $类.getSuperclass();
            }
        }
        return null;
    }

    public static Object 读变量(Field $变量) {
        return 读变量($变量, null);
    }

    public static Object 读变量(Field $变量,Object $实例) {
        try {
            return $变量.get($实例);
        } catch (Exception $错误) {}
        return null;
    }

    public static void 改变量(Field $变量,Object $内容) {
        改变量($变量, null, $内容);
    }

    public static void 改变量(Field $变量,Object $实例,Object $内容) {
        try {
            $变量.set($实例, $内容);
        } catch (Exception $错误) {
            错误.抛出($错误);
        }
    }

    public static Method 取首位方法(Class $类,String $方法名) {
        Method[] $所有 = $类.getDeclaredMethods();
        for (Method $单个 : $所有) {
            if ($单个.getName().equals($方法名)) {
                return $单个;
            }
        }
        return null;
    }

    public static Method 取方法(Class $类,String $方法名) {
        return 取方法($类, $方法名, new Class[0]);
    }

    public static Method 取方法(Class $类,String $方法名,Class... $参数) {
        Method $方法 = null;
        while ($类 != null) {
            try {
                $方法 = $类.getDeclaredMethod($方法名, 取参数类组($参数));
                $方法.setAccessible(true);
                return $方法;
            } catch (NoSuchMethodException $错误) {
                $类 = $类.getSuperclass();
            }
        }
        return null;
    }

    /*
     public static Method 取方法(Class $类,String $方法名,Object... $参数) {
     Method $所有[] = $类.getMethods();
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

     */


    public static Object 调用方法(Object $实例,Method $方法,Object... $参数) {
        try {
            return $方法.invoke($实例, $参数);
        } catch (Exception $错误) {}
        return null;
    }


    public static boolean 是静态方法(Method $方法) {
        return Modifier.isStatic($方法.getModifiers());
    }

    public static boolean 是静态变量(Field $变量) {
        return Modifier.isStatic($变量.getModifiers());
    }


    public static Class[] 取参数类组(Object... $参数) {
        if ($参数 instanceof Class[])
            return (Class[])$参数;
        Class[] $参数类组 = new Class[$参数.length];
        for (int i = 0, j = $参数.length; i < j; i++) {
            $参数类组[i] = $参数[i].getClass();
        }
        return $参数类组;
    }


}

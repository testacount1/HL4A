package 放课后乐园部.工具;

import 放课后乐园部.事件.*;

public class 错误工具 {

    public static String 取错误信息(Throwable $错误) {
        return $错误.getMessage();
    }

    public static String 取错误位置(Throwable $错误) {
        return 取错误位置($错误, -1);
    }

    public static String 取错误位置(Throwable $错误, int $最大) {
        StackTraceElement $错误位置数组[] = $错误.getStackTrace();
        StringBuffer $错误位置信息 = new StringBuffer("");
        int $当前数量 = 0;
        for (StackTraceElement 单个错误位置 : $错误位置数组) {
            if ($当前数量 == $最大)
                break;
            $当前数量++;
            $错误位置信息.append("\n" + "在: " + 单个错误位置);
        }
        return $错误位置信息.toString();
    }

    public static String 取错误类型(Throwable $错误) {

        StringBuffer $错误类型 = new StringBuffer("");

        $错误类型.append("\n异常 : " + $错误.getClass().getCanonicalName() + "\n");

        switch ($错误.getClass().getName()) {
        case "android.os.NetworkOnMainThreadException":
            $错误类型.append("网络请求不能在主线程执行。请使用线程或异步网络请求");
            break;
        case "java.lang.IllegalArgumentException":
            $错误类型.append("非法数据异常。或是类型转换出错。");
            break;
        case "java.lang.ArrayIndexOutOfBoundsException":
            $错误类型.append("数组索引越界异常。数组的索引值为负数或大于等于数组大小。");
            break;
        case "java.lang.ArithmeticException":
            $错误类型.append("算术条件异常。运算错误的算数语句。");
            break;
        case "java.lang.NullPointerException":
            $错误类型.append("空指针异常。对空值进行实例化/取长度操作。");
            break;
        case "java.lang.ArrayStoreException":
            $错误类型.append("数组存储异常。向数组中存放非数组声明类型对象。");
            break;
        case "java.lang.ClassCastException":
            $错误类型.append("类构造异常。强制将类的实例构造为不是父类或者子类的实例时抛出该异常。该异常经常被称为强制类型转换异常。");
            break;
        case "java.lang.CloneNotSupportedException":
            $错误类型.append("不支持克隆异常。当没有实现Cloneable接口或者不支持克隆方法时,调用其clone()方法则抛出该异常。");
            break;
        case "java.lang.EnumConstantNotPresentException":
            $错误类型.append("枚举常量不存在异常。当应用试图通过名称和枚举类型访问一个枚举对象，但该枚举对象并不包含常量时，抛出该异常。");
            break;
        case "java.lang.IllegalAccessException":
            $错误类型.append("违法的访问异常。无法通过反射方式创建某个类的实例、访问该类属性、调用该类方法，而当时又无法访问类的、属性的、方法的或构造方法的定义时抛出。");
            break;
        case "java.lang.IllegalStateException":
            $错误类型.append("违法的状态异常。当在Java环境和应用尚未处于某个方法的合法调用状态，而调用了该方法时，抛出该异常。");
            break;
        case "java.lang.IllegalThreadStateException":
            $错误类型.append("违法的线程状态异常。当线程尚未处于某个方法的合法调用状态，而调用了该方法时，抛出异常。");
            break;
        case "java.lang.IndexOutOfBoundsException":
            $错误类型.append("索引越界异常。当访问某个序列的索引值小于0或大于等于序列大小时，抛出该异常。");
            break;
        case "java.lang.InstantiationException":
            $错误类型.append("实例化异常。当试图通过newInstance()方法创建某个类的实例，而该类是一个抽象类或接口时，抛出该异常。");
            break;
        case "java.lang.InterruptedException":
            $错误类型.append("被中止异常。当某个线程处于长时间的等待、休眠或其他暂停状态，而此时其他的线程通过Thread的interrupt方法终止该线程时抛出该异常。");
            break;
        case "java.lang.NegativeArraySizeException":
            $错误类型.append("数组大小为负值异常。当使用负数大小值创建数组时抛出该异常。");
            break;
        case "java.lang.NoSuchFieldException":
            $错误类型.append("属性不存在异常。当访问某个类的不存在的属性时抛出该异常。");
            break;
        case "java.lang.NoSuchMethodException":
            $错误类型.append("方法不存在异常。当访问某个类的不存在的方法时抛出该异常。");
            break;
        case "java.lang.NumberFormatException":
            $错误类型.append("数字格式异常。当试图将一个String转换为指定的数字类型，而该字符串确不满足数字类型要求的格式时，抛出该异常。");
            break;
        case "android.content.ActivityNotFoundException":
            $错误类型.append("界面不存在异常，可能是没有在应用清单声明该Activity。");
            break;
        case "android.view.WindowManager$BadTokenException":
            $错误类型.append("访问界面异常,请在界面创建完成后进行对界面的操作。");
            break;
        }

        return $错误类型.toString();
    }

    public static String 取整个错误(Throwable $错误) {
        return 取错误类型($错误) + "\n" + 取错误信息($错误) + "\n" + 取错误位置($错误);
    }

    public static void 抛出(Exception $错误) {
        throw new RuntimeException($错误);
    }

    public static void 内容(String $错误内容) {
        throw new RuntimeException($错误内容);
    }

}

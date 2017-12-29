package 放课后乐园部.事件;
import 放课后乐园部.基本.*;

public class 调用方法 {

    private 调用方法() {};

    public static Object 普通(通用方法 $方法,Object... $参数) {
        try {
            return $方法.调用($参数);
        } catch (Exception $错误) {
            错误.普通($错误);
        }
        return null;

    }

    public static Object 安全(通用方法 $方法,Object... $参数) {

        try {
            return $方法.调用($参数);
        } catch (Exception $错误) {}
        return null;

    }

    public static Object 事件(通用方法 $方法,Object... $参数) {

        try {
            if ($方法 != null)
                return $方法.调用($参数);
        } catch (Exception $错误) {
            错误.普通($错误);
        }
        return null;

    }


}

package 放课后乐园部.基本;

public class 断言 {
    
    public static void 为空(Object $对象,String $内容) {
        if ($对象 == null) {
            错误.内容($内容);
        }
    }
    
    public static void 为真(Object $对象,String $内容) {
        if ($对象 == true) {
            错误.内容($内容);
        }
    }
    
    public static void 为假(Object $对象,String $内容) {
        if ($对象 == false) {
            错误.内容($内容);
        }
    }
    
    public static void 在主线程(String $内容) {
        if (线程.是主线程()) {
            错误.内容($内容);
        }
    }
    
    public static void 不在主线程(String $内容) {
        if (!线程.是主线程()) {
            错误.内容($内容);
        }
    }
    
}

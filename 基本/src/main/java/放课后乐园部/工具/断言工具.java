package 放课后乐园部.工具;

public class 断言工具 {

    public static void 真(Boolean $对象, String $内容) {
        if ($对象 != true) {
            错误工具.内容($内容);
        }
    }

    public static void 假(Boolean $对象, String $内容) {
        if ($对象 != false) {
            错误工具.内容($内容);
        }
    }

}

package h.ide.util;
import 放课后乐园部.基本.*;
import 放课后乐园部.数据.*;

public class 工程管理 {

    public static String 工程目录 = "%HL4A";
    public static String 配置文件 = "应用.json";

    public static 安卓工程 创建工程(String $名称) {
        String $目录 = 工程目录 + "/" + $名称;
        if (!文件.是目录($目录)) {
            文件.创建目录($目录);
        }
        安卓工程 $工程 = new 安卓工程();
        $工程.置目录($名称);
        return null;
    }

}

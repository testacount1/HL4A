package h.ide.util;
import 放课后乐园部.基本.*;
import 放课后乐园部.数据.*;

public class 工程管理 {

    public static String 工程目录 = "%HL4A";
    public static String 配置文件 = "应用.json";

    public static 安卓工程 读取(String $地址) {
        String $文件 = 工程目录 + "/" + $地址 + "/" + 配置文件;
        if (!文件.是文件($文件)) {
            return null;
        } else {
            安卓工程 $工程 = (安卓工程)Json.解析类(字符.读取($文件), 安卓工程.class);
            return $工程;
        }
    }

    public static 安卓工程 新建(String $地址) {
        文件.删除(工程目录 + "/" + $地址);
        String $文件 = 工程目录 + "/" + $地址 + "/" + 配置文件;
        文件.创建文件($文件);
        安卓工程 $工程 = new 安卓工程();
        $工程.工程名 = $地址;
        return $工程;
    }

    public void 保存(String $地址,安卓工程 $工程) {
        字符.保存(工程目录 + "/" + $地址 + "/" + 配置文件, Json.转换($工程));
    }

}

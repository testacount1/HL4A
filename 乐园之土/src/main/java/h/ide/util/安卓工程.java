package h.ide.util;
import 放课后乐园部.收集.*;
import 放课后乐园部.数据.*;
import 放课后乐园部.基本.*;

public class 安卓工程 {

    public String 工程名 = "你好 世界";
    public String 包名 = "com.hl4a.hello";
    public String 版本名 = "1.0";
    public int 版本号 = 1;
    public 集合 权限 = new 集合();

    private String 目录 = "";

    public void 置目录(String 目录) {
        this.目录 = 目录;
    }

    public String 取目录() {
        return 目录;
    }

    public String 取目录(String $文件夹) {
        return 工程目录 + "/" + 目录 + "/" + $文件夹;
    }

    public String 取目录(String $文件夹,String $文件) {
        return 工程目录 + "/" + 目录 + "/" + $文件夹 + "/" + $文件;
    }

    public static String 工程目录 = "%HL4A";
    public static String 配置文件 = "应用.json";

    public static 安卓工程 读取(String $地址) {
        String $文件 = 工程目录 + "/" + $地址 + "/" + 配置文件;
        if (!文件.是文件($文件)) {
            return null;
        } else {
            安卓工程 $工程 = (安卓工程)Json.解析类(字符.读取($文件), 安卓工程.class);
            $工程.置目录($地址);
            return $工程;
        }
    }
    
    public static 安卓工程 新建(String $地址) {
        文件.删除($地址);
        文件.创建文件($地址);
        安卓工程 $工程 = new 安卓工程();
        $工程.工程名 = $地址;
        $工程.置目录($地址);
        $工程.保存();
        return $工程;
    }

    public void 保存() {
        字符.保存(工程目录 + "/" + 目录 + "/" + 配置文件, Json.转换(this));
    }

}

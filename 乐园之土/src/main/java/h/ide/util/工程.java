package h.ide.util;

import h.ide.util.*;
import 放课后乐园部.工具.*;
import 放课后乐园部.数据.*;
import 放课后乐园部.安卓.工具.*;
import java.io.*;

public class 工程 {

    public static String 工程目录 = "%HL4A";
    public static String 配置文件 = "应用.json";

    public String 配置;
    public 工程信息 信息;

    public void 保存() {
        字符工具.保存(转换地址(配置), JSON工具.转换(信息));
    }

    public static 工程 读取(String $地址) {
		if (文件工具.是文件(转换地址($地址))) {
			工程 $工程 = new 工程();
			$工程.配置 = $地址;
			$工程.信息 = (工程信息)JSON工具.解析类(字符工具.读取(转换地址($地址)), 工程信息.class);
			return $工程;
		}
		return null;
    }

    public static boolean 创建(String $工程名,String $包名) {
        if (检查($包名)) return false;
        工程 $工程 = new 工程();
        $工程.信息 = new 工程信息();
        $工程.配置 = $包名;
        $工程.信息.工程名 = $工程名;
        $工程.信息.包名 = $包名;
        $工程.保存();
        return true;
    }

    public static boolean 检查(String $地址) {
        if (文件工具.是文件(转换地址($地址))) {
            return true;
        }
        return false;
    }

    public static String 转换地址(String $地址) {
        return 工程目录 + "/" + $地址 + "/" + 配置文件;
    }
	
	public String 取地址() {
		return 工程目录 + "/" + 配置;
	}
	
	public String 取地址(String... $相对) {
		return new File(工程目录 + "/" + 配置 + "/" + 字符工具.分解($相对,"/")).getPath();
	}

}

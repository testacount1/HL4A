package 放课后乐园部.脚本;

import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.收集.*;
import java.io.*;

public class 脚本管理 {

    public static boolean 是脚本(String $地址) {
        return 取脚本文件类型($地址) != null;
    }

    public static String 取脚本文件类型(String $地址) {
        String $类型 = 字符.小写(字符.截取结束($地址, ".", null));
        switch ($类型) {
            case "lua":case "luac":
                return "lua";
            case "js":
                return "js";
            case "bsh":
                return "bsh";
            case "java":
                return "java";
        }
        return null;
    }

}

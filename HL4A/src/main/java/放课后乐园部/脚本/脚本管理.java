package 放课后乐园部.脚本;

import android.content.*;
import android.os.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.组件.*;
import 放课后乐园部.收集.*;
import java.io.*;

public class 脚本管理 {

    public static boolean 启动服务(Context $上下文,String $类型) {

        String $类名 = 取脚本类($类型, "Service");

        if (服务.已启动($类名))return true;

        Class $类 = 反射.取类($类名);

        if ($类 != null) {

            $上下文.startService(new Intent($上下文, $类));

            return true;

        }

        return false;

    }

    public static 服务.连接处理 绑定服务(基本界面 $界面,String $类型,通用方法 $成功,通用方法 $断开) {
        if (服务.启动($界面, $类型) == false) return null;
        服务.连接处理 $处理 = new 服务.连接处理($成功, $断开);
        Class $类 = 反射.取类(取脚本类($类型, "Service"));
        $界面.bindService(new Intent($界面, $类), $处理, Context.BIND_AUTO_CREATE);
        $界面.服务连接.添加($处理);
        return $处理;
    }

    public static String 取脚本文件类型(String $地址) {
        String $类型 = 字符.小写(字符.截取结束($地址, ".", null));
        switch ($类型) {
            case "lua":case "luac":
                return "lua";
            case "js":
                return "js";
            case "bsh":case "java":
                return "bsh";
        }
        return $类型;
    }

    public static String 取脚本类(String $文件,String $后缀) {

        String $类名 = "";

        switch (取脚本文件类型($文件)) {

            default: case "js":
                $类名 = "JS";break;
            case "lua":case "luac":
                $类名 = "Lua";break;
            case "bsh":case "java":
                $类名 = "BSH";break;

        }

        $类名 = (应用.取包名() + "." + $类名 + $后缀);

        return $类名;

    }

}

package 放课后乐园部.脚本;

import android.content.*;
import android.os.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.组件.*;

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

    public static void 跳转界面(基本界面 $界面,String $文件) {

        String $类名 = 取脚本类(字符.截取结束($文件, ".", null), "Activity");
        Class $类 = 反射.取类($类名);
        Intent $意图 = new Intent($界面, $类);
        $意图.putExtra("文件",$文件);
        $界面.startActivity($意图);
        
    }

    public static String 取脚本类(String $类型,String $后缀) {

        String $类名 = "";

        switch (字符.小写($类型)) {

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

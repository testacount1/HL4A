package 放课后乐园部.组件;

import 放课后乐园部.收集.*;
import cn.nukkit.command.*;
import 放课后乐园部.事件.*;

public class 插件命令 {
    
    static 基本插件 插件;
    static 哈希表 处理命令;
    
    public static void 初始化(基本插件 $插件) {
        插件 = $插件;
        处理命令 = new 哈希表();
    }
    
    public static void 监听命令(String $名称,通用方法 $方法) {
        处理命令.设置($名称,$方法);
    }
    
    public static boolean 接收事件(CommandSender $发送者,Command $命令,String $命令名称,String[] $参数) {
        Object $返回值 = null;
        if (处理命令.检查($命令名称)) {
            通用方法 $方法 = (通用方法)处理命令.读取($命令名称);
            $返回值 = $方法.调用(new 命令处理($发送者,$命令,$命令名称,$参数));
        } else if(处理命令.检查("默认")) {
            通用方法 $方法 = (通用方法)处理命令.读取("默认");
            $返回值 = $方法.调用(new 命令处理($发送者,$命令,$命令名称,$参数));
        }
        return $返回值.equals(true);
    }
    
    public static class 命令处理 {
        
        CommandSender 发送者;
        Command 命令;
        String 命令名称;
        String[] 参数;
        
        public 命令处理(CommandSender $发送者,Command $命令,String $命令名称,String[] $参数) {
            发送者 = $发送者;
            命令 = $命令;
            命令名称 = $命令名称;
            参数 = $参数;
        }
        
        public boolean 是控制台() {
            return 发送者 instanceof ConsoleCommandSender;
        }
        
        public boolean 是玩家() {
            return 发送者.isPlayer();
        }
        
 
        
    }
    
    
}

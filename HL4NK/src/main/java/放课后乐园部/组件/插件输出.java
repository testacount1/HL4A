package 放课后乐园部.组件;

import cn.nukkit.plugin.*;
import cn.nukkit.*;
import cn.nukkit.utils.*;
import java.lang.reflect.*;
import 放课后乐园部.基本.*;

public class 插件输出 {

    插件输出() {}
    
    static Logger 日志;
    static Field 前缀;
    
    public static void 初始化(基本插件 $插件) {
        日志 = $插件.getLogger();
        前缀 = 反射.取变量(日志,"pluginName");
        前缀("[放课后乐园部-" + $插件.取名称() + "]");
    }
    
    public static void 前缀(String $名称) {
        反射.改变量(前缀,日志,$名称);
    }

    public static void 信息(String $内容) {
        日志.info($内容);
    }

    public static void 提示(String $内容) {
        日志.warning($内容);
    }

    public static void 日志(String $内容) {
        日志.debug($内容);
    }

    public static void 注意(String $内容) {
        日志.notice($内容);
    }
    
}

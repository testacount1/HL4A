package 放课后乐园部.组件;

import cn.nukkit.plugin.PluginBase;
import 放课后乐园部.脚本.*;
import cn.nukkit.*;
import cn.nukkit.plugin.*;
import 放课后乐园部.收集.*;
import cn.nukkit.command.*;

public class 基本插件 extends PluginBase {

    public PluginDescription 信息;
    
    @Override
    public void onLoad() {
        super.onLoad();
        信息 = getDescription();
        cn.nukkit.Server.getInstance();
        插件数据.初始化(this);
        插件输出.初始化(this);
        插件命令.初始化(this);
    }
    
    public String 取名称() {
        return 信息.getName();
    }

    public String 取全名() {
        return 信息.getFullName();
    }

    @Override
    public boolean onCommand(CommandSender $发送者,Command $命令,String $命令名称,String[] $参数) {
        return 插件命令.接收事件($发送者,$命令,$命令名称,$参数);
    }
    
}

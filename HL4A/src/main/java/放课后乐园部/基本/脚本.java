package 放课后乐园部.基本;

import 放课后乐园部.脚本.*;
import android.content.*;

public class 脚本 {
    
    脚本() {}
    
    public static Object 运行(Context $上下文,String $文件) {
        if (!文件.是文件($文件))return null;
        switch(字符.截取结束($文件, ".", null)) {
            default:case "js":return JS().压入变量("当前上下文",$上下文).运行文件($文件);
            case "lua":return Lua().压入变量("当前上下文",$上下文).运行文件($文件);
            case "bsh":case "java":return BSH().压入变量("当前上下文",$上下文).运行文件($文件);
        }
    }
    
    public static JavaScript JS() {
        return new JavaScript();
    }
    
    public static Lua Lua() {
        return new Lua();
    }
    
    public static BeanShell BSH() {
        return new BeanShell();
    }
    
}

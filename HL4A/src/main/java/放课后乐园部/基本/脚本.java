package 放课后乐园部.基本;

import 放课后乐园部.脚本.*;
import android.content.*;

public class 脚本 {

    脚本() {}

    public static 基本脚本 取脚本引擎(String $脚本) {
        String $后缀 = 文件.取后缀($脚本);
        switch ($后缀) {
            default:
            case "js":return JS();
            case "lua":return Lua();
            case "bsh":return BSH();
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

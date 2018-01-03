package 放课后乐园部.脚本;

import com.luajava.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.事件.*;

public class Lua {

    public LuaState Lua状态机;

    public Lua() {
        Lua状态机 = LuaStateFactory.newLuaState();
        Lua状态机.置Lua(this);
        Lua状态机.openLibs();
        压入变量("当前环境",this);
        压入变量("当前应用",环境.读取());
        运行文件("@lib/android.lua");
     
    }
    
    public Lua 压入方法(String $名称,final 通用方法 $方法) {
        
        try {
            new JavaFunction(Lua状态机) {

                @Override
                public int execute() throws LuaException {
                    int $数量 = L.getTop();
                    if ($数量 > 3) {
                        Object[] $参数 = new Object[$数量 - 3];
                        for (int i = 4; i <= $数量; i++)
                            $参数[i - 4] = L.toJavaObject(i);
                        $方法.调用($参数);
                    }
                    else if ($数量 == 3) {
                        $方法.调用(L.toString(3));
                    }
                    return 0;
                }


            }.register($名称);
        } catch (Exception $错误) {}
return this;
    }

    public Object 读取对象(String $对象名) {
        try {
            synchronized (Lua状态机) {
                Lua状态机.getGlobal($对象名);
                return Lua状态机.toJavaObject(-1);
            }
        } catch (Exception $错误) {}
        return null;
    }
    
    public Object 运行文件(String $文件) {
        
        return 运行文件($文件,new Object[0]);
        
    }
    
    public Object 运行文件(String $文件,Object... $参数) {
        int $错误码;
        try {
            $文件 = 文件.检查地址($文件);
            Lua状态机.setTop(0);
            $错误码 = Lua状态机.LloadFile($文件);
            if ($错误码 == 0) {
                Lua状态机.getGlobal("debug");
                Lua状态机.getField(-1, "traceback");
                Lua状态机.remove(-2);
                Lua状态机.insert(-2);
                int l = $参数.length;
                for (int i = 0; i < l; i++)
                    Lua状态机.pushObjectValue($参数[i]);
                $错误码 = Lua状态机.pcall(l, 1, -2 - l);
                if ($错误码 == 0)
                    return Lua状态机.toJavaObject(-1);
            }
            throw new LuaException(取错误类型($错误码) + ": " + Lua状态机.toString(-1));
        } catch (Exception $错误) {
            错误.抛出($错误);
        }
        return null;
    }

    public Object 调用函数(String funcName,Object... $参数) {
        synchronized (Lua状态机) {
            try {
                Lua状态机.setTop(0);
                Lua状态机.pushGlobalTable();
                Lua状态机.pushString(funcName);
                Lua状态机.rawGet(-2);
                if (Lua状态机.isFunction(-1)) {
                    Lua状态机.getGlobal("debug");
                    Lua状态机.getField(-1, "traceback");
                    Lua状态机.remove(-2);
                    Lua状态机.insert(-2);
                    int l = $参数.length;
                    for (int i = 0; i < l; i++)
                        Lua状态机.pushObjectValue($参数[i]);
                    int $错误码 = Lua状态机.pcall(l, 1, -2 - l);
                    if ($错误码 == 0) 
                        return Lua状态机.toJavaObject(-1);
                    throw new LuaException(取错误类型($错误码) + ": " + Lua状态机.toString(-1));
                }
            } catch (Exception $错误) {
                错误.抛出($错误);
            }

        }
        return null;
    }
    
    public Object 执行代码(String $内容) {
        
        return 执行代码($内容,new Object[0]);
        
    }


    public Object 执行代码(String $内容,Object... $参数) {
        try {
            Lua状态机.setTop(0);
            int $错误码 = Lua状态机.LloadString($内容);

            if ($错误码 == 0) {
                Lua状态机.getGlobal("debug");
                Lua状态机.getField(-1, "traceback");
                Lua状态机.remove(-2);
                Lua状态机.insert(-2);
                int l = $参数.length;
                for (int i = 0; i < l; i++)
                    Lua状态机.pushObjectValue($参数[i]);
                $错误码 = Lua状态机.pcall(l, 1, -2 - l);
                if ($错误码 == 0)
                    return Lua状态机.toJavaObject(-1);
            }
            throw new LuaException(取错误类型($错误码) + ": " + Lua状态机.toString(-1));
        } catch (Exception $错误) {
            错误.抛出($错误);
        }
        return null;
    }

    public Lua 压入变量(String $对象名,Object $对象) {
        synchronized (Lua状态机) {
            try {
                Lua状态机.pushObjectValue($对象);
                Lua状态机.setGlobal($对象名);
            } catch (Exception $错误) {}
            return this;
        }
    }

    
    private String 取错误类型(int error) {
        switch (error) {
            case 6:
                return "普通错误";
            case 5:
                return "回收错误";
            case 4:
                return "内存溢出";
            case 3:
                return "语法错误";
            case 2:
                return "运行时错误";
            case 1:
                return "让步错误";
            case 0: 
                return "没有出错";
        }
        return "未知错误" + error;
    }


}

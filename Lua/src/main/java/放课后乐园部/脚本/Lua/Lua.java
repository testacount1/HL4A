package 放课后乐园部.脚本.Lua;

import com.luajava.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.事件.*;

public class Lua {

    public LuaState Lua上下文;

    public Lua() {
        Lua上下文 = LuaStateFactory.newLuaState();
        Lua上下文.置Lua(this);
    }
    
    public void 压入方法(String $名称,final 通用方法 $方法) {
        
        try {
            new JavaFunction(Lua上下文) {

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

    }

    public Object 读取对象(String $对象名) {
        try {
            synchronized (Lua上下文) {
                Lua上下文.getGlobal($对象名);
                return Lua上下文.toJavaObject(-1);
            }
        } catch (Exception $错误) {}
        return null;
    }
    
    public Object 运行文件(String $文件,Object... $参数) {
        int $错误码;
        try {
            $文件 = 文件.检查地址($文件);
            Lua上下文.setTop(0);
            $错误码 = Lua上下文.LloadFile($文件);
            if ($错误码 == 0) {
                Lua上下文.getGlobal("debug");
                Lua上下文.getField(-1, "traceback");
                Lua上下文.remove(-2);
                Lua上下文.insert(-2);
                int l = $参数.length;
                for (int i = 0; i < l; i++)
                    Lua上下文.pushObjectValue($参数[i]);
                $错误码 = Lua上下文.pcall(l, 1, -2 - l);
                if ($错误码 == 0)
                    return Lua上下文.toJavaObject(-1);
            }
            throw new LuaException(取错误类型($错误码) + ": " + Lua上下文.toString(-1));
        } catch (Exception $错误) {
            错误.普通($错误);
        }
        return null;
    }

    public Object 调用函数(String funcName,Object... $参数) {
        synchronized (Lua上下文) {
            try {
                Lua上下文.setTop(0);
                Lua上下文.pushGlobalTable();
                Lua上下文.pushString(funcName);
                Lua上下文.rawGet(-2);
                if (Lua上下文.isFunction(-1)) {
                    Lua上下文.getGlobal("debug");
                    Lua上下文.getField(-1, "traceback");
                    Lua上下文.remove(-2);
                    Lua上下文.insert(-2);
                    int l = $参数.length;
                    for (int i = 0; i < l; i++)
                        Lua上下文.pushObjectValue($参数[i]);
                    int $错误码 = Lua上下文.pcall(l, 1, -2 - l);
                    if ($错误码 == 0) 
                        return Lua上下文.toJavaObject(-1);
                    throw new LuaException(取错误类型($错误码) + ": " + Lua上下文.toString(-1));
                }
            } catch (Exception $错误) {
                错误.普通($错误);
            }

        }
        return null;
    }


    public Object 执行代码(String $内容,Object... $参数) {
        try {
            Lua上下文.setTop(0);
            int $错误码 = Lua上下文.LloadString($内容);

            if ($错误码 == 0) {
                Lua上下文.getGlobal("debug");
                Lua上下文.getField(-1, "traceback");
                Lua上下文.remove(-2);
                Lua上下文.insert(-2);
                int l = $参数.length;
                for (int i = 0; i < l; i++)
                    Lua上下文.pushObjectValue($参数[i]);
                $错误码 = Lua上下文.pcall(l, 1, -2 - l);
                if ($错误码 == 0)
                    return Lua上下文.toJavaObject(-1);
            }
            throw new LuaException(取错误类型($错误码) + ": " + Lua上下文.toString(-1));
        } catch (Exception $错误) {
            错误.普通($错误);
        }
        return null;
    }

    public void 压入对象(String $对象名,Object $对象) {
        synchronized (Lua上下文) {
            try {
                Lua上下文.pushObjectValue($对象);
                Lua上下文.setGlobal($对象名);
            } catch (Exception $错误) {}
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

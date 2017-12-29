package 放课后乐园部.脚本.事件;

import com.luajava.*;
import org.mozilla.javascript.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.脚本.*;

public class 脚本方法 {
    
    public static 通用方法 转换(final JavaScript $环境,final Function $方法) {
        return new 通用方法() {
            @Override
            public Object 调用(Object[] $参数) {
                return $环境.调用函数($方法,$参数);
            }
        };
    }
    
    public static 通用方法 转换(final LuaFunction $方法) {
        return new 通用方法() {
            @Override
            public Object 调用(Object[] $参数) {
                try {
                    return $方法.call($参数);
                } catch (LuaException $错误) {}
                return null;
            }
        };
    }
    
}

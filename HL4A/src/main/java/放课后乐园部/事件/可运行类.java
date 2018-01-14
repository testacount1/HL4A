package 放课后乐园部.事件;

import 放课后乐园部.基本.*;
import 放课后乐园部.弹窗.*;

public class 可运行类 implements Runnable,通用方法 {

    public static final 通用方法 空方法 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            return null;
        }
    };
	
	public static final 通用方法 未实现 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
			提示.普通("再等一周绝对能写出来 ~");
            return null;
        }
    };
    
    public 通用方法 方法;
    public Object[] 参数;

    public 可运行类(通用方法 $方法,Object... $参数) {
        方法 = $方法;
        参数 = $参数;
    }

    @Override
    public void run() {
        执行();
    }

    public Object 执行() {
        return 调用(参数);
    }

    @Override
    public Object 调用(Object... $参数) {
        if (方法 != null) {
            try {
                return 方法.调用($参数);
            } catch (Exception $错误) {
                错误.抛出($错误);
            }
        }
        return null;
    }

}

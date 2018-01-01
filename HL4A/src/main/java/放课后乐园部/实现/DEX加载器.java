package 放课后乐园部.实现;

import dalvik.system.*;
import 放课后乐园部.基本.*;

public class DEX加载器 extends DexClassLoader {

    private static String 文件地址;

    public DEX加载器(String $文件,ClassLoader $父加载器) {
        this($文件, null, $父加载器);
    }

    public DEX加载器(String $文件,String $依赖目录,ClassLoader $父加载器) {
        super($文件, 文件.取缓存目录(), $依赖目录, $父加载器);
        文件地址 = $文件;
        注入.最新加载器 = this;
    }

    public Class 取类(String $类名) {
        try {
            return 反射.取类($类名, this);
        } catch (Exception $错误) {}
        return null;
    }
}

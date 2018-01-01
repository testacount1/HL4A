package 放课后乐园部.基本;

import dalvik.system.DexClassLoader;
import 放课后乐园部.实现.*;

public class 注入 {

    注入() {}
    
    public static ClassLoader 最新加载器 = 环境.读取().getClassLoader();
    
    public static void 注入SO(String $文件) {
        try {
            System.load($文件);
        
        } catch (Exception $错误) {}
    }

    public static DEX加载器 注入DEX(String $文件) {
        return new DEX加载器($文件, 最新加载器);
    }

    public static DEX加载器 注入DEX(String $文件,String $依赖目录) {
        return new DEX加载器($文件, $依赖目录, 最新加载器);
    }

    

}

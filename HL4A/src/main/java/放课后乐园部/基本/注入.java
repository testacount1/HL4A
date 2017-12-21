package 放课后乐园部.基本;

import dalvik.system.DexClassLoader;

public class 注入 {

    注入() {}
    
    public static ClassLoader 最新加载器 = 环境.读取().getClassLoader();
    
    public static void 注入SO(String $文件) {
        try {
            System.load($文件);
        
        } catch (Exception $错误) {}
    }

    public static 类加载器 注入DEX(String $文件) {
        return new 类加载器($文件, 最新加载器);
    }

    public static 类加载器 注入DEX(String $文件,String $依赖目录) {
        return new 类加载器($文件, $依赖目录, 最新加载器);
    }

    public static class 类加载器 extends DexClassLoader {

        private String 文件地址;

        public 类加载器(String $文件,ClassLoader $父加载器) {
            this($文件,null,$父加载器);
        }

        public 类加载器(String $文件,String $依赖目录,ClassLoader $父加载器) {
            super($文件, 文件.取缓存目录(), $依赖目录, $父加载器);
            文件地址 = $文件;
            最新加载器 = this;
        }

        public Class 取类(String $类名) {
            try {
                return 反射.取类($类名,this);
            } catch (Exception $错误) {}
            return null;
        }

    }

}

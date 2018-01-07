package 放课后乐园部.基本;

import dalvik.system.DexClassLoader;
import 放课后乐园部.实现.*;
import java.io.*;

public class 注入 {

    注入() {}
    
    public static ClassLoader 最新加载器 = 环境.读取().getClassLoader();
    
    public static void 注入SO(String $文件) {
        try {
            System.load($文件);
        } catch (Exception $错误) {}
    }

    public static DEX加载器 注入DEX(String $文件) {
		File $对象 = 文件.取文件对象($文件);
		String $路径 = $对象.getPath();
		if (!$路径.startsWith("/data/") && !$路径.startsWith("/system/")) {
			$路径 = 文件.检查地址("$注入/"+$对象.getName());
			if (!文件.是文件($路径)) {
				文件.复制($对象.getPath(),$路径);
			} else if (散列.文件("MD5",$对象.getPath()) != 散列.文件("MD5",$路径)) {
				文件.复制($对象.getPath(),$路径);
			}
		}
        return new DEX加载器($路径, 最新加载器);
    }

}

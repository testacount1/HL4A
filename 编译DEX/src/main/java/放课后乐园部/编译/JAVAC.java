package 放课后乐园部.编译;

import compiler.*;
import java.io.*;
import java.util.*;
import javax.tools.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.收集.*;
import sun.security.x509.*;
import javax.net.ssl.*;
import java.security.cert.*;

public class JAVAC {

    public static String 编译(String $运行时,String $输出,String $目录,String $引用) throws Exception {

        if (!文件.是目录($输出)) {
            文件.删除($输出);
            new File($输出).mkdirs();
        }
        
        Jc4a $编译器 = new Jc4a();
        ByteArrayOutputStream $字节 = IO流.输出.字节();
        $编译器.setOut(new PrintWriter($字节));
        if (文件.是目录($引用))
        $编译器.setClassPath(取所有依赖($引用));
        $编译器.setOutPutPath($输出);
        $编译器.compile(注入.最新加载器, 文件.取文件对象($运行时), 取所有JAVA($目录));
        
        String $日志 = 字符.转换($字节.toByteArray());

        return $日志;

    }

    public static 集合 取所有依赖(String $目录) {

        if (!文件.是目录($目录))return null;
        File[] $所有 = 文件.取文件列表($目录);
        if ($所有.length == 0) return null;

        集合 $返回 = new 集合();

        for (File $单个 : $所有) {

            if ($单个.isFile()) {

                $返回.添加($单个);
                
            } else if ($单个.isDirectory()) {

                $返回.addAll(取所有依赖($单个.getPath()));

            }

        }

        return $返回;

    }

    public static 集合 取所有JAVA(String $目录) {

        if (!文件.是目录($目录))return null;
        File[] $所有 = 文件.取文件列表($目录);
        if ($所有.length == 0) return null;

        集合 $返回 = new 集合();

        for (File $单个 : $所有) {

            if ($单个.isFile() && $单个.getName().endsWith(".java")) {

                $返回.添加(new JavaFile($单个.toURI()));

            } else if ($单个.isDirectory()) {

                $返回.addAll(取所有JAVA($单个.getPath()));

            }

        }

        return $返回;

    }

}

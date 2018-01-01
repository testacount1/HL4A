package 放课后乐园部.数据;

import java.io.*;
import org.jsoup.*;
import 放课后乐园部.基本.*;
import org.jsoup.nodes.*;

public class XML {
    
    public static 文档 解析(String $内容) {
        return Jsoup.parse($内容);
    }

    public static 文档 解析(String $内容,String $链接) {
        return Jsoup.parse($内容,$链接);
    }

    public static 文档 读取(String $地址) {
        return 读取($地址,"");
    }

    public static 文档 读取(String $地址,String $链接) {
        return 读取($地址,$链接,"UTF-8");
    }

    public static 文档 读取(String $地址,String $链接,String $编码) {
        try {
            $地址 = 文件.检查地址($地址);  
            return Jsoup.parse(new File($地址), $编码,$链接);
        } catch (Exception $错误) {}
        return null;
    }

    public static 文档 网络(String $链接) {
        try {
            return Jsoup.connect($链接).get();
        } catch (Exception $错误) {}
        return null;
    }

    public static void 保存(String $地址,文档 $文档) {
        字符.保存($地址,$文档.源码());
    }
    
}

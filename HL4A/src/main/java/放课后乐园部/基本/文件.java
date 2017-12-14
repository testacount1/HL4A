package 放课后乐园部.基本;

import android.content.pm.*;
import android.os.*;
import java.io.*;
import java.net.*;

public final class 文件 {

    文件() {}

    public static Boolean 检查目录(String $目录) {
        return new File(检查地址($目录)).getParentFile().mkdirs();
    }

    public static String 创建文件(String $文件) {
        文件.删除($文件);
        字符.保存($文件, "");
        return $文件;
    }
    
    public static Boolean 是文件(String $文件) {
        $文件 = 检查地址($文件);
        return new File($文件).isFile();
    }

    public static Boolean 是目录(String $文件夹) {
        $文件夹 = 检查地址($文件夹);
        return new File($文件夹).isDirectory();
    }

    public static Boolean 是否存在(String $路径) {
        $路径 = 检查地址($路径);
        return new File($路径).exists();
    }

    public static File[] 取文件列表(String $目录) {
        $目录 = 检查地址($目录);
        if (是目录($目录))
            return new File($目录).listFiles();
        return null;
    }

    public static String 取存储卡目录() {
        return Environment.getExternalStorageDirectory().getPath();
    }

    public static String 取存储卡目录(String $相对地址) {
        return 取存储卡目录() + "/" + $相对地址;
    }

    public static URI 取URI(String $路径) {
        $路径 = 检查地址($路径);
        return new File($路径).toURI();
    }

    public static URL 取URL(String $路径) {
        try {
            $路径 = 检查地址($路径);
            return new File($路径).toURL();
        } catch (Exception $错误) {}
        return null;
    }

    public static File 取文件对象(String $文件) {
        return new File($文件);
    }

    public static String 检查地址(String $目录) {

        if ($目录 == null)
            return null;
            
            switch ($目录) {
                case "返回":$目录 = "@assets/icon/ic_back.png";break;
                case "安卓":$目录 = "@assets/icon/ic_android.png";break;
                case "菜单":$目录 = "@assets/icon/ic_menu.png";break;
                case "复制":$目录 = "@assets/icon/ic_copy.png";break;
                case "更多":$目录 = "@assets/icon/ic_more.png";break;
                case "设置":$目录 = "@assets/icon/ic_setting.png";break;
            }

        switch ($目录.substring(0, 1)) {
            case "%":
                $目录 = 取存储卡目录($目录.substring(1));
                break;
            case "$":
                $目录 =  取数据目录($目录.substring(1));
                break;
            case "@":
                $目录 = 取数据目录("apk/") + $目录.substring(1);
                break;
            case "#":
                $目录 = 取数据目录("apk/script/") + $目录.substring(1);
                break;
        }

        if (!$目录.startsWith("/"))
            $目录 = 取存储卡目录() + "/" + $目录;

            
        return $目录;
    }

    public static String 取名称(String $路径) {
        return new File($路径).getName();
    }

    public static String 取目录(String $文件) {
        return 字符.取结束前($文件, 取名称($文件).length());
    }

    public static Boolean 可读(String $文件) {
        $文件 = 检查地址($文件);
        return new File($文件).canRead();
    }

    public static Boolean 可写(String $文件) {
        $文件 = 检查地址($文件);
        return new File($文件).canWrite();
    }

    public static Boolean 可执行(String $文件) {
        $文件 = 检查地址($文件);
        return new File($文件).canExecute();
    }

    public static String 取数据目录() {
        return 环境.读取().getFilesDir().getParent();
    }

    public static String 取数据目录(String $相对位置) {
        return 取数据目录() + "/" + $相对位置;
    }

    public static String 取缓存目录() {
        return 环境.读取().getCacheDir().getPath();
    }

    public static String 取缓存目录(String $相对位置) {
        return 取缓存目录() + "/" + $相对位置;
    }

    public static String 取存储卡缓存目录() {
        return 取存储卡目录() + "/Android/data/" + 应用.取包名();
    }

    public static String 取存储卡缓存目录(String $相对地址) {
        return 取存储卡缓存目录() + "/" + $相对地址;
    }

    public static String 取安装包位置() {
        return 取安装包位置(环境.读取().getPackageName());
    }

    public static String 取安装包位置(String $包名) {
        try {
            PackageManager $PM = 环境.读取().getPackageManager();
            PackageInfo $INFO = $PM.getPackageInfo($包名, 0);
            return $INFO == null ? null : $INFO.applicationInfo.sourceDir;
        } catch (Exception $错误) {
            return null;
        }

    }

    public static void 存自身文件(String $相对地址,String $输出文件) {
        检查目录($输出文件);
        解压.单个(取安装包位置(), $相对地址, $输出文件);
    }

    public static void 复制(String $地址,String $新地址) {
        if (!是文件($地址))return;
        文件.删除($新地址);
        字节.保存($新地址, 字节.读取($地址));
    }

    public static void 剪切(String $地址,String $新地址) {
        文件.复制($地址, $新地址);
        文件.删除($地址);
    }

    public static void 删除(String $地址) {
        $地址 = 检查地址($地址);
        new 命令("rm -rf " + $地址).等待();
    }

}

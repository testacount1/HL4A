package 放课后乐园部.基本;

import android.content.pm.*;
import android.os.*;
import java.io.*;
import java.net.*;
import 放课后乐园部.收集.哈希表;

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
    
    public static String[] 取文件地址列表(String $目录) {
        $目录 = 检查地址($目录);
        if (是目录($目录))
            return new File($目录).list();
        return null;
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
        return new File(检查地址($文件));
    }

    public static String 默认地址 = 取数据目录("apk/script");

    public static 哈希表 替换地址 = new 哈希表();

    public static String 检查地址(String $目录) {

        if ($目录 == null)
            return null;

        if (替换地址.检查($目录)) {
            $目录 = (String)替换地址.读取($目录);
        }

        switch ($目录) {
            case "图片.返回":$目录 = "@assets/icon/ic_back.png";break;
            case "图片.安卓":$目录 = "@assets/icon/ic_android.png";break;
            case "图片.菜单":$目录 = "@assets/icon/ic_menu.png";break;
            case "图片.复制":$目录 = "@assets/icon/ic_copy.png";break;
            case "图片.更多":$目录 = "@assets/icon/ic_more.png";break;
            case "图片.设置":$目录 = "@assets/icon/ic_setting.png";break;
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
                $目录 = 默认地址 + "/" + $目录.substring(1);
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
        return new File($文件).getParent();
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
        if (文件.是文件($地址)) {
            文件.删除($新地址);
            字节.保存($新地址, 字节.读取($地址));
        } else if(文件.是目录($地址)) {
            File[] $所有 = 取文件列表($地址);
            for (File $单个 : $所有) {
                复制($单个.getPath(), $新地址  + "/" + $单个.getName());
            }
        }
    }

    public static void 剪切(String $地址,String $新地址) {
        复制($地址, $新地址);
        文件.删除($地址);
    }

    public static void 删除(String $地址) {
        $地址 = 检查地址($地址);
        File $对象 = new File($地址);
        if ($对象.exists())
        if (!字符.是否出现($地址, " "))
            new 命令("rm -rf " + $地址).等待();
        else {
            if ($对象.isFile()) {
                $对象.delete();
            } else if ($对象.isDirectory()) {
                File[] $列表 = $对象.listFiles();
                for (File $单个 : $列表)
                    删除($单个.getPath());
                $对象.delete();
            }
        }

    }

}

package 放课后乐园部.基本;

import android.content.pm.*;
import android.os.*;
import java.io.*;
import java.net.*;
import 放课后乐园部.收集.哈希表;
import android.content.*;
import android.net.*;

public final class 文件 {

    文件() {}

    public static void 打开(String $文件) {
        if (文件.是文件($文件)) {
            Intent $意图 = new Intent(Intent.ACTION_VIEW);
            $意图.setDataAndType(Uri.parse("file://" + 文件.检查地址($文件)), 取MIME($文件));
            $意图.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            环境.读取().startActivity($意图);
        }
    }

    public static String 置缓存(String $文件) {
        return 置缓存($文件, false);
    }

    public static String 置缓存(String $文件,boolean $可执行) {
        $文件 = 检查地址($文件);
        if (!是文件($文件))
            return null;
        String $缓存 = "$cache/" + 散列.文件("MD5", $文件);
        if (!是文件($缓存))
            文件.复制($文件, $缓存);
        if ($可执行)
            new 命令("chmod -R 777 " + $缓存).等待();
        return $缓存;
    }

    public static String 创建目录(String $目录) {
        if ($目录 != null) {
            取文件对象($目录).mkdirs();
        }
        return $目录;
    }
    
    public static String 创建文件(String $文件) {
        try {
            创建目录(取目录($文件));
            if (!是文件($文件))
                取文件对象($文件).createNewFile();
        } catch (IOException $错误) {}
        return $文件;
    }

    public static Boolean 是文件(String $文件) {
        $文件 = 检查地址($文件);
        return new File($文件).isFile();
    }

    public static Boolean 是目录(String $文件夹) {
        return 取文件对象($文件夹).isDirectory();
    }

    public static Boolean 是否存在(String $路径) {
        return 取文件对象($路径).exists();
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

    public static String[] 检查地址(String[] $目录) {
        for (int $键值 = 0;$键值 != $目录.length;$键值 += 1)
            $目录[$键值] = 检查地址($目录[$键值]);
        return $目录;
    }

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
            case "图片.分享":$目录 = "@assets/icon/ic_share.png";break;
            case "图片.发送":$目录 = "@assets/icon/ic_send.png";break;
            case "图片.添加":$目录 = "@assets/icon/ic_add.png";break;
            case "图片.前进":$目录 = "@assets/icon/ic_forward.png";break;
            case "图片.回退":$目录 = "@assets/icon/ic_backspace.png";break;
            case "图片.剪切":$目录 = "@assets/icon/ic_cut.png";break;
            case "图片.图片":$目录 = "@assets/icon/ic_icon.png";break;
            case "图片.删除":$目录 = "@assets/icon/ic_delete.png";break;
            case "图片.编辑":$目录 = "@assets/icon/ic_edit.png";break;
            case "图片.邮件":$目录 = "@assets/icon/ic_email.png";break;
            case "图片.启动":$目录 = "@assets/icon/ic_play.png";break;
            case "图片.公开":$目录 = "@assets/icon/ic_public.png";break;
            case "图片.重做":$目录 = "@assets/icon/ic_redo.png";break;
            case "图片.撤销":$目录 = "@assets/icon/ic_undo.png";break;
            case "图片.全选":$目录 = "@assets/icon/ic_select.png";break;
            case "图片.粘贴":$目录 = "@assets/icon/ic_paste.png";break;
            case "图片.日志":$目录 = "@assets/icon/ic_log.png";break;
            case "图片.卡片":$目录 = "@assets/icon/ic_sdcard.png";break;
            case "图片.搜索":$目录 = "@assets/icon/ic_search.png";break;
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


        return new File($目录).getPath();
    }

    public static String 取名称(String $路径) {
        return 取文件对象($路径).getName();
    }

    public static String 取目录(String $文件) {
        return 取文件对象($文件).getParent();
    }

    public static Boolean 可读(String $文件) {
        return 取文件对象($文件).canRead();
    }

    public static Boolean 可写(String $文件) {
        return 取文件对象($文件).canWrite();
    }

    public static Boolean 可执行(String $文件) {
        return 取文件对象($文件).canExecute();
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
        解压.单个(取安装包位置(), $相对地址, $输出文件);
    }

    public static void 复制(String $地址,String $新地址) {
        if (文件.是文件($地址)) {
            文件.删除($新地址);
            字节.保存($新地址, 字节.读取($地址));
        } else if (文件.是目录($地址)) {
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
            if ($对象.isFile()) {
                $对象.delete();
            } else if ($对象.isDirectory()) {
                File[] $列表 = $对象.listFiles();
                for (File $单个 : $列表)
                    删除($单个.getPath());
                $对象.delete();
            }

    }

    public static String 取MIME(String $文件) {
        String $类型 = "*/*";
        $文件 = "." + 字符.小写(字符.截取结束(取名称(检查地址($文件)), ".", null));
        for (int i=0;i < MIME表.length;i++) { //MIME_MapTable??在这里你一定有疑问，这个MIME_MapTable是什么？ 
            if ($文件.equals(MIME表[i][0]))
                $类型 = MIME表[i][1];
        }
        return $类型;
	}

    public static String[][] MIME表 = {  

        {".3gp",    "video/3gpp"},  
        {".apk",    "application/vnd.android.package-archive"},  
        {".asf",    "video/x-ms-asf"},  
        {".avi",    "video/x-msvideo"},  
        {".bin",    "application/octet-stream"},  
        {".bmp",    "image/bmp"},  
        {".c",  "text/plain"},  
        {".class",  "application/octet-stream"},  
        {".conf",   "text/plain"},  
        {".cpp",    "text/plain"},  
        {".doc",    "application/msword"},  
        {".docx",   "application/vnd.openxmlformats-officedocument.wordprocessingml.document"},  
        {".xls",    "application/vnd.ms-excel"},   
        {".xlsx",   "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"},  
        {".exe",    "application/octet-stream"},  
        {".gif",    "image/gif"},  
        {".gtar",   "application/x-gtar"},  
        {".gz", "application/x-gzip"},  
        {".h",  "text/plain"},  
        {".htm",    "text/html"},  
        {".html",   "text/html"},  
        {".jar",    "application/java-archive"},  
        {".java",   "text/plain"},  
        {".jpeg",   "image/jpeg"},  
        {".jpg",    "image/jpeg"},  
        {".js", "application/x-javascript"},  
        {".log",    "text/plain"},  
        {".m3u",    "audio/x-mpegurl"},  
        {".m4a",    "audio/mp4a-latm"},  
        {".m4b",    "audio/mp4a-latm"},  
        {".m4p",    "audio/mp4a-latm"},  
        {".m4u",    "video/vnd.mpegurl"},  
        {".m4v",    "video/x-m4v"},   
        {".mov",    "video/quicktime"},  
        {".mp2",    "audio/x-mpeg"},  
        {".mp3",    "audio/x-mpeg"},  
        {".mp4",    "video/mp4"},  
        {".mpc",    "application/vnd.mpohun.certificate"},        
        {".mpe",    "video/mpeg"},    
        {".mpeg",   "video/mpeg"},    
        {".mpg",    "video/mpeg"},    
        {".mpg4",   "video/mp4"},     
        {".mpga",   "audio/mpeg"},  
        {".msg",    "application/vnd.ms-outlook"},  
        {".ogg",    "audio/ogg"},  
        {".pdf",    "application/pdf"},  
        {".png",    "image/png"},  
        {".pps",    "application/vnd.ms-powerpoint"},  
        {".ppt",    "application/vnd.ms-powerpoint"},  
        {".pptx",   "application/vnd.openxmlformats-officedocument.presentationml.presentation"},  
        {".prop",   "text/plain"},  
        {".rc", "text/plain"},  
        {".rmvb",   "audio/x-pn-realaudio"},  
        {".rtf",    "application/rtf"},  
        {".sh", "text/plain"},  
        {".tar",    "application/x-tar"},     
        {".tgz",    "application/x-compressed"},   
        {".txt",    "text/plain"},  
        {".wav",    "audio/x-wav"},  
        {".wma",    "audio/x-ms-wma"},  
        {".wmv",    "audio/x-ms-wmv"},  
        {".wps",    "application/vnd.ms-works"},  
        {".xml",    "text/plain"},  
        {".z",  "application/x-compress"},  
        {".zip",    "application/x-zip-compressed"},  
        {"",        "*/*"}    
    };  


}

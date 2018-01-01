package 放课后乐园部.基本;

import android.content.pm.*;
import android.os.*;
import java.io.*;
import java.net.*;
import 放课后乐园部.收集.哈希表;
import android.content.*;
import android.net.*;
import 放课后乐园部.收集.*;

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
        return 取文件对象($文件).isFile();
    }

    public static Boolean 是目录(String $文件夹) {
        return 取文件对象($文件夹).isDirectory();
    }

    public static Boolean 是否存在(String $路径) {
        return 取文件对象($路径).exists();
    }

    public static String[] 取文件地址列表(String $目录) {
        if (是目录($目录))
            return 取文件对象($目录).list();
        return null;
    }

    public static File[] 取文件列表(String $目录) {
        if (是目录($目录))
            return 取文件对象($目录).listFiles();
        return null;
    }

    public static 集合 找文件关键字(String $目录,String $关键字) {
        
        集合 $返回 = new 集合();
        
        File[] $列表 = 文件.取文件列表($目录);
        
        for (File $单个 : $列表) {
            
            if ($单个.isFile() && 字符.是否出现($单个.getName(),$关键字)) {
                $返回.添加($单个);
            } else {
                $返回.addAll(找文件关键字($单个.getPath(),$关键字));
            }
            
        }
        
        return $返回;
        
    }
    
    public static 集合 找文件关键字(String $目录,String $前缀,String $后缀) {
        return 找文件关键字($目录,$前缀,$后缀,false);
    }
    
    public static 集合 找文件关键字(String $目录,String $前缀,String $后缀,boolean $不包含) {

        集合 $返回 = new 集合();

        File[] $列表 = 文件.取文件列表($目录);

        for (File $单个 : $列表) {

            if ($单个.isFile() && $单个.getName().startsWith($前缀) && $单个.getName().endsWith($后缀)) {
                if ($不包含 && $单个.getName().equals($前缀+$后缀)) continue;
                $返回.添加($单个);
            } else if ($单个.isDirectory()) {
                $返回.addAll(找文件关键字($单个.getPath(),$前缀,$后缀,$不包含));
            }

        }

        return $返回;

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

    public static 哈希表 替换地址表 = new 哈希表();

    public static void 替换地址(String $原地址,String $新地址) {
        替换地址表.设置($原地址, $新地址);
    }

    public static void 替换地址(String[][] $地址) {
        for (String[] $单个 : $地址) {
            替换地址表.设置($单个[0], $单个[1]);
        }
    }

    static {

        替换地址(new String[][] {
                 {"图片.返回","@assets/icon/ic_back.png"},
                 {"图片.安卓","@assets/icon/ic_android.png"},
                 {"图片.菜单","@assets/icon/ic_menu.png"},
                 {"图片.复制","@assets/icon/ic_copy.png"},
                 {"图片.更多","@assets/icon/ic_more.png"},
                 {"图片.设置","@assets/icon/ic_setting.png"},
                 {"图片.分享","@assets/icon/ic_share.png"},
                 {"图片.发送","@assets/icon/ic_send.png"},
                 {"图片.添加","@assets/icon/ic_add.png"},
                 {"图片.前进","@assets/icon/ic_forward.png"},
                 {"图片.回退","@assets/icon/ic_backspace.png"},
                 {"图片.剪切","@assets/icon/ic_cut.png"},
                 {"图片.图片","@assets/icon/ic_icon.png"},
                 {"图片.删除","@assets/icon/ic_delete.png"},
                 {"图片.编辑","@assets/icon/ic_edit.png"},
                 {"图片.邮件","@assets/icon/ic_email.png"},
                 {"图片.启动","@assets/icon/ic_play.png"},
                 {"图片.公开","@assets/icon/ic_public.png"},
                 {"图片.重做","@assets/icon/ic_redo.png"},
                 {"图片.撤销","@assets/icon/ic_undo.png"},
                 {"图片.全选","@assets/icon/ic_select.png"},
                 {"图片.粘贴","@assets/icon/ic_paste.png"},
                 {"图片.日志","@assets/icon/ic_log.png"},
                 {"图片.卡片","@assets/icon/ic_sdcard.png"},
                 {"图片.搜索","@assets/icon/ic_search.png"}
             });

    }

    public static String[] 检查地址(String[] $目录) {
        for (int $键值 = 0;$键值 != $目录.length;$键值 += 1)
            $目录[$键值] = 检查地址($目录[$键值]);
        return $目录;
    }

    public static String 检查地址(String $目录) {

        if ($目录 == null)
            return null;

        if (替换地址表.检查($目录)) {
            $目录 = (String)替换地址表.读取($目录);
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
    
    public static String 取后缀(String $地址) {
        return 字符.小写(字符.截取结束(取文件对象($地址).getName(),".",null));
    }
    
    public static String 除后缀(String $地址) {
        return 字符.小写(字符.截取结束("/"+取文件对象($地址).getName(),"/","."));
    }

    public static String 取名称(String $路径) {
        return 取文件对象($路径).getName();
    }

    public static String 取目录(String $文件) {
        return 取文件对象($文件).getParent();
    }

    public static long 取大小(String $文件) {
        File $对象 = 取文件对象($文件);
        if ($对象.isFile()) {
            return $对象.length();
        }
        return 0;
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
        File $对象 = 取文件对象($地址);
        if ($对象.isFile()) {
            文件.删除($新地址);
            if (文件.取大小($地址) == 0) {
                创建文件($新地址);
            } else {
                InputStream $输入 = IO流.输入.文件($对象.getPath());
                OutputStream $输出 = IO流.输出.文件($新地址);
                IO流.保存($输出, $输入);
                IO流.关闭($输入);
                IO流.关闭($输出);
            }
        } else if ($对象.isDirectory()) {
            File[] $所有 = $对象.listFiles();
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
        File $对象 = 取文件对象($地址);
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

    public static void 删除关键字(String $地址,String $关键字) {
        File $对象 = 取文件对象($地址);
        if ($对象.exists())
            if ($对象.isFile() && 字符.是否出现($对象.getName(), $关键字)) {
                $对象.delete();
            } else if ($对象.isDirectory()) {
                File[] $列表 = $对象.listFiles();
                for (File $单个 : $列表)
                    删除关键字($单个.getPath(), $关键字);
                $对象.delete();
            }

    }

    public static void 删除后缀(String $地址,String $后缀) {
        File $对象 = 取文件对象($地址);
        if ($对象.exists())
            if ($对象.isFile() && 字符.以结束($对象.getName(), $后缀)) {
                $对象.delete();
            } else if ($对象.isDirectory()) {
                File[] $列表 = $对象.listFiles();
                for (File $单个 : $列表)
                    删除后缀($单个.getPath(), $后缀);
                $对象.delete();
            }

    }


    public static String 取MIME(String $文件) {
        String $类型 = "text/plain";
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

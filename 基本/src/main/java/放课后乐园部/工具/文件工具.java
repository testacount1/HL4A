package 放课后乐园部.工具;

import java.io.*;
import java.net.*;
import java.util.*;
import 放课后乐园部.收集.*;

public final class 文件工具 {

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
        } catch (IOException $错误) {
        }
        return $文件;
    }

    public static Boolean 是文件(String... $文件) {
        return 取文件对象(字符工具.分解($文件, "/")).isFile();
    }

    public static Boolean 是目录(String... $文件夹) {
        return 取文件对象(字符工具.分解($文件夹, "/")).isDirectory();
    }

    public static Boolean 是否存在(String $路径) {
        return 取文件对象($路径).exists();
    }

    public static String[] 取文件地址列表(String $目录) {
        if (是目录($目录))
            return 取文件对象($目录).list();
        return new String[0];
    }

    public static File[] 取文件列表(String $目录) {
        if (是目录($目录))
            return 按文件排序(按日期排序(取文件对象($目录).listFiles()));
        else
            创建目录($目录);
        return new File[0];
    }

    public static File[] 按文件排序(File[] $文件) {
        Arrays.sort($文件, new Comparator<File>() {
            public int compare(File f1, File f2) {
                if (f1.isFile() && f2.isFile() || f1.isDirectory() && f2.isDirectory()) {
                    return f1.getName().toLowerCase().compareTo(f2.getName().toLowerCase());
                } else {
                    return f1.isFile() ? 1 : -1;
                }
            }
        });
        return $文件;
    }

    public static File[] 按日期排序(File[] $文件) {
        Arrays.sort($文件, new Comparator<File>() {
            public int compare(File f1, File f2) {
                long diff = f1.lastModified() - f2.lastModified();
                if (diff > 0)
                    return 1;
                else if (diff == 0)
                    return 0;
                else
                    return -1;
            }
        });
        return $文件;
    }

    public static 集合 找文件关键字(String $目录, String $关键字) {

        集合 $返回 = new 集合();

        File[] $列表 = 文件工具.取文件列表($目录);

        for (File $单个 : $列表) {

            if ($单个.isFile() && 字符工具.是否出现($单个.getName(), $关键字)) {
                $返回.添加($单个);
            } else {
                $返回.addAll(找文件关键字($单个.getPath(), $关键字));
            }

        }

        return $返回;

    }

    public static 集合 找文件关键字(String $目录, String $前缀, String $后缀) {
        return 找文件关键字($目录, $前缀, $后缀, false);
    }

    public static 集合 找文件关键字(String $目录, String $前缀, String $后缀, boolean $不包含) {

        集合 $返回 = new 集合();

        File[] $列表 = 文件工具.取文件列表($目录);

        for (File $单个 : $列表) {

            if ($单个.isFile() && $单个.getName().startsWith($前缀) && $单个.getName().endsWith($后缀)) {
                if ($不包含 && $单个.getName().equals($前缀 + $后缀))
                    continue;
                $返回.添加($单个);
            } else if ($单个.isDirectory()) {
                $返回.addAll(找文件关键字($单个.getPath(), $前缀, $后缀, $不包含));
            }

        }

        return $返回;

    }

    public static URI 取URI(String $路径) {
        $路径 = 检查地址($路径);
        return new File($路径).toURI();
    }

    public static URL 取URL(String $路径) {
        try {
            $路径 = 检查地址($路径);
            return new File($路径).toURL();
        } catch (Exception $错误) {
        }
        return null;
    }

    public static boolean 是网络文件(String $文件) {
        return 字符工具.以开始($文件, "http");
    }

    public static File 取文件对象(String... $文件) {
        return new File(检查地址(字符工具.分解($文件, "/")));
    }

    public static String[] 检查地址(String[] $目录) {
        for (int $键值 = 0; $键值 != $目录.length; $键值 += 1)
            $目录[$键值] = 检查地址($目录[$键值]);
        return $目录;
    }

    private static 集合<哈希表> 前缀替换 = new 集合<哈希表>();;

    public static void 替换地址(String $前缀, String $目标) {
        哈希表 $替换 = new 哈希表();
        $替换.设置("前缀", $前缀);
        $替换.设置("目标", $目标);
        前缀替换.添加($替换);
    }

    public static String 检查地址(String $目录) {

        if ($目录 == null)
            return null;

        for (哈希表 $替换 : 前缀替换) {
            String $前缀 = (String) $替换.读取("前缀");
            if (字符工具.以开始($目录, $前缀)) {
                String $结果 = (String) $替换.读取("目标");
                $目录 = $结果 + $目录.substring($前缀.length());
            }
        }

        return new File($目录).getPath();

    }

    public static String 取后缀(String $地址) {
        if (!字符工具.是否出现($地址, "."))
            return "";
        return 字符工具.小写(字符工具.截取结束(取文件对象($地址).getName(), ".", null));
    }

    public static String 除后缀(String $地址) {
        return 字符工具.小写(字符工具.截取结束("/" + 取文件对象($地址).getName(), "/", "."));
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

    public static boolean 是空文件(String $地址) {
        if (!文件工具.是文件($地址))
            return true;
        return 取文件对象($地址).length() == 0;
    }

    public static void 复制(String $地址, String $新地址) {
        File $对象 = 取文件对象($地址);
        if ($对象.isFile()) {
            文件工具.删除($新地址);
            if (文件工具.是空文件($地址)) {
                创建文件($新地址);
            } else {
                字节工具.保存($新地址, 字节工具.读取($地址));
            }
        } else if ($对象.isDirectory()) {
            File[] $所有 = $对象.listFiles();
            for (File $单个 : $所有) {
                复制($单个.getPath(), $新地址 + "/" + $单个.getName());
            }
        }
    }

    public static void 剪切(String $地址, String $新地址) {
        文件工具.删除($新地址);
        if (文件工具.取文件对象($地址).renameTo(文件工具.取文件对象($新地址)))
            return;
        复制($地址, $新地址);
        文件工具.删除($地址);
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

    public static void 删除关键字(String $地址, 哈希表 $关键字) {
        File $对象 = 取文件对象($地址);
        if ($对象.exists())
            if ($对象.isFile() && $关键字.检查($对象.getName().toLowerCase())) {
                $对象.delete();
            } else if ($对象.isDirectory()) {
                File[] $列表 = $对象.listFiles();
                for (File $单个 : $列表)
                    删除关键字($单个.getPath(), $关键字);
                $对象.delete();
            }

    }

    public static void 删除后缀(String $地址, String $后缀) {
        File $对象 = 取文件对象($地址);
        if ($对象.exists())
            if ($对象.isFile() && 字符工具.以结束($对象.getName(), $后缀)) {
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
        $文件 = "." + 字符工具.小写(字符工具.截取结束(取名称(检查地址($文件)), ".", null));
        for (int i = 0; i < MIME表.length; i++) { // MIME_MapTable??在这里你一定有疑问，这个MIME_MapTable是什么？
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

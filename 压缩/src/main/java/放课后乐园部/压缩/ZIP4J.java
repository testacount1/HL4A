package 放课后乐园部.压缩;

import java.io.*;
import net.lingala.zip4j.model.*;
import net.lingala.zip4j.util.*;
import net.lingala.zip4j.core.*;
import 放课后乐园部.工具.*;

public class ZIP4J {

    public static void 解压(String $文件,String $输出) {
        解压($文件, $输出, null);
    }

    public static void 解压(String $文件,String $输出,String $密码) {
        try {
            $文件 = 文件工具.检查地址($文件);
            $输出 = 文件工具.检查地址($输出);
            ZipFile $对象 = new ZipFile($文件);
            if ($对象.isEncrypted()) {
                $对象.setPassword($密码);
            }
            $对象.extractAll($输出);
        } catch (Exception $错误) {}
    }

    public static void 单个(String $文件,String $位置,String $输出) {
        单个($文件, $位置, $输出, null);
    }

    public static void 单个(String $文件,String $位置,String $输出,String $密码) {
        try {
            $文件 = 文件工具.检查地址($文件);
            $输出 = 文件工具.检查地址($输出);
            ZipFile $对象 = new ZipFile($文件);
            if ($对象.isEncrypted()) {
                $对象.setPassword($密码);
            }
            $对象.extractFile($位置, $输出);
        } catch (Exception $错误) {}
    }

    public static void 压缩(String $地址,String $输出) {
        压缩($地址, $输出, null);
    }

    public static void 压缩(String $地址,String $输出,String $密码) {
        try {
            ZipFile $压缩 = new ZipFile(文件工具.取文件对象($输出));
            ZipParameters $设置 = new ZipParameters();
            $设置.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            $设置.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            if ($密码 != null) {
                $设置.setEncryptFiles(true);
                $设置.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
                $设置.setPassword($密码);
            }
            if (文件工具.是文件($地址)) {
                $压缩.addFile(文件工具.取文件对象($地址), $设置);
            } else if (文件工具.是目录($地址)) {
                $压缩.addFolder(文件工具.取文件对象($地址), $设置);
            }
        } catch (Exception $错误) {}

    }


}

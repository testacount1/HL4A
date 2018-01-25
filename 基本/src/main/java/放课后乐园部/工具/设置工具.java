package 放课后乐园部.工具;

import android.content.*;
import java.util.*;
import java.io.*;

public class 设置工具 {

    public static Properties 打开PRO(String $地址) {
        try {
            Properties $设置 = new Properties();
            InputStream $输入流 = 流工具.输入.文件($地址);
            $设置.load($输入流);
            流工具.关闭($输入流);
            return $设置;
        } catch (Exception $错误) {
        }
        return new Properties();
    }

    public static Properties 打开XML(String $地址) {
        try {
            Properties $设置 = new Properties();
            InputStream $输入流 = 流工具.输入.文件($地址);
            $设置.loadFromXML($输入流);
            流工具.关闭($输入流);
            return $设置;
        } catch (Exception $错误) {
        }
        return new Properties();
    }

    public static void 保存PRO(String $地址, Properties $设置) {
        try {
            OutputStream $输出流 = 流工具.输出.文件($地址);
            $设置.store($输出流, "");
            流工具.关闭($输出流);
        } catch (Exception $错误) {
        }
    }

    public static void 保存XML(String $地址, Properties $设置) {
        try {
            OutputStream $输出流 = 流工具.输出.文件($地址);
            $设置.storeToXML($输出流, "");
            流工具.关闭($输出流);
        } catch (Exception $错误) {
        }
    }

    public static String 读取PX(Properties $设置, String $键值) {
        return $设置.getProperty($键值);
    }

    public static void 设置PX(Properties $设置, String $键值, String $内容) {
        $设置.setProperty($键值, $内容);
    }

}

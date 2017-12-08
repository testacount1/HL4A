package 放课后乐园部.基本;


import android.content.*;
import java.util.*;
import android.app.Activity;
import java.io.*;

public class 设置 {

    设置() {}

    public static Object 读取(String $设置名) {
        return 读取从文件("defult", $设置名);
    }

    public static void 设置(String $设置名,Object $设置内容) {
        设置到文件("defult", $设置名, $设置内容);
    }

    public static void 移除(String $设置名) {
        移除从文件("defult", $设置名);
    }

    public static Object 读取从文件(String $文件名,String $设置名) {
        try {
            SharedPreferences $共享 = 环境.读取().getSharedPreferences($文件名, Context.MODE_APPEND);
            return $共享.getAll().get($设置名);
        } catch (Exception $错误) { return null; }
    }

    public static void 设置到文件(String $文件名,String $设置名,Object $设置内容) {
        SharedPreferences $共享 =环境.读取().getSharedPreferences($文件名, Context.MODE_APPEND);
        SharedPreferences.Editor $写入 =  $共享.edit();
        if ($设置内容 == null) {
            $写入.remove($设置名);
        }
        else if ($设置内容 instanceof String) {
            $写入.putString($设置名, $设置内容.toString());
        }
        else if ($设置内容 instanceof Long) {
            $写入.putLong($设置名, ((Long) $设置内容).longValue());
        }
        else if ($设置内容 instanceof Integer) {
            $写入.putInt($设置名, ((Integer) $设置内容).intValue());
        }
        else if (!($设置内容 instanceof Float)) {
            $写入.putBoolean($设置名, ((Boolean) $设置内容).booleanValue());
        }
        else {
            $写入.putFloat($设置名, ((Float) $设置内容).floatValue());
        }
        $写入.commit();
    }

    public static void 移除从文件(String $文件名,String $设置名) {
        SharedPreferences $共享 =环境.读取().getSharedPreferences($文件名, Context.MODE_APPEND);
        SharedPreferences.Editor $写入 = $共享.edit();
        $写入.remove($设置名);
        $写入.commit();
    }


    public static Properties 打开PRO(String $地址) {
        try {
            Properties $设置 = new Properties();
            InputStream $输入流 = IO流.输入.文件($地址);
            $设置.load($输入流);
            IO流.关闭($输入流);
        } catch (Exception $错误) {}
        return null;
    }

    public static Properties 打开XML(String $地址) {
        try {
            Properties $设置 = new Properties();
            InputStream $输入流 = IO流.输入.文件($地址);
            $设置.loadFromXML($输入流);
            IO流.关闭($输入流);
        } catch (Exception $错误) {}
        return null;
    }

    public static void 保存PRO(String $地址,Properties $设置) {
        try {
            OutputStream $输出流 = IO流.输出.文件($地址);
            $设置.store($输出流, "");
            IO流.关闭($输出流);
        } catch (Exception $错误) {}
    }

    public static void 保存XML(String $地址,Properties $设置) {
        try {
            OutputStream $输出流 = IO流.输出.文件($地址);
            $设置.storeToXML($输出流, "");
            IO流.关闭($输出流);
        } catch (Exception $错误) {}
    }

    public static String 读取PX(Properties $设置,String $键值) {
        return $设置.getProperty($键值);
    }

    public static void 设置PX(Properties $设置,String $键值,String $内容) {
        $设置.setProperty($键值, $内容);
    }



}

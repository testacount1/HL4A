package 放课后乐园部.安卓.工具;

import android.content.*;

public class 安卓设置 {
    
    public static Object 读取(String $设置名) {
        return 读取从文件("defult", $设置名);
    }

    public static void 保存(String $设置名,Object $设置内容) {
        保存到文件("defult", $设置名, $设置内容);
    }

    public static void 移除(String $设置名) {
        移除从文件("defult", $设置名);
    }

    public static Object 读取从文件(String $文件名,String $设置名) {
        try {
            SharedPreferences $共享 = 上下文工具.取全局上下文().getSharedPreferences($文件名, Context.MODE_APPEND);
            return $共享.getAll().get($设置名);
        } catch (Exception $错误) { return null; }
    }

    public static void 保存到文件(String $文件名,String $设置名,Object $设置内容) {
        SharedPreferences $共享 = 上下文工具.取全局上下文().getSharedPreferences($文件名, Context.MODE_APPEND);
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
        SharedPreferences $共享 = 上下文工具.取全局上下文().getSharedPreferences($文件名, Context.MODE_APPEND);
        SharedPreferences.Editor $写入 = $共享.edit();
        $写入.remove($设置名);
        $写入.commit();
    }
    
}

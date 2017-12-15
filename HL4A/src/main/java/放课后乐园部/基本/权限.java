package 放课后乐园部.基本;
import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.os.*;
import android.support.v4.app.*;
import android.support.v4.content.*;
import 放课后乐园部.事件.*;

public class 权限 {

    static 通用方法 回调方法;
    
    public static void 启动检查(Activity $界面,通用方法 $回调) {
        回调方法 = $回调;
         启动界面($界面);
    }
    
    public static void 回调() {
        调用方法.事件(回调方法);
    }
    
    public static void 启动界面(Activity $界面) {
        Intent $意图 = new Intent($界面, 反射.取类(应用.取包名() + ".PreActivity"));
        $界面.startActivity($意图);
    }

    public static boolean 检查所有() {
        String[] $所有 = 应用.取所有权限();
        for (String $单个 : $所有) {
            if (检查权限($单个) == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }
    
    public static int 检查权限(String $权限) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (应用.取编译SDK() >= Build.VERSION_CODES.M) {
                return ContextCompat.checkSelfPermission(环境.读取(), $权限);
            } else {
                return PermissionChecker.checkSelfPermission(环境.读取(), $权限);
            }
        }
        return ContextCompat.checkSelfPermission(环境.读取(), $权限);
    }
    
    public static void 请求所有(Activity $界面) {
        String[] $所有 = 应用.取所有权限();
        请求权限($界面,$所有);
    }

    public static void 请求权限(Activity $界面,String[] $权限) {
        ActivityCompat.requestPermissions($界面, $权限, 0x38);
    }

}

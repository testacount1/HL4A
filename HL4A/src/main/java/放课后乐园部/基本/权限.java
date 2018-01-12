package 放课后乐园部.基本;

import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.os.*;
import android.support.v4.app.*;
import android.support.v4.content.*;
import 放课后乐园部.事件.*;

public class 权限 {

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
        if (应用.取SDK() >= Build.VERSION_CODES.M) {
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
        ActivityCompat.requestPermissions($界面, $权限, 23333);
    }

}

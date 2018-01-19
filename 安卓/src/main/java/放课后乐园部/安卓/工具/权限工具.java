package 放课后乐园部.安卓.工具;

import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.os.*;
import android.support.v4.app.*;
import android.support.v4.content.*;
import 放课后乐园部.事件.*;

public class 权限工具 {

    public static boolean 检查所有(Activity $界面) {
        String[] $所有 = 应用工具.取所有权限();
        for (String $单个 : $所有) {
            if (检查权限($界面, $单个) == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }

    public static int 检查权限(Activity $界面,String $权限) {
        if (设备工具.取SDK值() >= Build.VERSION_CODES.M) {
            if (应用工具.取编译SDK() >= Build.VERSION_CODES.M) {
                return ContextCompat.checkSelfPermission($界面, $权限);
            } else {
                return PermissionChecker.checkSelfPermission($界面, $权限);
            }
        }
        return PackageManager.PERMISSION_GRANTED;
    }

    public static void 请求所有(Activity $界面,int $请求码) {
		if (设备工具.取SDK值() >= Build.VERSION_CODES.M) {
			String[] $所有 = 应用工具.取所有权限();
			请求权限($界面, $所有);
		} else {
			$界面.onRequestPermissionsResult($请求码,new String[0],new int[0]);
		}
    }

    public static void 请求权限(Activity $界面,String[] $权限) {
        ActivityCompat.requestPermissions($界面, $权限, 23333);
    }

}

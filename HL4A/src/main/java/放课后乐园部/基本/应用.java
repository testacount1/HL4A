package 放课后乐园部.基本;

import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.content.res.*;
import android.graphics.drawable.*;
import android.util.*;
import android.view.*;
import java.util.*;
import 放课后乐园部.收集.*;
import android.content.pm.PackageManager.*;

public class 应用 {

    应用() {}

    private static 哈希表 全局变量 = new 哈希表();

    public static int 取编译SDK() {
        try {
            PackageInfo $信息 = 环境.读取().getPackageManager().getPackageInfo(
                应用.取包名(), 0);
            return $信息.applicationInfo.targetSdkVersion;
        } catch (Exception $错误) {}
        return 23;
    }

    public static String[] 取所有权限() {
        PackageInfo packageInfo = null;
        try {
            packageInfo = 环境.读取().getPackageManager().getPackageInfo(
                应用.取包名(), PackageManager.GET_PERMISSIONS);
        } catch (Exception $错误) {
            错误.普通($错误);
        }
        if (packageInfo != null) {
            return packageInfo.requestedPermissions;
        }
        return null;
    }

    public static 集合 取用户应用() {
        return 取所有应用(false);
    }

    public static 集合 取系统应用() {
        return 取所有应用(true);
    }

    public static 集合 取所有应用() {
        return 取所有应用(null);
    }

    public static 集合 取所有应用(Boolean $类型) {
        集合 $列表 = new 集合();
        PackageManager $PM = 环境.读取().getPackageManager();  
        List<PackageInfo> $所有 = $PM.getInstalledPackages(0);
        for (PackageInfo $单个 : $所有) {
            if (($单个.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) > 0) {
                if (new Boolean(false).equals($类型)) continue;
            } else if (new Boolean(true).equals($类型)) { continue; }
            $列表.添加($单个.packageName);
        }
        return $列表;
    }

    public static void 置全局变量(Object $键值,Object $内容) {
        全局变量.设置($键值, $内容);
    }

    public static Object 取全局变量(Object $键值) {
        return 全局变量.读取($键值);
    }

    public static String 取包名() {
        return 环境.读取().getPackageName();
    }

    public static String 取应用名() {
        try {
            return 环境.读取().getPackageManager().getPackageInfo(取包名(), 64).applicationInfo.loadLabel(环境.读取().getPackageManager()).toString();
        } catch (Exception $错误) {}
        return null;
    }

    public static String 取版本名() {
        try {
            return 环境.读取().getPackageManager().getPackageInfo(取包名(), 64).versionName;
        } catch (Exception $错误) {}
        return null;
    }

    public static Integer 取版本号() {
        try {
            return 环境.读取().getPackageManager().getPackageInfo(取包名(), 64).versionCode;
        } catch (Exception $错误) {}
        return null;
    }

    public static String 取MD5签名() {
        try {
            return 散列.摘要("MD5", 环境.读取().getPackageManager().getPackageInfo(取包名(), 64).signatures[0].toByteArray());
        } catch (Exception $错误) {}
        return null;
    }

    public static String 取SHA1签名() {
        try {
            return 散列.摘要("SHA-1", 环境.读取().getPackageManager().getPackageInfo(取包名(), 64).signatures[0].toByteArray());
        } catch (Exception $错误) {}
        return null;
    }


    public static Drawable 取图标() {
        return 取图标(取包名());
    }


    public static Drawable 取图标(String $包名) {
        try {
            PackageManager pm = 环境.读取().getPackageManager();
            ApplicationInfo info = pm.getApplicationInfo($包名, 0);
            return info.loadIcon(pm);
        } catch (Exception $错误) {}
        return null;
    }

    public static boolean 在后台() {
        ActivityManager am = (ActivityManager) 环境.读取()
            .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> taskList = am.getRunningTasks(1);
        if (taskList != null && !taskList.isEmpty()) {
            ComponentName topActivity = taskList.get(0).topActivity;
            if (topActivity != null
                && !topActivity.getPackageName().equals(
                    环境.读取().getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean 是横屏() {
        return 环境.读取().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    public static int 取屏幕宽度() {
        DisplayMetrics dm = 环境.读取().getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int 取屏幕高度() {
        DisplayMetrics dm = 环境.读取().getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    public static float 取屏幕密度() {
        DisplayMetrics dm = 环境.读取().getResources().getDisplayMetrics();
        return dm.density;
    }

    public static int 取屏幕DPI() {
        DisplayMetrics dm = 环境.读取().getResources().getDisplayMetrics();
        return dm.densityDpi;
    }

    public static int 取状态栏高度(Activity $界面) {
        int $ = $界面.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return $界面.getResources().getDimensionPixelSize($);
    }

    public static void 全屏(Activity $界面) {
        $界面.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = $界面.getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        window.setAttributes(params);
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public static void 竖屏(Activity $界面) {
        $界面.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public static void 横屏(Activity $界面) {
        $界面.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

}

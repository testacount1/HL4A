package 放课后乐园部.安卓.工具;

import android.*;
import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.content.res.*;
import android.graphics.drawable.*;
import android.util.*;
import android.view.*;
import java.util.*;
import 放课后乐园部.安卓.图形.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.收集.*;
import 放课后乐园部.工具.*;
import 放课后乐园部.安卓.弹窗.*;
import 放课后乐园部.线程.*;
import 放课后乐园部.事件.*;
import android.widget.*;
import 放课后乐园部.安卓.组件.*;
import android.content.pm.PackageManager.*;

public class 应用工具 {

	private static 集合<基本界面> 所有界面 = new 集合<基本界面>();

	public static boolean 已安装(String $包名) {
		PackageManager $PM = 上下文工具.取全局上下文().getPackageManager();
		try {
			$PM.getPackageInfo($包名, 0);
			return true;
		} catch (PackageManager.NameNotFoundException $错误) {
			return false;
		}
	}
	
	public static void 初始化界面(基本界面 $界面) {
		新建界面($界面);
		自动设置主题($界面);
	}
	
	public static void 新建界面(基本界面 $界面) {
		所有界面.添加($界面);
		竖屏($界面);
	}
	
	public static void 结束界面() {
		for (基本界面 $单个 : 所有界面) {
			$单个.结束界面();
		}
	}
	
	public static void 结束界面(Exception $错误) {
		for (基本界面 $单个 : 所有界面) {
			$单个.结束界面($错误);
		}
	}
	
	
	public static 通用方法 错误处理 = new 通用方法() {
		@Override
		public Object 调用(Object[] $参数) {
			上下文工具.取全局上下文().错误处理事件((Thread)$参数[0],(Exception)$参数[1]);
			return null;
		}
	};
	
	public static void 初始化应用(基本应用 $应用) {
		上下文工具.置全局上下文($应用);
		安卓文件.初始化();
		线程.置错误处理(错误处理);
		主题工具.置圆角大小("3dp");
		主题工具.置大文本大小("8dp");
		主题工具.置文本大小("5dp");
		主题工具.置小文本大小("4dp");
		主题工具.置默认填充("16dp");
		主题工具.置中等填充("56dp");
		主题工具.置主题颜色(颜色.靛蓝);
		提示工具.初始化($应用);
	}

	public static void 自动设置主题(Context $上下文) {
		if (设备工具.取SDK值() >= 21) {
			$上下文.setTheme(R.style.Theme_Material_Light_NoActionBar);
		} else {
			$上下文.setTheme(R.style.Theme_Holo_Light_NoActionBar);
		}
	}

	public static String 取安装包位置() {
        return 取安装包位置(上下文工具.取全局上下文().getPackageName());
    }

    public static String 取安装包位置(String $包名) {
        try {
            PackageManager $PM = 上下文工具.取全局上下文().getPackageManager();
            PackageInfo $INFO = $PM.getPackageInfo($包名, 0);
            return $INFO == null ? null : $INFO.applicationInfo.sourceDir;
        } catch (Exception $错误) {
            return null;
        }

    }

	public static void 启动(String $包名) {
		上下文工具.取全局上下文().startActivity(上下文工具.取全局上下文().getPackageManager().getLaunchIntentForPackage($包名));
	}


    public static int 取编译SDK() {
        try {
            PackageInfo $信息 = 上下文工具.取全局上下文().getPackageManager().getPackageInfo(
                应用工具.取包名(), 0);
            return $信息.applicationInfo.targetSdkVersion;
        } catch (Exception $错误) {}
        return 21;
    }

    public static String[] 取所有权限() {
        PackageInfo packageInfo = null;
        try {
            packageInfo = 上下文工具.取全局上下文().getPackageManager().getPackageInfo(
                应用工具.取包名(), PackageManager.GET_PERMISSIONS);
        } catch (Exception $错误) {}
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
        PackageManager $PM = 上下文工具.取全局上下文().getPackageManager();  
        List<PackageInfo> $所有 = $PM.getInstalledPackages(0);
        for (PackageInfo $单个 : $所有) {
            if (($单个.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) > 0) {
                if (new Boolean(false).equals($类型)) continue;
            } else if (new Boolean(true).equals($类型)) { continue; }
            $列表.添加($单个.packageName);
        }
        return $列表;
    }

    public static String 取包名() {
        return 上下文工具.取全局上下文().getPackageName();
    }

    public static String 取应用名() {
        try {
            return 上下文工具.取全局上下文().getPackageManager().getPackageInfo(取包名(), 64).applicationInfo.loadLabel(上下文工具.取全局上下文().getPackageManager()).toString();
        } catch (Exception $错误) {}
        return null;
    }

    public static String 取版本名() {
        try {
            return 上下文工具.取全局上下文().getPackageManager().getPackageInfo(取包名(), 64).versionName;
        } catch (Exception $错误) {}
        return null;
    }

    public static Integer 取版本号() {
        try {
            return 上下文工具.取全局上下文().getPackageManager().getPackageInfo(取包名(), 64).versionCode;
        } catch (Exception $错误) {}
        return null;
    }

    public static String 取MD5签名() {
        try {
            return 散列工具.摘要("MD5", 上下文工具.取全局上下文().getPackageManager().getPackageInfo(取包名(), 64).signatures[0].toByteArray());
        } catch (Exception $错误) {}
        return null;
    }

    public static String 取SHA1签名() {
        try {
            return 散列工具.摘要("SHA-1", 上下文工具.取全局上下文().getPackageManager().getPackageInfo(取包名(), 64).signatures[0].toByteArray());
        } catch (Exception $错误) {}
        return null;
    }


    public static Drawable 取图标() {
        return 取图标(取包名());
    }


    public static Drawable 取图标(String $包名) {
        try {
            PackageManager pm = 上下文工具.取全局上下文().getPackageManager();
            ApplicationInfo info = pm.getApplicationInfo($包名, 0);
            return info.loadIcon(pm);
        } catch (Exception $错误) {}
        return null;
    }

    public static boolean 在后台() {
        ActivityManager am = (ActivityManager) 上下文工具.取全局上下文()
            .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> taskList = am.getRunningTasks(1);
        if (taskList != null && !taskList.isEmpty()) {
            ComponentName topActivity = taskList.get(0).topActivity;
            if (topActivity != null
                && !topActivity.getPackageName().equals(
                    上下文工具.取全局上下文().getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean 是横屏() {
        return 上下文工具.取全局上下文().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    public static int 取屏幕宽度() {
        DisplayMetrics dm = 上下文工具.取全局上下文().getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int 取屏幕高度() {
        DisplayMetrics dm = 上下文工具.取全局上下文().getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    public static float 取屏幕密度() {
        DisplayMetrics dm = 上下文工具.取全局上下文().getResources().getDisplayMetrics();
        return dm.density;
    }

    public static int 取屏幕DPI() {
        DisplayMetrics dm = 上下文工具.取全局上下文().getResources().getDisplayMetrics();
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

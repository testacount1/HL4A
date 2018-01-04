package 放课后乐园部.组件;

import android.accessibilityservice.*;
import android.content.*;
import android.content.pm.*;
import android.view.accessibility.*;
import 放课后乐园部.基本.*;

public class 辅助服务 extends AccessibilityService {

    public static volatile 辅助服务 服务 = null;
    public static volatile AccessibilityEvent 意图 = null;
    public static volatile AccessibilityNodeInfo 节点 = null;


    @Override
    public void onCreate() {
        super.onCreate();
        服务 = this;
    }

    @Override
    public void onServiceConnected() {
        super.onServiceConnected();
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent $意图) {
        /*switch ($意图.getEventType()) {
            case AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED:
            case AccessibilityEvent.TYPE_WINDOWS_CHANGED:
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
        */        置最新界面信息($意图.getPackageName(), $意图.getClassName());
        //}
        意图 = $意图;
        节点 = getRootInActiveWindow();
    }

    public static volatile String 最新包名 = "";
    public static volatile String 最新界面 = "";

    private void 置最新界面信息(CharSequence $最新包名,CharSequence $最新类) {
        if ($最新包名 == null || $最新类 == null)
            return;
        String $最新包名文本 = $最新包名.toString();
        String $最新类名文本 = $最新类.toString();
        if ($最新类名文本.startsWith("android.view.") ||
            $最新类名文本.startsWith("android.widget."))
            return;
        try {
            ComponentName $应用信息 = new ComponentName($最新包名文本, $最新类名文本);
            最新界面 = 环境.读取().getPackageManager().getActivityInfo($应用信息, 0).name;
        } catch (PackageManager.NameNotFoundException $错误) {
            return;
        }
        最新包名 = $最新包名.toString();
    }

    @Override
    public void onInterrupt() {
    }

    @Override
    public void onDestroy() {
        服务 = null;
        super.onDestroy();
    }

}

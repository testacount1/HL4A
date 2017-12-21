package 放课后乐园部.基本;

import android.content.*;
import android.os.*;
import android.provider.*;
import android.view.accessibility.*;
import java.util.*;
import 放课后乐园部.组件.*;

public class 辅助 {

    辅助() {}

    public static boolean 检查() {
        if (已启动())
            return true;
        环境.读取().startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        弹窗.提示("请关闭使用界面的服务 并开启或重启 " + 应用.取应用名() + " ~\n重新开关后服务仍未运行请重启系统！");
        return false;
    }

    public static boolean 等包名(String $包名) {
        if (!检查()) return false;
        while (!$包名.equals(取包名())) {
            线程.暂停(233);
        }
        return true;
    }

    public static 节点 等文本(String $文本) {
        if (!检查()) return null;
        节点 $节点 = 找文本($文本);
        while ($节点 == null) {
            线程.暂停(233);
            $节点 = 找文本($文本);
        }
        return $节点;

    }

    public static 节点 等文本(String $文本,int $键值) {
        if (!检查()) return null;
        节点 $节点 = 找文本($文本, $键值);
        while ($节点 == null) {
            线程.暂停(233);
            $节点 = 找文本($文本, $键值);
        }
        return $节点;
    }

    public static 节点 等ID(String $ID) {
        if (!检查()) return null;
        节点 $节点 = 找ID($ID);
        while ($节点 == null) {
            线程.暂停(233);
            $节点 = 找ID($ID);
        }
        return $节点;
    }

    public static 节点 等ID(String $ID,int $键值) {
        if (!检查()) return null;
        节点 $节点 = 找ID($ID, $键值);
        while ($节点 == null) {
            线程.暂停(233);
            $节点 = 找ID($ID, $键值);
        }
        return $节点;
    }

    public static String 取包名() {
        if (!检查()) return null;
        return (String)辅助服务.服务.getRootInActiveWindow().getPackageName();
    }


    public static 节点 找文本(String $文本) {
        if (!检查()) return null;
        return 找文本($文本, 0);
    }

    public static 节点 找文本(String $文本,int $键值) {
        if (!检查()) return null;
        List <AccessibilityNodeInfo> $节点 = 辅助服务.节点.findAccessibilityNodeInfosByText($文本);
        if ($节点 != null && !$节点.isEmpty()) {
            return new 节点($节点.get($键值));
        }
        return null;
    }

    public static 节点 找ID(String $文本) {
        if (!检查()) return null;
        return 找文本($文本, 0);

    }

    public static 节点 找ID(String $文本,int $键值) {
        if (!检查()) return null;
        List <AccessibilityNodeInfo> $节点 = 辅助服务.节点.findAccessibilityNodeInfosByViewId($文本);
        if ($节点 != null && !$节点.isEmpty()) {
            return new 节点($节点.get($键值));
        }

        return null;
    }

    public static boolean 已启动() {
        return 服务.已启动(应用.取包名() + ".Accessibility");
    }

    public static class 系统 {

        系统() {}

        public static void 模拟返回() {
            if (!检查()) return;
            辅助服务.服务.performGlobalAction(辅助服务.服务.GLOBAL_ACTION_BACK);
        }

        public static void 回到主页() {
            if (!检查()) return;
            辅助服务.服务.performGlobalAction(辅助服务.服务.GLOBAL_ACTION_HOME);
        }

        public static void 打开通知() {
            if (!检查()) return;
            辅助服务.服务.performGlobalAction(辅助服务.服务.GLOBAL_ACTION_NOTIFICATIONS);
        }

        public static void 关机弹窗() {
            if (!检查()) return;
            辅助服务.服务.performGlobalAction(辅助服务.服务.GLOBAL_ACTION_POWER_DIALOG);
        }

        public static void 打开设置() {
            if (!检查()) return;
            辅助服务.服务.performGlobalAction(辅助服务.服务.GLOBAL_ACTION_QUICK_SETTINGS);
        }

        public static void 打开最近() {
            if (!检查()) return;
            辅助服务.服务.performGlobalAction(辅助服务.服务.GLOBAL_ACTION_RECENTS);
        }

    }

    public static class 节点 {

        public AccessibilityNodeInfo 对象;

        public 节点(AccessibilityNodeInfo $节点) {
            对象 = $节点;
        }

        public 节点 取父节点() {
            return new 节点(对象.getParent());
        }

        public boolean 可单击() {
            return 对象.isClickable();
        }

        public boolean 可长按() {
            return 对象.isLongClickable();
        }

        public boolean 可编辑() {
            return 对象.isEditable();
        }

        public boolean 单击() {
            if (可单击()) {
                return 对象.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            } else {
                return 取父节点().单击();
            }
        }

        public boolean 长按() {
            if (可长按()) {
                return 对象.performAction(AccessibilityNodeInfo.ACTION_LONG_CLICK);
            } else {
                return 取父节点().长按();
            }
        }

        public boolean 已获得焦点() {
            return 对象.isAccessibilityFocused();
        }

        public boolean 置可取得焦点() {
            return 对象.performAction(AccessibilityNodeInfo.ACTION_ACCESSIBILITY_FOCUS);
        }

        public boolean 置不可取得焦点() {
            return 对象.performAction(AccessibilityNodeInfo.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        }

        public boolean 取得焦点() {
            return 对象.performAction(AccessibilityNodeInfo.ACTION_FOCUS);
        }

        public boolean 清除焦点() {
            return 对象.performAction(AccessibilityNodeInfo.ACTION_CLEAR_FOCUS);
        }

        public boolean 复制() {
            return 对象.performAction(AccessibilityNodeInfo.ACTION_COPY);
        }

        public boolean 粘贴() {
            return 对象.performAction(AccessibilityNodeInfo.ACTION_PASTE);
        }

        public boolean 选中() {
            return 对象.performAction(AccessibilityNodeInfo.ACTION_SELECT);
        }

        public boolean 剪切() {
            return 对象.performAction(AccessibilityNodeInfo.ACTION_CUT);
        }

        public boolean 折叠() {
            return 对象.performAction(AccessibilityNodeInfo.ACTION_COLLAPSE);
        }

        public boolean 展开() {
            return 对象.performAction(AccessibilityNodeInfo.ACTION_EXPAND);
        }

        public boolean 隐藏() {
            return 对象.performAction(AccessibilityNodeInfo.ACTION_DISMISS);
        }

        public boolean 前滑() {
            return 对象.performAction(AccessibilityNodeInfo.ACTION_SCROLL_FORWARD);
        }

        public boolean 后滑() {
            return 对象.performAction(AccessibilityNodeInfo.ACTION_SCROLL_BACKWARD);
        }

        public boolean 选中文本(int $开始,int $结束) {
            Bundle $数据 = new Bundle();
            $数据.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_SELECTION_START_INT, $开始);
            $数据.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_SELECTION_END_INT, $结束);
            return 对象.performAction(AccessibilityNodeInfo.ACTION_SET_SELECTION, $数据);
        }

        public boolean 更改文本(String $内容) {
            Bundle $数据 = new Bundle();
            $数据.putCharSequence(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, $内容);
            return 对象.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, $数据);
        }


    }

}

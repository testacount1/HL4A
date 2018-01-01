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
        弹窗.提示("请开启或重启 " + 应用.取应用名() + " ~\n重新开关后服务仍未运行请重启系统！");
        return false;
    }

    public static boolean 等包名(String $包名) {
        if (!检查()) return false;
        while (!$包名.equals(取包名())) {
            线程.暂停(233);
        }
        return true;
    }

    public static boolean 等界面(String $界面) {
        if (!检查()) return false;
        while (!$界面.equals(取界面())) {
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
        return 辅助服务.最新包名;
    }

    public static String 取界面() {
        if (!检查()) return null;
        return 辅助服务.最新界面;
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

    public static 节点 找编辑框() {
        if (!检查()) return null;
        return new 选择器()
            .类名("android.widget.EditText")
            .循环找();
    }

    public static class 选择器 {

        Boolean 可单击;
        Boolean 可长按;
        Boolean 可编辑;
        Boolean 有子节点;
        String 文本;
        String 类名;

        public 节点 循环找() {
            if (辅助服务.节点 != null)
                return 循环找(new 节点(辅助服务.节点));
            return null;
        }

        public 节点 循环找(节点 $开始) {
            for (节点 $单个 : $开始.取子节点()) {
                if (
                    (
                    可单击 == null ||
                    可单击.equals($单个.可单击())
                    ) &&
                    (
                    可长按 == null ||
                    可长按.equals($单个.可长按())
                    ) &&
                    (
                    可编辑 == null ||
                    可编辑.equals($单个.可编辑())
                    ) &&
                    (
                    有子节点 == null ||
                    有子节点.equals($单个.有子节点())
                    ) &&
                    (
                    文本 == null ||
                    文本.equals($单个.取文本())
                    ) &&
                    (
                    类名 == null ||
                    类名.equals($单个.取类名())
                    )) {
                    return $单个;
                } else if ($单个.有子节点()) {
                    for (节点 $单 : $单个.取子节点()) {
                        节点 $返回 = 循环找($单个);
                        if ($返回 != null) {
                            return $返回;
                        }
                    }
                }
            }
            return null;
        }

        public 选择器 可单击(boolean $是否) {
            可单击 = $是否;
            return this;
        }

        public 选择器 可长按(boolean $是否) {
            可长按 = $是否;
            return this;
        }

        public 选择器 可编辑(boolean $是否) {
            可编辑 = $是否;
            return this;
        }

        public 选择器 有子节点(boolean $是否) {
            有子节点 = $是否;
            return this;
        }

        public 选择器 文本(String $文本) {
            文本 = $文本;
            return this;
        }

        public 选择器 类名(String $类名) {
            类名 = $类名;
            return this;
        }

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

        public String 取类名() {
            if (对象 == null) return null;
            return 对象.getClassName().toString();
        }

        public int 取子节点数() {
            if (对象 == null) return 0;
            return 对象.getChildCount();
        }

        public boolean 有子节点() {
            return 取子节点数() != 0;
        }

        public 节点[] 取子节点() {
            int $所有 = 取子节点数();
            节点[] $返回 = new 节点[$所有];
            for (int $键值 = 0;$键值 < $所有;$键值 ++) {
                AccessibilityNodeInfo $节点 = 对象.getChild($键值);
                $返回[$键值] = new 节点($节点);
            }
            return $返回;
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

        public String 取文本() {
            return 对象.getText().toString();
        }

        public boolean 选文本(int $开始,int $结束) {
            Bundle $数据 = new Bundle();
            $数据.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_SELECTION_START_INT, $开始);
            $数据.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_SELECTION_END_INT, $结束);
            return 对象.performAction(AccessibilityNodeInfo.ACTION_SET_SELECTION, $数据);
        }

        public boolean 置文本(String $内容) {
            if (Build.VERSION.SDK_INT >= 21) {
                Bundle $数据 = new Bundle();
                $数据.putCharSequence(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, $内容);
                return 对象.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, $数据);
            } else {
                String $原字符 = 设备.剪切板();
                设备.剪切板($内容);
                boolean $结果 = 粘贴();
                设备.剪切板($原字符);
                return $结果;
            }
        }



    }

}

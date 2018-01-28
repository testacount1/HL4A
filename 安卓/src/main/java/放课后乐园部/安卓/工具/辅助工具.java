package 放课后乐园部.安卓.工具;

import android.accessibilityservice.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.provider.*;
import android.view.*;
import android.view.accessibility.*;
import hl4a.runtime.*;
import java.util.*;
import 放课后乐园部.安卓.线程.*;
import 放课后乐园部.安卓.组件.*;
import 放课后乐园部.线程.*;
import 放课后乐园部.事件.*;
import java.math.*;

public class 辅助工具 {

    public static boolean 检查() {
        if (已启动() && 辅助服务.服务 != null)
            return true;
        return false;
    }

    public static boolean 停止() {
        if (检查()) {
            辅助服务.服务.disableSelf();
            return true;
        }
        return false;
    }

    public static void 跳转() {
        上下文工具.取全局上下文().startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    public static boolean 自动() {
        if (!检查()) {
            跳转();
            提示工具.普通("请开启或重启 " + 应用工具.取应用名() + " ~\n重新开关后服务仍未运行请重启系统！");
            return false;
        }
        return true;
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
        if (!检查() || 辅助服务.节点 == null) return null;
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
        if (!检查() || 辅助服务.节点 == null) return null;
        List <AccessibilityNodeInfo> $节点 = 辅助服务.节点.findAccessibilityNodeInfosByViewId($文本);
        if ($节点 != null && !$节点.isEmpty()) {
            return new 节点($节点.get($键值));
        }
        return null;
    }



    public static boolean 已启动() {
        return 服务工具.已启动(Accessibility.class);
    }


    public static boolean 返回() {
        if (!检查()) return false;
        return 辅助服务.服务.performGlobalAction(辅助服务.服务.GLOBAL_ACTION_BACK);
    }

    public static boolean 主页() {
        if (!检查()) return false;
        return 辅助服务.服务.performGlobalAction(辅助服务.服务.GLOBAL_ACTION_HOME);
    }

    public static boolean 通知() {
        if (!检查()) return false;
        return 辅助服务.服务.performGlobalAction(辅助服务.服务.GLOBAL_ACTION_NOTIFICATIONS);
    }

    public static boolean 关机() {
        if (!检查()) return false;
        return 辅助服务.服务.performGlobalAction(辅助服务.服务.GLOBAL_ACTION_POWER_DIALOG);
    }

    public static boolean 设置() {
        if (!检查()) return false;
        return 辅助服务.服务.performGlobalAction(辅助服务.服务.GLOBAL_ACTION_QUICK_SETTINGS);
    }

    public static boolean 最近() {
        if (!检查()) return false;
        return 辅助服务.服务.performGlobalAction(辅助服务.服务.GLOBAL_ACTION_RECENTS);
    }

    public static boolean 分屏() {
        if (!检查()) return false;
        return 辅助服务.服务.performGlobalAction(辅助服务.服务.GLOBAL_ACTION_TOGGLE_SPLIT_SCREEN);
    }

    public static class 点按 {

        public static boolean 手势(long start,long duration,int[]... points) {
            Path path = pointsToPath(points);
            return 手势(new GestureDescription.StrokeDescription(path, start, duration));
        }

        private static Path pointsToPath(int[][] points) {
            Path path = new Path();
            path.moveTo(points[0][0], points[0][1]);
            for (int i = 1; i < points.length; i++) {
                int[] point = points[i];
                path.lineTo(point[0], point[1]);
            }
            return path;
        }

        public static boolean 手势(final GestureDescription.StrokeDescription... strokes) {
            if (!检查()) return false;
            if (安卓线程.是主线程()) {
                throw new RuntimeException("点按不能在主线程，否则无法受到回调");
            }
            final 回调<Boolean> $回调 = new 回调<>();
            GestureDescription.Builder builder = new GestureDescription.Builder();
            for (GestureDescription.StrokeDescription stroke : strokes) {
                builder.addStroke(stroke);
            }
            辅助服务.服务.dispatchGesture(builder.build(), new AccessibilityService.GestureResultCallback() {
                    @Override
                    public void onCompleted(GestureDescription gestureDescription) {
                        $回调.返回(true);
                    }
                    @Override
                    public void onCancelled(GestureDescription gestureDescription) {
                        $回调.返回(false);
                    }
                }, null);
            return $回调.等待();
        }

        public static boolean 单击(int x,int y) {
            return 按下(x, y, ViewConfiguration.getTapTimeout() + 50);
        }

        public static boolean 按下(int x,int y,int delay) {
            return 手势(0, delay, new int[]{x, y});
        }

        public static  boolean 长按(int x,int y) {
            return 手势(0, ViewConfiguration.getLongPressTimeout() + 200, new int[]{x, y});
        }

        public static boolean 滑动(int x1,int y1,int x2,int y2,int delay) {
            return 手势(0, delay, new int[]{x1, y1}, new int[]{x2, y2});
        }

    }

    public static class 节点 {

        public AccessibilityNodeInfo 对象;

        public 节点(AccessibilityNodeInfo $节点) {
            对象 = $节点;
        }

        public String 取类名() {
            if (为空()) return null;
            return 对象.getClassName().toString();
        }

        public int 取子节点数() {
            if (为空()) return 0;
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
            if (为空()) return null;
            return new 节点(对象.getParent());
        }

        public boolean 可单击() {
            if (为空()) return false;
            return 对象.isClickable();
        }

        public boolean 可长按() {
            if (为空()) return false;
            return 对象.isLongClickable();
        }

        public boolean 可编辑() {
            if (为空()) return false;
            return 对象.isEditable();
        }

        public boolean 单击() {
            if (为空()) return false;
            if (可单击()) {
                return 对象.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            } else {
                return 取父节点().单击();
            }
        }

        public boolean 长按() {
            if (为空()) return false;
            if (可长按()) {
                return 对象.performAction(AccessibilityNodeInfo.ACTION_LONG_CLICK);
            } else {
                return 取父节点().长按();
            }
        }

        public boolean 已获得焦点() {
            if (为空()) return false;
            return 对象.isAccessibilityFocused();
        }

        public boolean 置可取得焦点() {
            if (为空()) return false;
            return 对象.performAction(AccessibilityNodeInfo.ACTION_ACCESSIBILITY_FOCUS);
        }

        public boolean 置不可取得焦点() {
            if (为空()) return false;
            return 对象.performAction(AccessibilityNodeInfo.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        }

        public boolean 取得焦点() {
            if (为空()) return false;
            return 对象.performAction(AccessibilityNodeInfo.ACTION_FOCUS);
        }

        public boolean 清除焦点() {
            if (为空()) return false;
            return 对象.performAction(AccessibilityNodeInfo.ACTION_CLEAR_FOCUS);
        }

        public boolean 复制() {
            if (为空()) return false;
            return 对象.performAction(AccessibilityNodeInfo.ACTION_COPY);
        }

        public boolean 粘贴() {
            if (为空()) return false;
            return 对象.performAction(AccessibilityNodeInfo.ACTION_PASTE);
        }

        public boolean 选中() {
            if (为空()) return false;
            return 对象.performAction(AccessibilityNodeInfo.ACTION_SELECT);
        }

        public boolean 剪切() {
            if (为空()) return false;
            return 对象.performAction(AccessibilityNodeInfo.ACTION_CUT);
        }

        public boolean 折叠() {
            if (为空()) return false;
            return 对象.performAction(AccessibilityNodeInfo.ACTION_COLLAPSE);
        }

        public boolean 展开() {
            if (为空()) return false;
            return 对象.performAction(AccessibilityNodeInfo.ACTION_EXPAND);
        }

        public boolean 隐藏() {
            if (为空()) return false;
            return 对象.performAction(AccessibilityNodeInfo.ACTION_DISMISS);
        }

        public boolean 前滑() {
            if (为空()) return false;
            return 对象.performAction(AccessibilityNodeInfo.ACTION_SCROLL_FORWARD);
        }

        public boolean 后滑() {
            if (为空()) return false;
            return 对象.performAction(AccessibilityNodeInfo.ACTION_SCROLL_BACKWARD);
        }

        public String 取描述() {
            if (为空()) return null;
            return 对象.getContentDescription().toString();
        }

        public String 取包名() {
            if (为空()) return null;
            return 对象.getPackageName().toString();
        }

        public String 取ID() {
            if (为空()) return null;
            return 对象.getViewIdResourceName();
        }

        public String 取文本() {
            if (为空()) return null;
            CharSequence $文本 = 对象.getText();
            if ($文本 == null) return null;
            return $文本.toString();
        }

        public boolean 选文本(int $开始,int $结束) {
            if (为空()) return false;
            Bundle $数据 = new Bundle();
            $数据.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_SELECTION_START_INT, $开始);
            $数据.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_SELECTION_END_INT, $结束);
            return 对象.performAction(AccessibilityNodeInfo.ACTION_SET_SELECTION, $数据);
        }

        public boolean 插入(String $内容)  {
            if (为空()) return false;
            设备工具.置剪切板($内容);
            return 粘贴();
        }

        public boolean 置文本(String $内容) {
            if (为空()) return false;
            Bundle $数据 = new Bundle();
            $数据.putCharSequence(AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, $内容);
            return 对象.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, $数据);
        }

        public boolean 为空() {
            return 对象 == null;
        }

    }


}


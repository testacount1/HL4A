package 放课后乐园部.基本;

import android.app.*;
import android.content.*;
import android.os.*;
import java.util.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.组件.*;
import 放课后乐园部.脚本.*;

public class 服务 {

    服务() {}

    public static void 启动(Context $上下文,Class<?> $类) {
        if (服务.已启动($类.getName()))return;
        $上下文.startService(new Intent($上下文, $类));
        if (!服务.已启动($类.getName())) {
            throw new 错误("无法启动该服务:"+$类.getName());
        }
    }

    public static void 启动(Context $上下文,String $相对) {
        Class<?> $类 = 反射.取自身类($相对);
        if ($类 != null) {
            启动($上下文,$类);
        } else {
            throw new 错误("本应用没有该服务:"+$相对);
        }
    }

    public static boolean 已启动(String $类名) {
        ActivityManager $am = (ActivityManager) 环境.读取().getSystemService(Context.ACTIVITY_SERVICE);
        ArrayList<ActivityManager.RunningServiceInfo> $服务列表 = (ArrayList<ActivityManager.RunningServiceInfo>)$am.getRunningServices(32767);
        for (ActivityManager.RunningServiceInfo $单个 : $服务列表) {
            if ($单个.service.getClassName().contains($类名)) return true;
        }
        return false;
    }

    public static 连接处理 绑定(基本界面 $界面,Class $类,通用方法 $成功,通用方法 $断开) {
        服务.启动($界面,$类);
        连接处理 $处理 = new 连接处理($成功, $断开);
        $界面.bindService(new Intent($界面, $类), $处理, Context.BIND_AUTO_CREATE);
        $界面.服务连接.添加($处理);
        return $处理;
    }

    public static class 连接处理 implements ServiceConnection {

        基本服务 服务;
        通用方法 成功;
        通用方法 断开;
        boolean 已连接 = false;

        public 连接处理(通用方法 $成功,通用方法 $断开) {
            成功 = $成功;
            断开 = $断开;
        }

        @Override
        public void onServiceConnected(ComponentName $类名,IBinder $绑定器) {
            已连接 = true;
            服务 = ((基本服务.绑定器)$绑定器).取服务();
            if (成功 != null) 成功.调用(服务);
        }

        @Override
        public void onServiceDisconnected(ComponentName $类名) {
            已连接 = false;
            if (断开 != null) 断开.调用();
        }

        public boolean 已连接() {
            return 已连接;
        }

        public 基本服务 取服务() {
            if (已连接)
                return 服务;
            return null;
        }

    }

}

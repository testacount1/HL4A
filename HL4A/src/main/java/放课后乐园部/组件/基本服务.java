package 放课后乐园部.组件;

import android.app.*;
import android.content.*;
import android.os.*;
import 放课后乐园部.事件.*;

public class 基本服务 extends Service {

    public Looper L;
    
    public 通用方法 服务绑定事件;
    public 通用方法 服务销毁事件;
    public 通用方法 重新绑定事件;
    public 通用方法 取消绑定事件;

    @Override
    public void onCreate() {
        super.onCreate();
        L = getMainLooper();
    }

    @Override
    public IBinder onBind(Intent $意图) {
        调用方法.事件(服务绑定事件,$意图);
        return new 绑定器();
    }

    @Override
    public void onRebind(Intent $意图) {
        super.onRebind($意图);
        调用方法.事件(重新绑定事件,$意图);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Object $返回值 = 调用方法.事件(取消绑定事件,intent);
        if ($返回值 instanceof boolean)
            return (boolean)$返回值;
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        调用方法.事件(服务销毁事件);
        super.onDestroy();
    }

    public void 停止() {
        stopSelf();
    }

    public class 绑定器 extends Binder {

        public 基本服务 取服务() {
            return 基本服务.this;
        }

    }



}

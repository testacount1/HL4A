package 放课后乐园部.安卓.组件;

import android.app.*;
import android.content.*;
import android.os.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.收集.*;

public class 基本服务 extends Service {

    public 哈希表<String,通用方法> 所有事件 = new 哈希表<String,通用方法>();

    public void 注册事件(String $事件,通用方法 $方法) {
        所有事件.设置($事件, $方法);
    }

    public boolean 检查事件(String $名称) {
        return 所有事件.检查($名称);
    }

    public Object 调用事件(String $名称,Object... $参数) {
        通用方法 $方法 = 所有事件.读取($名称);
        return 调用方法.事件($方法, $参数);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (检查事件("服务创建事件")) {
            调用事件("服务创建事件");
        } else {
            服务创建事件();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (检查事件("服务销毁事件")) {
            调用事件("服务销毁事件");
        } else {
            服务销毁事件();
        }
    }

    @Override
    public IBinder onBind(Intent $意图) {
        if (检查事件("服务销毁事件")) {
            return (IBinder)调用事件("服务销毁事件", $意图);
        } else {
            return 服务绑定事件($意图);
        }
    }

    @Override
    public void onRebind(Intent $意图) {
        super.onRebind($意图);
        if (检查事件("重新绑定事件")) {
            调用事件("服务绑定事件", $意图);
        } else {
            重新绑定事件($意图);
        }

    }

    @Override
    public boolean onUnbind(Intent $意图) {
        if (检查事件("取消绑定事件")) {
            调用事件("取消绑定事件", $意图);
        } else {
            取消绑定事件();
        }
        return super.onUnbind($意图);
    }

    public void 服务创建事件() {}
    public void 服务销毁事件() {}
    public IBinder 服务绑定事件(Intent $意图) {return new 绑定器();}
    public void 重新绑定事件(Intent $意图) {}
    public void 取消绑定事件() {}

    public class 绑定器 extends Binder {

        public 基本服务 取服务() {
            return 基本服务.this;
        }

    }

}

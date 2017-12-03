package 放课后乐园部.脚本.JavaScript;

import android.content.*;
import android.os.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.组件.*;

public class JS基本服务 extends 基本服务 {

    public JavaScript 当前环境;

	@Override
    public void onCreate() {
        super.onCreate();
        当前环境 = new JavaScript();
        当前环境.压入变量("当前服务", this);
    }

    public void 服务创建事件() {
        当前环境.调用事件("服务创建事件");
    }
 
    @Override
    public IBinder onBind(Intent $意图) {
        当前环境.调用事件("服务绑定事件", $意图);
        return super.onBind($意图);
    }

    @Override
    public void onRebind(Intent $意图) {
        super.onRebind($意图);
        当前环境.调用事件("重新绑定事件", $意图);
    }
    @Override
    public boolean onUnbind(Intent $意图) {
        当前环境.调用事件("取消绑定事件", $意图);
        return super.onUnbind($意图);
    }

    @Override
    public int onStartCommand(Intent $意图,int $标识,int $id) {
        当前环境.调用函数("服务启动事件", $意图);
        return super.onStartCommand($意图, $标识, $id);
    }

    @Override
    public void onDestroy() {
        当前环境.调用函数("服务销毁事件");
        super.onDestroy();
    }

}

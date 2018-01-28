package 放课后乐园部.安卓.组件;

import android.app.*;
import android.content.*;
import android.content.res.*;
import hl4a.runtime.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.工具.*;

public class 基本应用 extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        应用工具.初始化应用(this);
        应用创建事件();
    }

    @Override
    public void attachBaseContext(Context $上下文) {
        super.attachBaseContext($上下文);
        处理环境事件($上下文);
    }

    @Override
    public void onConfigurationChanged(Configuration $新设置) {
        super.onConfigurationChanged($新设置);
        设置改变事件($新设置);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        应用销毁事件();
    }


    public void 应用创建事件() {}
    public void 应用销毁事件() {}
    public void 处理环境事件(Context $上下文) {}
    public void 设置改变事件(Configuration $新设置) {}

    public void 错误处理事件(Thread $线程,Exception $错误) {
        辅助工具.停止();
        应用工具.结束界面($错误);
        Intent $意图 = new Intent(上下文工具.取全局上下文(), ErrorActivity.class);
        $意图.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        $意图.putExtra("错误","当前应用版本 :"+ 应用工具.取版本名() +"\n"+ 错误工具.取整个错误($错误));
        上下文工具.取全局上下文().startActivity($意图);
        字符工具.保存("#错误日志/" + 时间工具.格式() + ".log", 错误工具.取整个错误($错误));
        System.exit(0);
    }

}

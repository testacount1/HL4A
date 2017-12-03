package 放课后乐园部.脚本.JavaScript;

import android.content.*;
import android.os.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.组件.*;

public class JS基本界面 extends 基本界面 {

	public JavaScript 当前环境;

    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);
        当前环境 = new JavaScript();
        当前环境.初始化();
        当前环境.压入常量("当前界面", this);
    }
    
    public void 跳转(String $文件名) {
        try {
            Intent 启动 = new Intent(this, 反射.取类(应用.取包名() + ".JSActivity"));
            启动.putExtra("文件", $文件名);
            startActivity(启动);
        } catch (Exception $错误) {
            错误.普通($错误);
        }
    }
    @Override
    public void onNewIntent(Intent $意图) {
        super.onNewIntent($意图);
        当前环境.调用事件("受到意图事件", $意图);
    }

    public void 界面创建事件(Bundle $环境) {
        当前环境.调用事件("界面创建事件", $环境);
    }

    @Override
    public void onStart() {
        super.onStart();
        当前环境.调用事件("界面开始事件");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        当前环境.调用事件("回到界面事件");
    }

    @Override
    public void onPause() {
        当前环境.调用事件("界面遮挡事件");
        super.onPause();
    }

    @Override
    public void onStop() {
        当前环境.调用事件("离开界面事件");
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        当前环境.调用事件("界面刷新事件");
    }

    @Override
    public void onDestroy() {
        当前环境.调用事件("界面销毁事件");
        super.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        当前环境.调用事件("界面回调事件", requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

}

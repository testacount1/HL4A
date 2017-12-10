package 放课后乐园部.组件;

import android.app.*;
import android.os.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.收集.*;
import android.view.*;
import android.content.*;
import java.io.*;
import 放课后乐园部.脚本.*;

public class 基本界面 extends Activity {

    public Looper L;
    public 集合 服务连接 = new 集合();

    public 通用方法 收到意图事件;

    public 通用方法 界面开始事件;
    public 通用方法 取得焦点事件;
    public 通用方法 失去焦点事件;
    public 通用方法 界面遮挡事件;
    public 通用方法 回到界面事件;
    public 通用方法 界面刷新事件;
    public 通用方法 界面回调事件;
    public 通用方法 离开界面事件;
    public 通用方法 界面销毁事件;

    public Menu 当前菜单;
    public 通用方法 菜单创建事件;
    public 通用方法 菜单选中事件;

    public void 打开布局(View $视图) {
        布局.打开(this, $视图);
    }

    public void 跳转界面(String $文件) {
        脚本管理.跳转界面(this, $文件);
    }

    public void 结束() {
        finish();
    }

    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);
        L = Looper.getMainLooper();
    }

    @Override
    public void onStart() {
        super.onStart();
        环境.设置界面(this);
        调用方法.事件(界面开始事件);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus)
            调用方法.事件(取得焦点事件);
        else 调用方法.事件(失去焦点事件);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu $菜单) {
        当前菜单 = $菜单;
        Object $返回 = 调用方法.事件(菜单创建事件, 当前菜单);
        if ($返回 != null)
            return new Boolean(true).equals($返回);
        return super.onCreateOptionsMenu($菜单);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem $项目) {
        Object $返回 = 调用方法.事件(菜单选中事件, $项目);
        if ($返回 != null)
            return new Boolean(true).equals($返回);
        return super.onOptionsItemSelected($项目);
    }

    @Override
    public void onNewIntent(Intent $意图) {
        super.onNewIntent($意图);
        调用方法.事件(收到意图事件, $意图);
    }

    @Override
    public void onRestart() {
        super.onRestart();
        调用方法.事件(回到界面事件);
    }

    @Override
    public void onResume() {
        super.onResume();
        调用方法.事件(界面刷新事件);
    }

    @Override
    public void onPause() {
        super.onPause();
        调用方法.事件(界面遮挡事件);
    }

    public void 置返回值(int $请求码) {
        setResult($请求码);
    }

    public void 置返回值(int $结果码,Intent $意图) {
        setResult($结果码, $意图);
    }

    public void 置返回值(int $结果码,哈希表 $数据表) {
        Intent $意图 = new Intent();
        $意图.putExtra("数据表", (Serializable)$数据表);
        置返回值($结果码, $意图);
    }

    @Override
    public void onActivityResult(int $请求码,int $结果码,Intent $意图) {
        super.onActivityResult($请求码, $请求码, $意图);
        Object $数据表 = $意图.getSerializableExtra("数据表");
        if ($数据表 != null)
            调用方法.事件(界面回调事件, $请求码, $结果码, $意图, (哈希表)$数据表);
        else 调用方法.事件(界面回调事件, $请求码, $结果码, $意图);
    }

    @Override
    public void onStop() {
        调用方法.事件(离开界面事件);
        super.onStop();
    }

    @Override
    public void onDestroy() {
        调用方法.事件(界面销毁事件);
        if (!服务连接.isEmpty()) {
            for (服务.连接处理 $连接 : 服务连接)
                unbindService($连接);
        }
        super.onDestroy();
    }

}

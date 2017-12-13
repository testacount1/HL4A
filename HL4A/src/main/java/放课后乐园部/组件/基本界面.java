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

    public 通用方法 按键按下事件;

    long 返回时间;

    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event) {

        if (按键按下事件 == null) {

            if (keyCode == KeyEvent.KEYCODE_BACK) {

                long 上次 = 返回时间;

                if ((返回时间 = 时间.时间戳()) - 上次 < 2000) {
                    finish();
                    return true;
                } else {
                    弹窗.提示("再按一次返回键退出 ~");
                    return false;
                }

            } else return super.onKeyDown(keyCode, event);

        } else {

            return 调用方法.事件(按键按下事件, keyCode, event) == true;
        }
        
    }

    public 通用方法 按键弹起事件;

    @Override
    public boolean onKeyUp(int keyCode,KeyEvent event) {
        if (按键弹起事件 != null)
            return 调用方法.事件(按键弹起事件,keyCode,event) == true;
        return super.onKeyUp(keyCode, event);
    }

    public 通用方法 按键长按事件;
    
    @Override
    public boolean onKeyLongPress(int keyCode,KeyEvent event) {
        if (按键长按事件 != null)
            return 调用方法.事件(按键长按事件,keyCode,event) == true;
        return super.onKeyLongPress(keyCode, event);
    }

    public 通用方法 按键单击事件;
    
    @Override
    public boolean onKeyShortcut(int keyCode,KeyEvent event) {
        if (按键单击事件 != null)
            return 调用方法.事件(按键单击事件,keyCode,event) == true;
        return super.onKeyShortcut(keyCode, event);
    }
    
    public 通用方法 按键双击事件;

    @Override
    public boolean onKeyMultiple(int keyCode,int repeatCount,KeyEvent event) {
        if (按键双击事件 != null)
            return 调用方法.事件(按键双击事件,keyCode,repeatCount,event) == true;
        return super.onKeyMultiple(keyCode, repeatCount, event);
    }
    
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
        if (不结束 == false)
        finish();
    }

    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);
        环境.读取().所有界面.添加(this);
        L = Looper.getMainLooper();
    }

    @Override
    public void onStart() {
        super.onStart();
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

    public boolean 不结束 = false;
    
    @Override
    public void onDestroy() {
        调用方法.事件(界面销毁事件);
        if (!服务连接.isEmpty()) {
            for (服务.连接处理 $连接 : 服务连接)
                unbindService($连接);
        }
        super.onDestroy();
        不结束 = true;
    }

}

package 放课后乐园部.组件;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import java.io.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.收集.*;
import 放课后乐园部.弹窗.*;

public class 基本界面 extends Activity {

    public Looper L;

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
    public 通用方法 应用出错事件;
    public 通用方法 按键弹起事件;
    public 通用方法 按键长按事件;
    public 通用方法 按键单击事件;
    public 通用方法 菜单创建事件;
    public 通用方法 菜单选中事件;
    public 通用方法 按键双击事件;


    public boolean onError(Throwable $错误) {
        return new Boolean(true).equals(调用方法.事件(应用出错事件));
    }

    private long 返回时间;


    public Menu 当前菜单;

	public View 当前视图;
	
    public void 打开布局(View $视图) {
		当前视图 = $视图;
        布局.打开(this, $视图);
    }

	public View 找视图(Object $标签) {
		return 当前视图.findViewWithTag($标签);
	}

    public void 跳转界面(Class $类) {
        跳转界面(null, $类, null);
    }

    public void 跳转界面(Class $类,Object... $数据) {
        跳转界面(null, $类 , $数据);
    }

    public void 跳转界面(Integer $请求码,Class $类,Object... $数据) {

        Intent $意图 = new Intent(this, $类);
        if ($数据 != null)
            $意图.putExtra("数据", $数据);
        if ($请求码 == null)
            startActivity($意图);
        else
            startActivityForResult($意图, $请求码);

    }

    public void 跳转脚本(String $文件) {
        跳转脚本(null, $文件, null);
    }

    public void 跳转脚本(String $文件,Object... $数据) {
        跳转脚本(null, $文件 , $数据);
    }

    public void 跳转脚本(Integer $请求码,String $文件,Object... $数据) {

        if ($文件 == null || "".equals($文件))  
            return;
        Class<?> $类 = 反射.取自身类("ScriptActivity");
        Intent $意图 = new Intent(this, $类);
        $意图.putExtra("文件", $文件);
        if ($数据 != null)
            $意图.putExtra("数据", $数据);
        if ($请求码 == null)
            startActivity($意图);
        else
            startActivityForResult($意图, $请求码);

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

    public void 结束() {
        if (!已结束)
            finish();
    }
    
    
    

    public Object[] 传入数据;

    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);
        if (Build.VERSION.SDK_INT >= 21)
            setTheme(android.R.style.Theme_Material_Light_NoActionBar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        环境.读取().所有界面.添加(this);
        L = Looper.getMainLooper();
        Object[] $参数 = ((Object[])getIntent().getSerializableExtra("数据"));
        传入数据 = $参数;
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

    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event) {
        if (按键按下事件 == null) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                long 上次 = 返回时间;
                if ((返回时间 = 时间.时间戳()) - 上次 < 2000) {
                    finish();
                    return true;
                } else {
                    提示.普通("再按一次返回键退出 ~");
                    return false;
                }
            } else return super.onKeyDown(keyCode, event);
        } else {
            return 调用方法.事件(按键按下事件, keyCode, event) == true;
        }
    }

    @Override
    public boolean onKeyUp(int keyCode,KeyEvent event) {
        if (按键弹起事件 != null)
            return 调用方法.事件(按键弹起事件, keyCode, event) == true;
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode,KeyEvent event) {
        if (按键长按事件 != null)
            return 调用方法.事件(按键长按事件, keyCode, event) == true;
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyShortcut(int keyCode,KeyEvent event) {
        if (按键单击事件 != null)
            return 调用方法.事件(按键单击事件, keyCode, event) == true;
        return super.onKeyShortcut(keyCode, event);
    }

    @Override
    public boolean onKeyMultiple(int keyCode,int repeatCount,KeyEvent event) {
        if (按键双击事件 != null)
            return 调用方法.事件(按键双击事件, keyCode, repeatCount, event) == true;
        return super.onKeyMultiple(keyCode, repeatCount, event);
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

    public 集合 服务连接 = new 集合();

    private boolean 已结束 = false;

    @Override
    public void onDestroy() {
        if (已结束 == false) {
            调用方法.事件(界面销毁事件);
            if (!服务连接.isEmpty()) {
                for (服务.连接处理 $连接 : 服务连接)
                    unbindService($连接);
            }
            super.onDestroy();
            已结束 = true;
        }
    }

}

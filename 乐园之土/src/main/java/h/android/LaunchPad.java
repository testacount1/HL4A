package h.android;

import android.os.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.安卓.组件.*;
import 放课后乐园部.安卓.资源.布局.*;
import 放课后乐园部.线程.*;
import h.ide.activity.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.工具.*;

public class LaunchPad extends 基本界面 {

	@Override
	public void 界面创建事件(Bundle $恢复) {
		打开布局(new 布局_初始化(this));
		请求权限();
	}

	@Override
	public void 权限回调事件() {
		//提示工具.普通(文件工具.检查地址("$"));
		跳转界面(MainActivity.class);
		结束界面();
	}
	
}

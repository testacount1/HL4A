package hl4a.ide;

import android.os.*;
import hl4a.ide.activity.*;
import 放课后乐园部.安卓.组件.*;
import 放课后乐园部.安卓.资源.布局.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.工具.*;
import android.content.*;
import java.io.*;
import java.net.*;
import 放课后乐园部.线程.*;
import 放课后乐园部.事件.*;
import hl4a.ide.util.*;

public class LaunchPad extends 基本界面 {

	@Override
	public void 界面创建事件(Bundle $恢复) {
		打开布局(new 布局_初始化(this));
		请求权限();
	}

	@Override
	public void 权限回调事件() {
		final String 文件 = getIntent().getDataString();
		new 线程(new 通用方法() {
				@Override
				public Object 调用(Object[] $参数) {
					String $文件 = 文件;
					if ($文件 != null) {
						if ($文件.startsWith("file://")) {
							$文件 = 字符工具.截取开始($文件, "file://", null);
						}
						$文件 = URLDecoder.decode($文件);
						提示工具.普通($文件);
						if (文件工具.是文件($文件)) {
							跳转界面(MainActivity.class,$文件);
							结束界面();
							return null;
						}
					}
					跳转界面(MainActivity.class);
					结束界面();
					return null;
				}
			}).启动();
	}

}
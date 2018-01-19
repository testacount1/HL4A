package 放课后乐园部.安卓.脚本.组件;

import 放课后乐园部.安卓.组件.*;
import android.os.*;
import org.mozilla.javascript.annotations.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.安卓.脚本.*;
import android.content.*;
import 放课后乐园部.工具.*;
import 放课后乐园部.收集.*;

public class 脚本界面 extends 基本界面 {

	public 基本脚本 当前脚本;

	@Override
	public void 界面创建事件(Bundle $恢复) {
		String $脚本地址 = 读取字符串("脚本");
		if (文件工具.是文件($脚本地址)) {
			当前脚本 = new JavaScript();
			当前脚本.压入变量("当前界面", this);
			当前脚本.运行文件($脚本地址);
			if (检查事件("界面创建事件")) {
				调用事件("界面创建事件", $恢复);
			}
		} else {
			结束界面();
		}
	}

}

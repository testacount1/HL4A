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

	public 基本脚本 当前环境;
	public String 当前目录;
	public String 当前文件;
	public String 当前脚本;

	@Override
	public void 界面创建事件(Bundle $恢复) {
		String $脚本地址 = 读取字符串("脚本");
		if (文件工具.是文件($脚本地址)) {
			当前脚本 = 文件工具.检查地址($脚本地址);
			当前目录 = 文件工具.取目录(当前脚本);
			当前文件 = 文件工具.取名称(当前脚本);
			当前环境 = new JavaScript();
			当前环境.压入变量("当前界面", this);
			当前环境.运行文件(当前脚本);
			if (检查事件("界面创建事件")) {
				调用事件("界面创建事件", $恢复);
			}
		} else {
			结束界面();
		}
	}

	@Override
	public void 跳转脚本(Integer $请求码,String $类,Object[] $数据) {
		if (字符工具.以开始($类, "../")) {
			$类 = 文件工具.取目录(当前目录) + "/" + $类.substring(3);
		} else if (字符工具.以开始($类, "./")) {
			$类 = 当前目录 + "/" + $类.substring(2);
		}
		super.跳转脚本($请求码, $类, $数据);
	}
	

}

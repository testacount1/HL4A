package h.ide.layout;

import android.content.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.视图.适配器.*;
import 放课后乐园部.安卓.资源.布局.*;
import 放课后乐园部.视图.扩展.*;
import 放课后乐园部.视图.*;

public class 布局_编辑界面 extends 布局_侧滑界面 {
	
	public 符号栏 符号;
	public 代码框 代码;
	public 列表视图 列表;
	public 文件适配器 适配器;
	
	public 布局_编辑界面(Context $上下文) {
		super($上下文);
		标题.左按钮(打开侧滑);
		符号 = new 符号栏(底层);
		代码 = new 代码框(底层);
		符号.置代码框(代码);
		列表 = new 列表视图(侧滑);
	}
	
	通用方法 打开侧滑 = new 通用方法() {
		@Override
		public Object 调用(Object[] $参数) {
			打开侧滑();
			return null;
		}
	};
	
}

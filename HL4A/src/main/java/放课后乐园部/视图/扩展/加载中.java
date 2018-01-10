package 放课后乐园部.视图.扩展;

import android.content.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.视图.*;

import 放课后乐园部.视图.文本视图;

public class 加载中 extends 线性布局 {

	public 进度条 $进度;
	public 文本视图 $文本;

	public 加载中(Context $上下文) {
		this($上下文, "加载中");
	}

	public 加载中(Context $上下文,String $内容) {
		super($上下文);

		置背景(颜色.白色);
		置方向("水平");
		置重力("中间");

		$进度 = new 进度条($上下文);
		$进度.加入到(this);

		$文本 = new 文本视图($上下文);
		$文本.置文本($内容);
		$文本.加入到(this);

	}

	public 文本视图 取文本对象() {
		return $文本;
	}

	public void 置文本(String $内容) {
		$文本.置文本($内容);
	}

	public String 取文本() {
		return $文本.取文本();
	}

}

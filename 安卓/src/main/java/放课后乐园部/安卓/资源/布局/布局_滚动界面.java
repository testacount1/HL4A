package 放课后乐园部.安卓.资源.布局;

import android.content.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.视图.扩展.*;

public class 布局_滚动界面 extends 线性布局 {
	
	public 标题栏 标题;
	public 滚动视图 滚动;
	public 线性布局 底层;
	
	public 布局_滚动界面(Context $上下文) {
		super($上下文);
		标题 = new 标题栏(this);
		滚动 = new 滚动视图(this);
		底层 = new 线性布局(滚动);
	}
	
}

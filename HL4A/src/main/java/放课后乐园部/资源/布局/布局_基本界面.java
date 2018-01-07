package 放课后乐园部.资源.布局;

import android.content.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.视图.扩展.*;

public class 布局_基本界面 extends 线性布局 {
	
	public 标题栏 标题;
	public 线性布局 底层;
	
	public 布局_基本界面(Context $上下文) {
		super($上下文);
		标题 = new 标题栏($上下文);
		标题.加入到(this);
		底层 = new 线性布局($上下文);
		底层.加入到(this);
	}
	
}

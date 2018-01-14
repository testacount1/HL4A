package h.ide.layout;

import 放课后乐园部.视图.*;
import android.content.*;

public class 布局_设置弹窗 extends 线性布局 {
	
	public 编辑框 编辑;
	public String 类型;
	
	public 布局_设置弹窗(Context $上下文) {
		super($上下文);
		置填充(0,0,"16dp","16dp");
		编辑 = new 编辑框(this);
		编辑.置文本显示在同一行();
	}
	
}

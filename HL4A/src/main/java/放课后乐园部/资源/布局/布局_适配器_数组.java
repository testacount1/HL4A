package 放课后乐园部.资源.布局;

import android.content.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.基本.*;

public class 布局_适配器_数组 extends 线性布局 {
	
	public 文本控件 文本;
	
	public 布局_适配器_数组(Context $上下文) {
		super($上下文);
		置高度("自动");
		置填充(主题.默认填充());
		置重力("中间垂直");
		置左填充(主题.默认填充());
		文本 = new 文本控件($上下文);
		文本.加入到(this);
	}
	
}

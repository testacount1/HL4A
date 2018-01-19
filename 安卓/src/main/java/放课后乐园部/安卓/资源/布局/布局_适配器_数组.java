package 放课后乐园部.安卓.资源.布局;

import android.content.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.工具.*;

public class 布局_适配器_数组 extends 线性布局 {
	
	public 文本视图 文本;
	
	public 布局_适配器_数组(Context $上下文) {
		super($上下文);
		置高度("自动");
		置填充(主题工具.取默认填充());
		置重力("中间垂直");
		置左填充(主题工具.取默认填充());
		文本 = new 文本视图(this);
	}
	
}

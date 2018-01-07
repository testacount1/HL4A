package 放课后乐园部.视图.事件;

import android.content.*;
import 放课后乐园部.事件.*;

public class 弹窗按钮单击 implements DialogInterface.OnClickListener {

	通用方法 单击;
	
	public 弹窗按钮单击(通用方法 $单击) {
		单击 = $单击;
	}
	
	@Override
	public void onClick(DialogInterface $弹窗,int $位置) {
		调用方法.事件(单击,$弹窗,$位置);
	}

}

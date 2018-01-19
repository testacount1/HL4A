package 放课后乐园部.安卓.视图.事件;

import android.view.*;
import android.view.View.*;
import 放课后乐园部.事件.*;

public class 单击 implements OnClickListener {

	private 通用方法 事件;
	
	public 单击(通用方法 $事件) {
		事件 = $事件;
	}
	
	@Override
	public void onClick(View $对象) {
        调用方法.事件(事件,$对象);
	}

	
}

package 放课后乐园部.安卓.视图.事件;

import android.view.*;
import android.view.View.*;
import 放课后乐园部.事件.*;

public class 长按 implements OnLongClickListener {

	private 通用方法 事件;
	
	public 长按(通用方法 $事件) {
		事件 = $事件;
	}
	
	@Override
	public boolean onLongClick(View $对象) {
		// TODO: Implement this method
		return (调用方法.事件(事件,$对象) == true);
	}

	
}

package 放课后乐园部.视图.事件;

import android.text.*;
import 放课后乐园部.事件.*;

public class 文本改变 implements TextWatcher {

		public 通用方法 改变前 = null;
		public 通用方法 已改变 = null;
		public 通用方法 改变后 = null;

		public 文本改变(通用方法 $事件) {
				已改变 = $事件;
		}

		public 文本改变(通用方法 $改变前,通用方法 $已改变,通用方法 $改变后) {
				改变前 = $改变前;
				已改变 = $已改变;
				改变后 = $改变后;
		}

		@Override
		public void beforeTextChanged(CharSequence p1,int p2,int p3,int p4) {
				if (改变前 != null) 改变前.调用(p1, p2, p3, p4);
		}

		@Override
		public void onTextChanged(CharSequence p1,int p2,int p3,int p4) {
				if (已改变 != null) 已改变.调用(p1, p2, p3, p4);
		}

		@Override
		public void afterTextChanged(Editable p1) {
				if (改变后 != null) 改变后.调用(p1);
		}

}

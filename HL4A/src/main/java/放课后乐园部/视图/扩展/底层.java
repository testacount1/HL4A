package 放课后乐园部.视图.扩展;

import android.content.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.视图.*;

public class 底层 extends 线性布局 {

		public 底层(Context $上下文) {
				super($上下文);
				this.置宽度("最大")
						.置宽度("最大")
						.置方向("垂直")
						.置背景(主题.背景());
		}
		
		public 底层(Context $上下文,String $方向) {
				this($上下文);
				置方向($方向);
		}

}

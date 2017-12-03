package 放课后乐园部.视图.扩展;

import 放课后乐园部.视图.*;
import android.content.*;

public class 分隔 extends 线性布局 {

		public 分隔(Context $上下文) {
				super($上下文);
				this
						.置宽度("最大")
						.置高度("2dp");
		}
		
		public 分隔(Context $上下文,String $大小) {
				this($上下文);
				置高度($大小);
		}

}

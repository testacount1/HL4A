package 放课后乐园部.视图.扩展;

import android.content.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.视图.*;

public class 标题栏 extends 线性布局 {

		public 文本 标题;

		public 标题栏(Context $上下文) {
				this($上下文, "");
		}

		public 标题栏(Context $上下文,String $标题内容) {
				super($上下文);

				this
						.置宽度("最大")
						.置高度("56dp")
						.置重力("中间垂直")
						.置背景颜色(主题.标题栏());

				标题 = new 文本($上下文)
						.置主题("标题")
						.置文本($标题内容)
						.置左填充("16dp")
						.加入到(this);
		}
		
		public String 取标题() {
				return 标题.取文本();
		}
		
		public void 置标题(String $内容) {
				标题.置文本($内容);
		}
		

}

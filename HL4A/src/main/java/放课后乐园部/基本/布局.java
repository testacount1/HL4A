package 放课后乐园部.基本;

import android.app.*;
import android.view.*;
import 放课后乐园部.收集.*;
import 放课后乐园部.注解.注释.*;
import 放课后乐园部.视图.*;

@功能("对布局的一些操作")
public class 布局 {

		private 布局() {}

		public static 哈希表 布局表;

		static {
				布局表 = new 哈希表();
		}

		private static View 取布局(Activity $界面) {
				return (View)布局表.读取($界面);
		}

		private static void 置布局(Activity $界面,View $视图) {
				布局表.设置($界面, $视图);
		}

		@功能("设置布局 封装了状态栏")
		@警告("布局必须用这个方法打开")
		public static void 打开(Activity $界面,View $布局) {
				$界面.getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				线性布局 $底层 = new 线性布局($界面)
				.置方向("垂直")
				.置宽度("最大")
				.置高度("最大")
				.置背景颜色(主题.背景());
				线性布局 $空栏 = new 线性布局($界面)
				.置背景颜色(主题.状态栏())
				.置宽度("最大")
				.置高度(应用.取状态栏高度($界面));
				$底层.加入子元素($空栏)
				.加入子元素($布局);
				$界面.setContentView($底层);
				置布局($界面, $布局);
		}

		@功能("读取界面的布局")
		public static View 读取(Activity $界面) {
				return 取布局($界面);
		}

}

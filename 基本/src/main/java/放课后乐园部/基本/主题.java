package 放课后乐园部.基本;

import android.graphics.drawable.*;
import 放课后乐园部.收集.*;
import 放课后乐园部.注解.注释.*;

@功能("规范了可以切换的主题")
@说明("5是颜色第6位基本色,7是第八位基本深色")
public class 主题 {

		public static 集合 当前颜色列表;

		static {
				置主题(颜色.靛蓝);
		}
		
		@功能("设置主题颜色")
		public static void 置主题(集合 $颜色) {
				当前颜色列表 = $颜色;
		}
		
		public static void 置主题(String[] $颜色) {
				当前颜色列表 = 集合.到集合($颜色);
		}

		public static String 状态栏() {
				return (String) 当前颜色列表.读取(7);
		}
		
		public static String 标题栏() {
				return (String)当前颜色列表.读取(5);
		}

		public static String 标题栏_文字() {
				return 颜色.白色;
		}

		public static Drawable 菜单_按钮() {
				return 绘画.透明();
		}

		public static String 背景() {
				return 颜色.白色;
		}
		
		public static String 按钮() {
				return (String) 当前颜色列表.读取(5);
		}
		
		public static String 按钮_按下() {
				return (String) 当前颜色列表.读取(7);
		}
		
		public static String 按钮_文本() {
				return 颜色.白色;
		}

		public static String 文字() {
				return (String) 当前颜色列表.读取(5);
		}
		
		public static String 进度条() {
				return (String) 当前颜色列表.读取(5);
		}

}

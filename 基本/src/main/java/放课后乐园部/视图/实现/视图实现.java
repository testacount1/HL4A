package 放课后乐园部.视图.实现;

import android.app.*;
import android.graphics.drawable.*;
import android.view.*;
import android.view.ViewGroup.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.视图.事件.*;

public final class 视图实现 {

		private 视图实现() {}

		// AddView

		public static void 加入到(View $视图,ViewGroup $布局) {
				String $类名 = $布局.getClass().getName();
				Class $类 = 反射.取类($类名 + "$MarginLayoutParams");
				if ($类 == null) {
						$类 = 反射.取类($类名 + "$LayoutParams");
				}
				if ($类 != null) {
						置设置($视图, (MarginLayoutParams)
								反射.实例化($类, 取设置($视图)));
				}
				$布局.addView($视图);
		}
		
		//setContentView
		
		public static void 打开(View $视图,Activity $界面) {
				布局.打开($界面,$视图);
		}

		// Tag

		public static void 置标签(View $视图,Object $标签) {
				$视图.setTag($标签);
		}

		public static Object 取标签(View $视图) {
				return $视图.getTag();
		}
		
		public static void 置主题(视图摘要 $视图,String $主题) {
				视图.置主题($视图, $主题);
		}

		// Width/Height
		public static void 置单击事件(View $视图,通用方法 $事件) {
				$视图.setOnClickListener(new 单击($事件));
		}

		public static void 置长按事件(View $视图,通用方法 $事件) {
				$视图.setOnLongClickListener(new 长按($事件));
		}

		public static void 置触摸事件(View $视图,通用方法 $事件) {
				$视图.setOnTouchListener(new 触摸($事件));
		}

		public static void 置宽度(View $视图,Object $宽度) {
				ViewGroup.MarginLayoutParams $设置 = 取设置($视图);
				$设置.width = 视图.检查大小($宽度).intValue();
				置设置($视图, $设置);
		}

		public static void 置高度(View $视图,Object $高度) {
				ViewGroup.MarginLayoutParams $设置 = 取设置($视图);
				$设置.height = 视图.检查大小($高度).intValue();
				置设置($视图, $设置);
		}

		public static void 置边距(View $视图,Object $全局) {
				置边距($视图, $全局, $全局, $全局, $全局);
		}

		public static void 置上边距(View $视图,Object $边距) {
				置边距($视图, $边距, null, null, null);
		}

		public static void 置下边距(View $视图,Object $边距) {
				置边距($视图, null, $边距, null, null);
		}

		public static void 置左边距(View $视图,Object $边距) {
				置边距($视图, null, null, $边距, null);
		}

		public static void 置右边距(View $视图,Object $边距) {
				置边距($视图, null, null, null, $边距);
		}

		public static void 置边距(View $视图,Object $上,Object $下,Object $左,Object $右) {
				ViewGroup.MarginLayoutParams $设置 = 取设置($视图);
				try {
						int $上边距 = $设置.topMargin;
						int $下边距 = $设置.bottomMargin;
						int $左边距 = $设置.leftMargin;
						int $右边距 = $设置.rightMargin;
						$上边距 = (($上 = 视图.检查大小($上)) == null) ? $上边距 : (int) $上;
						$下边距 = (($下 = 视图.检查大小($下)) == null) ? $下边距 : (int) $下;
						$左边距 = (($左 = 视图.检查大小($左)) == null) ? $左边距 : (int) $左;
						$右边距 = (($右 = 视图.检查大小($左)) == null) ? $右边距 : (int) $右;
						$设置.setMargins($左边距, $上边距, $右边距, $下边距);
						// 这里的边距已经设置到了，但是为什么没有应用呢？
						置设置($视图, $设置);
				} catch (Exception $错误) {
						错误.普通($错误);
				}
		}

		// Visible

		public static void 置状态(View $视图,String $状态) {
				try {
						int $状态i = 0;
						switch ($状态) {
								case "占位":case "invisible":case "4":
										$状态i = 4;break;
								case "隐藏":case "gone":case "8":
										$状态i = 8;break;
						}
						$视图.setVisibility($状态i);
				} catch (Exception $错误) {}
		}

		public static void 显示(View $视图) {
				置状态($视图, "显示");
		}

		public static void 占位(View $视图) {
				置状态($视图, "占位");
		}

		public static void 隐藏(View $视图) {
				置状态($视图, "隐藏");
		}

		public static String 取状态(View $视图) {
				try {
						int $状态 = $视图.getVisibility();
						switch ($状态) {
								case 0:return "显示";
								case 4:return "占位";
								case 8:return "隐藏";
						}
				} catch (Exception $错误) {}
				return "未知";
		}

		// Background

		public static void 置背景(View $视图,Object $背景) {
				try {
						if ($背景 instanceof Drawable)
								$视图.setBackground((Drawable)$背景);
						else if ($背景 instanceof Integer)
								置背景颜色($视图, (Integer)$背景);
						else if ($背景 instanceof String)
								switch ((String)$背景) {
										case "透明":case "through":置背景($视图, 绘画.透明());break;
										case "白色":case "white":置背景($视图, 绘画.白色());break;
										case "黑色":case "black":置背景($视图, 绘画.黑色());break;
										default:置背景颜色($视图, (String)$背景);
								}
				} catch (Exception $错误) {}
		}


		// BackgroundColor

		public static void 置背景颜色(View $视图,Object $颜色) {
				try {
						if ($颜色 instanceof Integer)
								$视图.setBackgroundColor((Integer)$颜色);
						else if ($颜色 instanceof String)
								$视图.setBackgroundColor(视图.检查颜色($颜色));
				} catch (Exception $错误) {}
		}

		public static void 置填充(View $视图,Object $全局) {
				置填充($视图, $全局, $全局, $全局, $全局);
		}

		public static void 置上填充(View $视图,Object $填充) {
				置填充($视图, $填充, null, null, null);
		}

		public static void 置下填充(View $视图,Object $填充) {
				置填充($视图, null, $填充, null, null);
		}

		public static void 置左填充(View $视图,Object $填充) {
				置填充($视图, null, null, $填充, null);
		}

		public static void 置右填充(View $视图,Object $填充) {
				置填充($视图, null, null, null, $填充);
		}

		public static void 置填充(View $视图,Object $上,Object $下,Object $左,Object $右) {

				try {
						Integer $上填充 = (($上 = 视图.检查大小($上)) == null) ? $视图.getPaddingTop() : (Integer) $上;
						Integer $下填充 = (($下 = 视图.检查大小($下)) == null) ? $视图.getPaddingBottom() : (Integer) $下;
						Integer $左填充 = (($左 = 视图.检查大小($左)) == null) ? $视图.getPaddingLeft() : (Integer) $左;
						Integer $右填充 = (($右 = 视图.检查大小($右)) == null) ? $视图.getPaddingRight() : (Integer) $右;

						$视图.setPadding($左填充, $上填充, $右填充, $下填充);
				} catch (Exception $错误) {
						错误.普通($错误);
				}

		}

		public static void 初始化控件(View $视图) {
				$视图.setLayoutParams(new MarginLayoutParams(-2, -2));
		}

		private static MarginLayoutParams 取设置(View $视图) {
				return (MarginLayoutParams) $视图.getLayoutParams();
		}

		private static void 置设置(View $视图,MarginLayoutParams $设置) {
				$视图.setLayoutParams($设置);
				$视图.requestLayout();
		}


}

package 放课后乐园部.视图.实现;

import android.graphics.*;
import android.graphics.drawable.*;
import android.text.*;
import android.text.method.*;
import android.widget.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.视图.事件.*;

public final class 文本实现 {

		private 文本实现() {}

		public static void 置文本(final TextView $视图,final String $内容) {
            处理.主线程(new 通用方法() {
                    @Override
                    public Object 调用(Object[] $参数) {
                        $视图.setText($内容);
                        return null;
                    }
                });
				
		}

		public static void 置HTML文本(TextView $视图,String $HTML) {
				$视图.setMovementMethod(ScrollingMovementMethod.getInstance());
				$视图.setText(Html.fromHtml($HTML, new Html.ImageGetter() {
														@Override
														public Drawable getDrawable(String $地址) {
																Drawable $绘画 = 绘画.图片转绘画($地址);
																$绘画.setBounds(0, 0, $绘画.getIntrinsicWidth(), $绘画.getIntrinsicHeight());
																return $绘画;
														}
												}, null));
		}

		public static String 取文本(TextView $视图) {
				return $视图.getText().toString();
		}

		public static void 置文本大小(TextView $视图,Object $大小) {
				$视图.setTextSize(视图.检查大小($大小));
		}

		public static void 置文本颜色(TextView $视图,Object $颜色) {
				if ($颜色 instanceof Integer)
						$视图.setTextColor((Integer)$颜色);
				else if ($颜色 instanceof String)
						$视图.setTextColor(视图.检查颜色($颜色));
		}

		public static void 置文本字体(TextView $视图,String $地址) {
				$地址 = 文件.检查地址($地址);
				置文本字体($视图, 字体.取字体($地址));
		}

		public static void 置文本字体(TextView $视图,Typeface $字体) {
				$视图.setTypeface($字体);
		}

		public static void 置文本重力(TextView $视图,String $重力) {
				$视图.setGravity(视图.检查重力($重力));
		}

		public static void 置文本显示在同一行(TextView $视图) {
				$视图.setSingleLine();
		}

		public static void 置文本显示在同一行(TextView $视图,Boolean $是否) {
				$视图.setSingleLine($是否 == true);
		}

		public static void 置行数(TextView $视图,int $行数) {
				$视图.setLines($行数);
		}

		public static void 置最小行数(TextView $视图,int $行数) {
				$视图.setMinLines($行数);
		}

		public static void 置最大行数(TextView $视图,int $行数) {
				$视图.setMaxLines($行数);
		}

		public static void 置链接可点击(TextView $视图) {
				置链接可点击($视图, true);
		}

		public static void 置链接可点击(TextView $视图,Boolean $是否) {
				$视图.setLinksClickable($是否 == true);
		}

		public static void 置链接颜色(TextView $视图,Object $颜色) {
				$视图.setLinkTextColor($颜色);
		}
		
		public static void 置文本改变事件(TextView $视图,通用方法 $改变) {
				$视图.addTextChangedListener(new 文本改变($改变));
		}
		
		public static void 置文本改变事件(TextView $视图,通用方法 $改变前,通用方法 $已改变,通用方法 $改变后) {
				$视图.addTextChangedListener(new 文本改变($改变前,$已改变,$改变后));
		}

}

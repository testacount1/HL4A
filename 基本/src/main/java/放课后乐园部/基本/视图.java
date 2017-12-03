package 放课后乐园部.基本;

import android.text.*;
import android.view.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.视图.实现.*;

public class 视图 {

		private 视图() {}

		public static void 置主题(视图摘要 $视图,String $主题) {

				String $类名 = $视图.getClass().getName();
				$类名 = 字符.截取开始($类名, "放课后乐园部.视图.", null);

				switch ($类名) {

						case "文本控件":

								文本控件 $文本 = (文本控件) $视图;

								switch ($主题) {
										case "默认":
												$文本
														.置文本大小("11dp")
														.置文本颜色(主题.文字()); break;
										case "标题":
												$文本
														.置文本大小("15dp")
														.置文本颜色(颜色.白色); break;
								}

								break;

						case "按钮":

								按钮 $按钮 = (按钮) $视图;

								switch ($主题) {

										case "默认":
												$按钮
														.置宽度("最大")
														.置高度("56dp")
														.置文本颜色(主题.按钮_文本())
														.置文本重力("中间垂直")
														.置背景(绘画.生成背景(主题.按钮(), 主题.按钮_按下()));

								}

				}

		}

		public static Integer 检查输入类型(Object $类型) {
				if ($类型 instanceof Integer) return (Integer)$类型;
				if ($类型 instanceof String)
						switch ((String)$类型) {
								case "文本":return InputType.TYPE_CLASS_TEXT;
								case "手机":return InputType.TYPE_CLASS_PHONE;
								case "数字":return InputType.TYPE_CLASS_NUMBER;
								case "日期":return InputType.TYPE_CLASS_DATETIME;
								case "日期-日期":return InputType.TYPE_DATETIME_VARIATION_DATE;
								case "日期-普通":return InputType.TYPE_DATETIME_VARIATION_NORMAL;
								case "日期-时间":return InputType.TYPE_DATETIME_VARIATION_TIME;
								case "数字-十进制":return InputType.TYPE_NUMBER_FLAG_DECIMAL;
								case "数字-带符号":return InputType.TYPE_NUMBER_FLAG_SIGNED;
								case "数字-普通":return InputType.TYPE_NUMBER_VARIATION_NORMAL;
								case "数字-密码":return InputType.TYPE_NUMBER_VARIATION_PASSWORD;
								case "文本-自动完成":return InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
								case "文本-自动矫正":return InputType.TYPE_TEXT_FLAG_AUTO_CORRECT;
								case "文本-大写字符":return InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS;
								case "文本-大写句子":return InputType.TYPE_TEXT_FLAG_CAP_SENTENCES;
								case "文本-大写单词":return InputType.TYPE_TEXT_FLAG_CAP_WORDS;
								case "文本-邮箱":return InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;
								case "文本-邮件":return InputType.TYPE_TEXT_VARIATION_EMAIL_SUBJECT;
								case "文本-长信息":return InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE;
								case "文本-普通":return InputType.TYPE_TEXT_VARIATION_NORMAL;
								case "文本-密码":return InputType.TYPE_TEXT_VARIATION_PASSWORD;
								case "文本-人名":return InputType.TYPE_TEXT_VARIATION_PERSON_NAME;
								case "文本-联系人":return InputType.TYPE_TEXT_VARIATION_POSTAL_ADDRESS;
								case "文本-短信":return InputType.TYPE_TEXT_VARIATION_SHORT_MESSAGE;
								case "文本-链接":return InputType.TYPE_TEXT_VARIATION_URI;
								case "文本-密码-显示":return InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;
								case "文本-网页-编辑框":return InputType.TYPE_TEXT_VARIATION_WEB_EDIT_TEXT;
								case "文本-网页-邮箱":return InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS;
								case "文本-网页-密码":return InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD;
						}
				return InputType.TYPE_NULL;
		}

		public static Integer 检查颜色(Object $颜色) {
				if ($颜色 instanceof Integer)
						return (Integer) $颜色;
				if ($颜色 instanceof String && 字符.以开始((String)$颜色, "#"))
						return 颜色.颜色转颜色((String)$颜色);
				return null;
		}

		public static Integer 检查大小(Object $大小) {
				if ($大小 == null) return null;
				if ($大小 instanceof Float) return (Integer) $大小;
				if ($大小 instanceof Integer) return (Integer) $大小;
				if ($大小 instanceof String) {
						switch ((String)$大小) {
								case "最大":case "-1":return -1;
								case "最小":case "-2":return -2;
						}
						String $结束 = 字符.小写(字符.取结束后((String)$大小, 2));
						Integer $数量 = new Integer(字符.取结束前((String)$大小, 2));
						switch ($结束) {
								case "px":return 转换.px($数量);
								case "dp":return 转换.dp($数量);
								case "sp":return 转换.sp($数量);
								case "pt":return 转换.pt($数量);
								case "mm":return 转换.mm($数量);
								case "in":return 转换.in($数量);
						}
				}
				return -2;
		}

		public static Integer 检查重力(String $重力) {
				Integer $重力类型 = Gravity.NO_GRAVITY;
				String[] $设置 = $重力.toLowerCase().split("[|]");
				for (String $单个 : $设置) {
						switch ($单个) {
								case "center":case "中间":
										$重力类型 = $重力类型 | Gravity.CENTER;
										break;
								case "left":case "左边":
										$重力类型 = $重力类型 | Gravity.LEFT;
										break;
								case "textStart":case "文本开始":
										$重力类型 = $重力类型 | Gravity.START;
										break;
								case "right":case "右边":
										$重力类型 = $重力类型 | Gravity.RIGHT;
										break;
								case "textEnd":case "文本结束":
										$重力类型 = $重力类型 | Gravity.END;
										break;
								case "top":case "上边":
										$重力类型 = $重力类型 | Gravity.TOP;
										break;
								case "bottom":case "下边":
										$重力类型 = $重力类型 | Gravity.BOTTOM;
										break;
								case "center_horizontal":case "中左":case "中间水平":
										$重力类型 = $重力类型 | Gravity.CENTER_HORIZONTAL;
										break;
								case "center_vertical":case "中上":case "中间垂直":
										$重力类型 = $重力类型 | Gravity.CENTER_VERTICAL;
										break;
						}
				}
				return $重力类型;
		}

}

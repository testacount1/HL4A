package 放课后乐园部.安卓.工具;

import 放课后乐园部.安卓.图形.*;

public class 主题工具 {

	private static 颜色 主题颜色;
	private static String 圆角大小;
	private static String 大文本大小;
	private static String 文本大小;
	private static String 小文本大小;
	private static String 默认填充;
	private static String 中等填充;

	public static void 置中等填充(String $填充) {
		中等填充 = $填充;
	}

	public static String 取中等填充() {
		return 中等填充;
	}

	public static void 置小文本大小(String $大小) {
		小文本大小 = $大小;
	}

	public static String 取小文本大小() {
		return 小文本大小;
	}

	public static void 置大文本大小(String $大小) {
		主题工具.大文本大小 = $大小;
	}

	public static String 取大文本大小() {
		return 大文本大小;
	}

	public static void 置默认填充(String $填充) {
		默认填充 = $填充;
	}

	public static String 取默认填充() {
		return 默认填充;
	}

	public static void 置文本大小(String $大小) {
		文本大小 = $大小;
	}

	public static String 取文本大小() {
		return 文本大小;
	}

	public static void 置圆角大小(String $大小) {
		圆角大小 = $大小;
	}

	public static String 取圆角大小() {
		return 圆角大小;
	}

	public static void 置主题颜色(颜色 $颜色) {
		主题颜色 = $颜色;
	}

	public static 颜色 取主题颜色() {
		return 主题颜色;
	}

}

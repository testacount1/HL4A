package 放课后乐园部.安卓.视图.实现;

import android.widget.*;
import 放课后乐园部.安卓.工具.*;

public final class 编辑框实现 {

	private 编辑框实现() {}

	public static void 置默认文本(EditText $视图,String $内容) {
		$视图.setHint($内容);
	}

	public static String 取默认文本(EditText $视图) {
		return $视图.getHint().toString();
	}

	public static void 置默认文本颜色(EditText $视图,Object $颜色) {
		$视图.setHintTextColor(视图工具.检查颜色($颜色));
	}

	public static void 置输入类型(EditText $视图,Object $类型) {
		$视图.setInputType(视图工具.检查输入类型($类型));
	}

	public static int 取输入类型(EditText $视图) {
		return $视图.getInputType();
	}

	public static void 置输入重力(EditText $视图,String $重力) {
		$视图.setGravity(视图工具.检查重力($重力));
	}

}

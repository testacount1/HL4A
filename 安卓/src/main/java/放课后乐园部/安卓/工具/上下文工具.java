package 放课后乐园部.安卓.工具;

import android.app.*;
import 放课后乐园部.安卓.组件.*;

public class 上下文工具 {

	private static 基本应用 全局上下文;

	public static void 置全局上下文(基本应用 $上下文) {
		全局上下文 = $上下文;
	}

	public static 基本应用 取全局上下文() {
		return 全局上下文;
	}

}

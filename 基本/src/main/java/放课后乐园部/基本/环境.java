package 放课后乐园部.基本;

import android.content.*;

public class 环境 {

		环境() {}

		private static Context 全局上下文;

		public static void 设置(Context 上下文) {
				全局上下文 = 上下文;
		}

		public static Context 读取() {
				return 全局上下文;
		}

}

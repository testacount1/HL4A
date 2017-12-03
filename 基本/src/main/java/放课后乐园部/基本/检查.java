package 放课后乐园部.基本;

import 放课后乐园部.注解.注释.*;

@说明("检查操作")
public class 检查 {

		private 检查() {}
		
		@功能("检查对象是否为空")
		public static void 空指针(
				@参数("错误") String $错误,
				@参数("被检查的对象") Object... $对象组) {
				for (Object $对象 : $对象组) {

						if (
								$对象 != null &&
								!("".equals($对象))
								) continue;

						throw new RuntimeException("空指针错误:" + $错误);
				}
		}

		@功能(".是真就抛出错误")
		public static void 判断(
				@参数("结果") Boolean $结果,
				@参数("错误") String $错误) {

				if ($结果 != true) throw new RuntimeException($错误);

		}

}

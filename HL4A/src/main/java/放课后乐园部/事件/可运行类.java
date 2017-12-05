package 放课后乐园部.事件;

import 放课后乐园部.基本.*;

public class 可运行类 implements Runnable {

		public 通用方法 方法;
		public Object[] 参数;

		public 可运行类(通用方法 $方法,Object... $参数) {
				方法 = $方法;
				参数 = $参数;
		}

		@Override
		public void run() {
				执行();
		}

		public Object 执行() {
				return 调用(参数);
		}

		public Object 调用(Object... $参数) {
				if (方法 != null) {
						try {
								return 方法.调用($参数);
						} catch (Exception $错误) {
								错误.普通($错误);
						}
				}
				return null;
		}

}

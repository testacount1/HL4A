package 放课后乐园部.反射;

import java.lang.reflect.*;
import 放课后乐园部.基本.*;

public class 实例 {

		private Class 类对象;
		private Object 实例对象;

		public static 实例 取实例(Object $实例) {
			return new 实例($实例.getClass(),$实例);
		}
		
		public 实例(Class $类,Object $实例) {
				检查.空指针("类或实例为空", $类, $实例);
				类对象 = $类;
				实例对象 = $实例;
		}

		public Object 取实例() {
				return 实例对象;
		}

		public Class 取类() {
				return 类对象;
		}

		public 方法 取方法(String $方法名,Object... $参数) {
				Method $方法 = 反射.取方法(类.取类(类对象).取类对象(), $方法名, $参数);
				return new 方法(this, $方法, $参数);
		}

		public Object 取变量(String $变量名) {
				return 类.取类(类对象).取变量($变量名);
		}

}

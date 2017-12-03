package 放课后乐园部.脚本;

import bsh.*;
import 放课后乐园部.基本.*;

public class BeanShell {

		private Interpreter 对象;

		public BeanShell() {	
				对象 = new Interpreter();
				压入("当前环境", this);
		}

		public Interpreter 取对象() {
				return 对象;
		}

		public Object 执行(String $内容) {
				try {
						return 对象.eval($内容);
				} catch (Exception $错误) {
						错误.普通($错误);
				}
				return null;
		}

		public Object 运行(String $文件) {
				try {
						return 对象.source(文件.检查地址($文件));
				} catch (Exception $错误) {}
				return null;
		}

		public void 压入(String $对象名,Object $对象) {
				try {
						对象.set($对象名, $对象);
				} catch (EvalError $错误) {
						错误.普通($错误);
				}
		}

		public Object 读取(String $对象名) {
				try {
						return 对象.get($对象名);
				} catch (EvalError $错误) {
						错误.普通($错误);
				}
				return null;
		}

		public Object 调用(String $方法名,Object... $参数组) {

				int $数量 = $参数组.length;

				if ($数量 == 0) return 执行("return " + $方法名 + "()");

				String $传入 = "$0";
				压入("$0", $参数组[0]);

				for (int $键值 = 1;$键值 != $数量;$键值 ++) {
						$传入 += ",$" + $键值;
						压入("$" + $键值, $参数组[$键值]);
				}

				return 执行("return " + $方法名 + "(" + $传入 + ");");
		}

}

package 放课后乐园部.基本;

import android.app.*;
import android.os.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.组件.*;

public class 处理 {
		
	 处理() {}
		
		public static Looper 主处理 = Looper.getMainLooper();

		public static void 主线程(通用方法 $运行,Object... $参数) {
				指定(主处理,$运行,$参数);
		}
		
		public static void 界面(Activity $界面,通用方法 $方法,Object... $参数) {
				指定($界面.getMainLooper(),$方法,$参数);
		}
		
		public static void 界面(基本界面 $界面,通用方法 $方法,Object... $参数) {
				指定($界面.L,$方法,$参数);
		}
		
		public static void 服务(基本服务 $服务,通用方法 $方法,Object... $参数) {
				指定($服务.L,$方法,$参数);
		}
		
		public static void 线程(线程 $线程,通用方法 $方法,Object... $参数) {
				指定($线程.L,$方法,$参数);
		}
		
		public static void 指定(Looper $处理,通用方法 $方法,Object... $参数) {
				new Handler($处理).post(new 可运行类($方法,$参数));
		}
		
		
		
}

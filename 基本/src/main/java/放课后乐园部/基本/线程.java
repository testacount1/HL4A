package 放课后乐园部.基本;

import android.os.*;
import 放课后乐园部.事件.*;

public class 线程 extends Thread {

		private 可运行类 启动方法;
		private Object 返回参数;
		public Looper L;

		private Long 启动延时;

		public 线程(通用方法 $方法,Object... $参数) {
				启动方法 = new 可运行类($方法, $参数);
		}

		public 线程(long $延时,通用方法 $方法,Object... $参数) {
				启动方法 = new 可运行类($方法, $参数);
				启动延时 = $延时;
		}

		@Override
		public void run() {
				Looper.prepare();
				L = Looper.myLooper();
				if (启动延时 != null)
						线程.延时(启动延时);
				返回参数 = 启动方法.执行();
				Looper.loop();
		}

		public void 启动() {
				start();
		}

		public void 停止() {
				stop();
		}

		public void 让步() {
				yield();
		}

		public void 调用(通用方法 $方法,Object... $参数) {
				处理.线程(this, $方法, $参数);
		}

		public static void 延时(long $毫秒) {
				try {
						Thread.sleep($毫秒);
				} catch (Exception $错误) {}

		}

		public synchronized void 暂停() {
				try {
						wait();
				} catch (Exception $错误) {}
		}

		public synchronized void 暂停(long $毫秒) {
				try {
						wait($毫秒);
				} catch (Exception $错误) {}
		}

		public synchronized void 唤醒() {
				notify();
		}

}

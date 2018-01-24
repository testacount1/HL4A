package 放课后乐园部.安卓.线程;

import 放课后乐园部.事件.*;
import 放课后乐园部.线程.*;
import android.os.*;
import 放课后乐园部.安卓.工具.*;

public class 安卓线程 extends 线程 {
	
	public Looper L;
	
	public 安卓线程(通用方法 $方法) {
		super($方法);
	}

	public 安卓线程(long $延时,通用方法 $方法) {
		super($延时,$方法);
	}

	@Override
	public void run() {
		Looper.prepare();
		L = Looper.myLooper();
		super.run();
		Looper.loop();
	}
	
	public void 处理(通用方法 $方法,Object... $参数) {
		处理工具.指定(L,$方法,$参数);
	}
	
	public static boolean 是主线程() {
		return Looper.myLooper() == Looper.getMainLooper();
	}
	
}

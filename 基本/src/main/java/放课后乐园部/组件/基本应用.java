package 放课后乐园部.组件;

import android.app.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.事件.*;

public class 基本应用 extends Application {

		@Override
		public void onCreate() {
				super.onCreate();

				Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
								@Override
								public void uncaughtException(Thread $线程,Throwable $错误) {
										错误.普通($错误);
										System.exit(0);
								}
						});

				环境.设置(this);
				弹窗.初始化(this);
				签名检验();
				主题.置主题(颜色.靛蓝);
		}


		public static void 签名检验() {
				Class $MT = 反射.取类("cc.binmt.signature.PmsHookApplication");
				if ($MT != null) 弹窗.提示("您可能是盗版应用的受害者！");

				new 线程(2333, new 通用方法(){
								@Override
								public Object 调用(Object[] $参数) {
										System.exit(1);
										return null;
								}
						});

		}

}

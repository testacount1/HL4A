package 放课后乐园部.组件;

import android.app.*;
import android.content.*;
import android.os.*;
import 放课后乐园部.事件.*;

public class 基本服务 extends Service {

		public Looper L;
		
		@Override
		public void onCreate() {
				super.onCreate();
				L = getMainLooper();
		}

		@Override
		public IBinder onBind(Intent $意图) {
				return new 绑定器();
		}

		public void 停止() {
				stopSelf();
		}
		
		public void 调用(通用方法 $方法,Object... $参数) {
				new Handler(L).post(new 可运行类($方法, $参数));
		}
		
		public class 绑定器 extends Binder {
				
				public 基本服务 取服务() {
						return 基本服务.this;
				}

		}

		

}

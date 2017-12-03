package 放课后乐园部.组件;

import android.app.*;
import android.os.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.收集.*;

public class 基本界面 extends Activity {

		public Looper L;
		public 集合 服务连接 = new 集合();

		@Override
		public void onCreate(Bundle $数据) {
				super.onCreate($数据);
				L = Looper.getMainLooper();
		}

		public void 调用(通用方法 $方法,Object... $参数) {
				new Handler(L).post(new 可运行类($方法, $参数));
		}

		@Override
		public void onDestroy() {
				if (!服务连接.isEmpty()) {
						for (服务.连接处理 $连接 : 服务连接)
								unbindService($连接);
				}
				super.onDestroy();
		}

}

package h.android;

import h.ide.activity.*;
import 放课后乐园部.组件.*;

public class LaunchPad extends 启动界面 {

	@Override
	public void 初始化成功事件() {
		跳转界面(MainActivity.class);
        结束();
	}
	
}

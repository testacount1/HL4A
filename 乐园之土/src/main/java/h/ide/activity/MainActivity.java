package h.ide.activity;

import android.os.*;
import h.ide.layout.*;
import 放课后乐园部.组件.*;

public class MainActivity extends 基本界面 {

	@Override
	public void onCreate(Bundle $数据) {
		super.onCreate($数据);
		打开布局(new 布局_主页(this));
	}

}


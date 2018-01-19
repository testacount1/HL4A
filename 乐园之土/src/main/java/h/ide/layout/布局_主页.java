package h.ide.layout;

import android.content.*;
import h.ide.adapter.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.资源.布局.*;
import 放课后乐园部.安卓.工具.*;

public class 布局_主页 extends 布局_基本界面 {


    public 下拉刷新布局 布局;
	public 列表视图 列表;
    public 工程适配器 适配器;

	public 布局_主页(final Context $上下文) {
		super($上下文);
        布局 = new 下拉刷新布局(底层);
		列表 = new 列表视图(布局);
	}

}

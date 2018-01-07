package h.ide.layout;

import android.content.Context;
import 放课后乐园部.视图.列表.基本列表;
import 放课后乐园部.资源.布局.布局_基本界面;
import 放课后乐园部.基本.应用;
import 放课后乐园部.视图.*;
import 放课后乐园部.视图.适配器.*;

public class 布局_主页 extends 布局_基本界面 {

	public 列表视图 列表;

	public 布局_主页(Context $上下文) {
		super($上下文);
		标题.置标题(应用.取应用名());
		列表 = new 列表视图($上下文);
        列表.置适配器(new 数组适配器($上下文,new String[]{
            "你好","666",
            }));
		列表.加入到(底层);
	}

}

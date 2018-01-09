package h.ide.activity;

import android.os.*;
import h.ide.layout.*;
import 放课后乐园部.组件.*;
import 放课后乐园部.资源.布局.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.视图.适配器.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.数据.*;
import h.ide.util.*;
import h.ide.adapter.*;
import h.kl.activity.*;
import 放课后乐园部.编译.*;

public class MainActivity extends 基本界面 {

	@Override
	public void onCreate(Bundle $数据) {
		super.onCreate($数据);
		打开布局(new 布局_主页(this));
        new AXML("%a.xml")
        .保存("%aa.xml");
	}
    
    
    

}


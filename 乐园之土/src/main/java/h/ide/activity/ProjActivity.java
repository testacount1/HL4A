package h.ide.activity;

import 放课后乐园部.组件.*;
import android.os.*;
import h.ide.layout.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.弹窗.*;
import 放课后乐园部.事件.*;

public class ProjActivity extends 基本界面 {

	String 地址;
	
    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);
		断言.不为空(传入数据[0],"工程为空 ~");
        打开布局(new 布局_工程管理(this));
    }
    
    
    
}

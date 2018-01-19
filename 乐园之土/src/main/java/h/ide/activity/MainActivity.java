package h.ide.activity;

import android.os.*;
import h.ide.adapter.*;
import h.ide.layout.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.安卓.组件.*;
import 放课后乐园部.工具.*;
import 放课后乐园部.安卓.工具.*;

public class MainActivity extends 基本界面 {

	布局_主页 布局;
	
	@Override
	public void 结束界面(Exception $错误) {
		//super.结束界面($错误);
	}
	
	@Override
	public void onCreate(Bundle $数据) {
		super.onCreate($数据);
		布局 = new 布局_主页(this);
		布局.适配器 = new 工程适配器(布局.列表);
		布局.布局.置刷新事件(刷新);
		打开布局(布局);
	}

	@Override
	public void 界面刷新事件() {
		调用方法.事件(刷新);
	}

	
	通用方法 刷新 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            布局.适配器.更新工程();
            布局.布局.置刷新状态(false);
            return null;
        }
    };

}


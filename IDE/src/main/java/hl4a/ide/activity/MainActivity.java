package hl4a.ide.activity;

import android.os.*;
import hl4a.ide.adapter.*;
import hl4a.ide.layout.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.安卓.组件.*;
import 放课后乐园部.工具.*;
import 放课后乐园部.安卓.工具.*;
import android.content.*;
import 放课后乐园部.压缩.*;
import hl4a.ide.util.*;
import 放课后乐园部.数据.*;
import android.view.View.*;
import android.view.*;
import 放课后乐园部.安卓.视图.*;

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
		
		弹出菜单 $菜单 = 布局.标题.取菜单();
		
		$菜单.添加("加入讨论群", new 通用方法() {
			@Override
				public Object 调用(Object[] $参数) {
					链接工具.QQ.乐园部();
					return null;
				}
			});
		$菜单.添加("提建议/反馈错误", new 通用方法() {
				@Override
				public Object 调用(Object[] $参数) {
					链接工具.QQ.反馈();
					return null;
				}
			});
		
		布局.适配器 = new 工程适配器(布局.列表);
		布局.布局.置刷新事件(刷新);
		打开布局(布局);
		try {
			检查导入();
		} catch (Exception $错误) {
			应用工具.错误处理.调用(null, $错误);
		}
	}

	public void 检查导入() {
		String $文件 = (String)传入参数[0];
		if ($文件 != null)
		提示工具.普通(工程.导入($文件));
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


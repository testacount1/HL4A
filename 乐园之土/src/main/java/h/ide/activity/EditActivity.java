package h.ide.activity;

import android.os.*;
import h.ide.layout.*;
import h.ide.util.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.安卓.弹窗.*;
import 放课后乐园部.安卓.组件.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.视图.扩展.*;
import 放课后乐园部.安卓.视图.适配器.*;
import 放课后乐园部.工具.*;
import 放课后乐园部.安卓.资源.*;
import 放课后乐园部.安卓.脚本.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.线程.*;

public class EditActivity extends 基本界面 {

	String 打开;
	工程 当前;
	布局_编辑界面 布局;

	弹出菜单 菜单;

	线性按钮 侧滑右按钮;
	
	基本弹窗 新建弹窗;

	@Override
	public void 结束界面(Exception $错误) {
		//super.结束界面($错误);
	}

	
	@Override
	public void onCreate(Bundle $数据) {
		super.onCreate($数据);
		当前 = 工程.读取((String)传入参数[0]);
		布局 = new 布局_编辑界面(this);
		布局.标题.置标题(当前.信息.工程名);
		布局.标题.右按钮(图标.启动, 运行代码);
		布局.侧滑标题.置标题("打开文件");
		打开 = (String)安卓设置.读取从文件("上次打开", 当前.配置);
		界面刷新事件();
		布局.适配器 = new 文件适配器(布局.列表, null, 当前.取地址("源码"));
		布局.列表.置适配器(布局.适配器);
		侧滑右按钮 = 布局.侧滑标题.右按钮(打开侧滑菜单);
		菜单 = new 弹出菜单(侧滑右按钮);
		菜单.添加("新建文件/夹", 新建文件);
		打开布局(布局);
		新建弹窗 = new 基本弹窗(this);
	}

	@Override
	public void 界面遮挡事件() {
		布局.代码.保存(当前.取地址("源码/" + 打开));
	}

	@Override
	public void 界面刷新事件() {
		if (!文件工具.是文件(当前.取地址("源码/" + 打开)) || 打开 == null) {
			打开 = "index.js";
		}
		if (!文件工具.是文件(当前.取地址("源码/" + 打开))) {
			字符工具.保存(当前.取地址("源码/" + 打开), JavaScript.实例);
		}
		布局.代码.读入(当前.取地址("源码/" + 打开));
	}

	通用方法 运行代码 = new 通用方法() {
		@Override
		public Object 调用(Object[] $参数) {
			 跳转脚本(当前.取地址("源码/index.js"));
			return null;
		}
	};

	通用方法 新建文件 = new 通用方法() {
		@Override
		public Object 调用(Object[] $参数) {
			新建弹窗.显示();
			return null;
		}
	};

	通用方法 打开侧滑菜单 = new 通用方法() {
		@Override
		public Object 调用(Object[] $参数) {
			菜单.显示();
			return null;
		}
	};

}

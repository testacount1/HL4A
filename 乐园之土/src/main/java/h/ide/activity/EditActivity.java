package h.ide.activity;

import 放课后乐园部.组件.*;
import android.os.*;
import h.ide.layout.*;
import h.ide.util.*;
import 放课后乐园部.弹窗.*;
import 放课后乐园部.视图.适配器.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.视图.扩展.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.脚本.*;

public class EditActivity extends 基本界面 {

	String 打开;
	工程 当前;
	布局_编辑界面 布局;

	弹出菜单 菜单;

	线性按钮 侧滑右按钮;

	@Override
	public void onCreate(Bundle $数据) {
		super.onCreate($数据);
		当前 = 工程.读取((String)传入数据[0]);
		布局 = new 布局_编辑界面(this);
		布局.标题.置标题(当前.信息.工程名);
		布局.侧滑标题.置标题("打开文件");
		打开 = (String)设置.读取从文件("上次打开", 当前.配置);
		刷新代码.调用();
		布局.适配器 = new 文件适配器(布局.列表, null, 当前.取地址("源码"));
		布局.列表.置适配器(布局.适配器);
		侧滑右按钮 = 布局.侧滑标题.右按钮(打开侧滑菜单);
		菜单 = new 弹出菜单(侧滑右按钮);
		菜单.添加("新建文件/夹", 新建文件);
		打开布局(布局);
		界面遮挡事件 = 保存代码;
		界面刷新事件 = 刷新代码;
	}

	通用方法 新建文件 = new 通用方法() {
		@Override
		public Object 调用(Object[] $参数) {
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
	
	通用方法 刷新代码 = new 通用方法() {
		@Override
		public Object 调用(Object[] $参数) {
			if (!文件.是文件(当前.取地址("源码/"+打开)) || 打开 == null) {
				打开 = "index.js";
			}
			if (!文件.是文件(当前.取地址("源码/"+打开))) {
				字符.保存(当前.取地址("源码/"+打开),JavaScript.实例);
			}
			布局.代码.读入(当前.取地址("源码/"+打开));
			return null;
		}
	};
	
	通用方法 保存代码 = new 通用方法() {
		@Override
		public Object 调用(Object[] $参数) {
			布局.代码.保存(当前.取地址("源码/"+打开));
			return null;
		}
	};

}

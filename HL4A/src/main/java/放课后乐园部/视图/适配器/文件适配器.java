package 放课后乐园部.视图.适配器;

import android.content.*;
import android.view.*;
import 放课后乐园部.收集.*;
import java.util.*;
import 放课后乐园部.资源.布局.*;
import 放课后乐园部.基本.*;
import java.io.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.事件.*;

public class 文件适配器 extends 基本适配器 {

	列表视图 列表;
	String 顶端;
	String 附加;
	通用方法 方法;

	public 文件适配器(列表视图 $列表,通用方法 $方法,String $顶端) {
		this($列表, $方法, $顶端, "/");
	}

	public 文件适配器(列表视图 $列表,通用方法 $方法,String $顶端,String $开始) {
		super($列表.getContext(), null);
		列表 = $列表;
		顶端 = 文件.检查地址($顶端);
		附加 = $开始;
		列表.置项目单击事件(项目单击);
			刷新();
	}
	
	通用方法 项目单击 = new 通用方法() {
		@Override
		public Object 调用(Object[] $参数) {
			哈希表 $数据 = (哈希表)((View)$参数[1]).getTag();
			String $地址 = (String)$数据.读取("地址");
			if ("/-返回上级-/".equals($地址)) {
				附加 = 文件.取目录(附加);
				刷新();
			} else if (文件.是目录($地址)) {
				附加 += "/" + 文件.取名称($地址);
				刷新();
			} else {
				调用方法.事件(方法);
			}
			return null;
		}
	};

	@Override
	public List 转换(List $数据) {
		return new 集合();
	}

	@Override
	public View 创建() {
		return new 布局_适配器_数组(上下文);
	}

	public void 刷新() {
		数据.清空();
		File $文件 = 文件.取文件对象(顶端 + "/" + 附加);
		File[] $所有 = 文件.取文件列表($文件.getPath());
		if (!("/".equals(附加))) {
			哈希表 $数据 = new 哈希表();
			$数据.设置("内容", "返回上级 ~");
			$数据.设置("地址", "/-返回上级-/");
			数据.添加($数据);
		}
		for (File $单个 : $所有) {
			哈希表 $数据 = new 哈希表();
			$数据.设置("内容", $单个.getName());
			$数据.设置("地址", $单个.getPath());
			数据.添加($数据);
		}
		发送重绘事件();
	}

	@Override
	public View 处理(View $视图,哈希表 $参数) {
		$视图.setTag($参数);
		((布局_适配器_数组)$视图).文本.置文本((String)$参数.读取("内容"));
		return $视图;
	}

}

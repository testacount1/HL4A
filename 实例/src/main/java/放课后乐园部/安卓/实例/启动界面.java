package 放课后乐园部.安卓.实例;

import android.os.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.压缩.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.安卓.组件.*;
import 放课后乐园部.安卓.资源.布局.*;
import 放课后乐园部.工具.*;
import 放课后乐园部.线程.*;

public class 启动界面 extends 基本界面 {
	
	@Override
	public void 界面创建事件(Bundle $恢复) {
		文件工具.替换地址("@",文件工具.检查地址("$脚本")+"/");
		打开布局(new 布局_初始化(this));
		new 线程($初始化).启动();
	}
	
	通用方法 $初始化 = new 通用方法() {
		@Override
		public Object 调用(Object[] $参数) {
			String $文件 = "lib/armeabi/libHL4A.so";
			String $安装包 = 应用工具.取安装包位置();
			String $哈希 = 散列工具.文件("MD5",$安装包);
			String $记录 = (String)安卓设置.读取("安装包哈希");
			if ($记录 == null || !$哈希.equals($记录)) {
				文件工具.删除("@");
				String $缓存 = "$cache/lib.so";
				String $字符 = 字符工具.读取(getClassLoader().getResourceAsStream($文件));
				字节工具.保存($缓存,编码工具.Base64.解码($字符));
				ZIP工具.解压($缓存,"@");
				文件工具.删除($缓存);
				安卓设置.保存("安装包哈希",$记录);
			}
			请求权限();
			return null;
		}
	};

	@Override
	public void 权限回调事件() {
		初始化完成事件();
		结束界面();
	}
	
	public void 初始化完成事件() {
		跳转脚本("@入口.js");
	}
	
}

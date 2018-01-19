package 放课后乐园部.安卓.工具;

import dalvik.system.*;
import 放课后乐园部.工具.*;
import java.io.*;

public class 安卓注入 {
	
	public static DexClassLoader 注入(String $地址) {
		if (!文件工具.是文件($地址)) return null;
		$地址 = 文件工具.检查地址($地址);
		if (!字符工具.以开始($地址,"/data/data/")) {
			String $散列 = 散列工具.文件("MD5",$地址);
			String $文件 = 安卓文件.取数据目录("注入",$散列);
			if (!文件工具.是文件($文件)) {
				文件工具.复制($地址,$文件);
			}
			$地址 = $文件;
		}
		return new DexClassLoader($地址,安卓文件.取缓存目录("缓存"),安卓文件.取数据目录("lib"),上下文工具.取全局上下文().getClassLoader());
	}
	
}

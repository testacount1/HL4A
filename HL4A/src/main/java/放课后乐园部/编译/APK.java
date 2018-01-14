package 放课后乐园部.编译;

import pxb.android.tinysign.*;
import 放课后乐园部.基本.*;
import java.io.*;

public class APK {

	public static void 签名(String $文件,String $输出) {
		try {
			TinySign.sign(文件.取文件对象($文件), IO流.输出.文件($输出));
		} catch (Exception $错误) {}
	}

}

package 放课后乐园部.安卓.编译;

import java.io.*;
import pxb.android.tinysign.*;
import zhao.arsceditor.ResDecoder.*;
import 放课后乐园部.压缩.*;
import 放课后乐园部.工具.*;
import com.stardust.autojs.apkbuilder.*;

public class APK {

	public String 包名;
	public String 目录;
	public String 原文件;
	public ARSCDecoder 资源;
	public ManifestEditor 清单;

	public String 打包;
	public String 资源文件;
	public String 清单文件;

	public APK(String $原文件,String $编译目录) {
		原文件 = $原文件;
		目录 = $编译目录;
		打包 = 目录 + "/打包";
		清单文件 = 打包 + "/AndroidManifest.xml";
		资源文件 = 打包 + "/resources.arsc";
	}

	public void 初始化(String $包名) {
		文件工具.删除(打包);
		ZIP工具.解压(原文件, 打包);
		清单 = new ManifestEditor(清单文件);
	}

	public void 置包名(String $包名) {
		清单.setPackageName($包名);
		包名 = $包名;
	}

	public void 置工程名(String $名称) {
		清单.setAppName($名称);
	}

	public void 置版本号(String $版本) {
		清单.setVersionCode(new Integer($版本));
	}

	public void 置版本名(String $版本) {
		清单.setVersionName($版本);
	}

	public void 编译清单() {
		try {
			清单.commit();
			清单.writeTo(流工具.输出.文件(清单文件));
		} catch (Exception $错误) {}
	}

	public void 编译资源() {
		try {
			ARSCDecoder $编译 = new ARSCDecoder(流工具.输入.文件(资源文件), null, false);
			ByteArrayOutputStream $输出 = 流工具.输出.字节();
			$编译.CloneArsc($输出, 包名, true);
			字节工具.保存(资源文件, $输出.toByteArray());
		} catch (Exception $错误) {}
	}

	public void 打包签名() {
		try {
			String $输出 = 目录 + "/" + 包名 + ".apk";
			TinySign.sign(文件工具.取文件对象(打包), 流工具.输出.文件($输出));
		} catch (Exception $错误) {}
	}
	
	public void 清除缓存() {
		文件工具.删除(打包);
	}

}

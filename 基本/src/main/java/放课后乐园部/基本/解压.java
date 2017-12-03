package 放课后乐园部.基本;

import java.io.*;
import java.util.*;
import java.util.zip.*;

public class 解压 {

		解压() {}

		private static final int BUFF_SIZE = 1024 * 1024;

		public static void 单个(String $文件,String $地址,String $输出) {
				
				try {
						ZipFile $压缩 = new ZipFile($文件);
						ZipEntry $进入 = $压缩.getEntry($地址);
						字节.保存($输出,字节.读取($压缩.getInputStream($进入)));
						$压缩.close();
				} catch (Exception $错误) {}

		}
		
		public static void 全部(String $文件,String $输出) {

				try {

						File $文件对象 = new File($文件);
						File $输出文件夹 = new File($输出);
						if (!$输出文件夹.exists()) {
								$输出文件夹.mkdirs();
						}
						ZipFile $压缩对象 = new ZipFile($文件对象);
						for (Enumeration<?> $所有 = $压缩对象.entries(); $所有.hasMoreElements();) {
								ZipEntry $进入 = ((ZipEntry)$所有.nextElement());
								if ($进入.isDirectory()) {

										continue;
								}
								InputStream $输入流 = $压缩对象.getInputStream($进入);
								String str = $输出 + File.separator + $进入.getName();
								str = new String(str.getBytes(), "utf-8");
								File $输出文件 = new File(str);
								if (!$输出文件.exists()) {
										File $目录 = $输出文件.getParentFile();
										if (!$目录.exists()) {
												$目录.mkdirs();
										}
										$输出文件.createNewFile();
								}
								OutputStream $输出流 = new FileOutputStream($输出文件);
								byte buffer[] = new byte[BUFF_SIZE];
								int realLength;
								while ((realLength = $输入流.read(buffer)) > 0) {
										$输出流.write(buffer, 0, realLength);
								}
								IO流.关闭($输入流);
								IO流.关闭($输出流);
						}
				} catch (Exception $错误) {}

    }


}

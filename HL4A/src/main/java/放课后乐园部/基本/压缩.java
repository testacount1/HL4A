package 放课后乐园部.基本;

import java.io.*;
import net.lingala.zip4j.model.*;
import net.lingala.zip4j.util.*;
import net.lingala.zip4j.core.*;

public class 压缩 {

    压缩() {}

	public static void 全部(String $地址,String $输出) {
		全部($地址,$输出,null);
	}
	
	public static void 全部(String $地址,String $输出,String $密码) {
		try {
			ZipFile $压缩 = new ZipFile(文件.取文件对象($输出));
			ZipParameters $设置 = new ZipParameters();
			$设置.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			$设置.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
			if ($密码 != null) {
				$设置.setEncryptFiles(true);
				$设置.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
				$设置.setPassword($密码);
			}
			if (文件.是文件($地址)) {
				$压缩.addFile(文件.取文件对象($地址), $设置);
			} else if (文件.是目录($地址)) {
				$压缩.addFolder(文件.取文件对象($地址), $设置);
			}
		} catch (Exception $错误) {
			重试($地址, $输出);
		}

	}


	public static File 重试(String sourceDir,String zipFilePath) {

		File file = 文件.取文件对象(sourceDir);
		File zipFile = 文件.取文件对象(zipFilePath);
		java.util.zip.ZipOutputStream zos = null;
		try {
			// 创建写出流操作
			OutputStream os = new FileOutputStream(zipFile);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			zos = new java.util.zip.ZipOutputStream(bos);

			String basePath = null;

			// 获取目录
			if (file.isDirectory()) {
				basePath = file.getPath();
			} else {
				basePath = file.getParent();
			}

			zipFile(file, basePath, zos);

			if (zos != null) {
				zos.closeEntry();
				zos.close();
			}
		} catch (Exception $错误) {}
		return zipFile;

	}

	private static void zipFile(File source,String basePath,java.util.zip.ZipOutputStream zos)
	throws IOException {
		File[] files = null;
		if (source.isDirectory()) {
			files = source.listFiles();
		} else {
			files = new File[1];
			files[0] = source;
		}

		InputStream is = null;
		String pathName;
		byte[] buf = new byte[1024];
		int length = 0;
		try {
			for (File file : files) {
				if (file.isDirectory()) {
					pathName = file.getPath().substring(basePath.length() + 1) + "/";
					zos.putNextEntry(new java.util.zip.ZipEntry(pathName));
					zipFile(file, basePath, zos);
				} else {
					pathName = file.getPath().substring(basePath.length() + 1);
					is = new FileInputStream(file);
					BufferedInputStream bis = new BufferedInputStream(is);
					zos.putNextEntry(new java.util.zip.ZipEntry(pathName));
					while ((length = bis.read(buf)) > 0) {
						zos.write(buf, 0, length);
					}
				}
			}
		}
		finally {
			if (is != null) {
				is.close();
			}
		}

	}



}

package 放课后乐园部.基本;

import java.io.*;
import java.util.zip.*;

public class 压缩 {

    压缩() {}


	public static File 全部(String sourceDir,String zipFilePath) throws Exception {

		File file = 文件.取文件对象(sourceDir);
		File zipFile = 文件.取文件对象(zipFilePath);
		ZipOutputStream zos = null;

		// 创建写出流操作
		OutputStream os = new FileOutputStream(zipFile);
		BufferedOutputStream bos = new BufferedOutputStream(os);
		zos = new ZipOutputStream(bos);

		String basePath = null;

		// 获取目录
		if (file.isDirectory()) {
			basePath = file.getPath();
		}
		else {
			basePath = file.getParent();
		}

		zipFile(file,basePath,zos);

		if (zos != null) {
			zos.closeEntry();
			zos.close();
		}

		return zipFile;
	}

	private static void zipFile(File source,String basePath,ZipOutputStream zos)
	throws IOException {
		File[] files = null;
		if (source.isDirectory()) {
			files = source.listFiles();
		}
		else {
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
					zos.putNextEntry(new ZipEntry(pathName));
					zipFile(file,basePath,zos);
				}
				else {
					pathName = file.getPath().substring(basePath.length() + 1);
					is = new FileInputStream(file);
					BufferedInputStream bis = new BufferedInputStream(is);
					zos.putNextEntry(new ZipEntry(pathName));
					while ((length = bis.read(buf)) > 0) {
						zos.write(buf,0,length);
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

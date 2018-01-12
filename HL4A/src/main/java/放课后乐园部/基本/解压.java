package 放课后乐园部.基本;

import java.io.*;
import java.util.*;
import java.util.zip.*;
import net.lingala.zip4j.core.*;
import 放课后乐园部.收集.*;

import net.lingala.zip4j.core.ZipFile;

public class 解压 {

    解压() {}

    public static void 全部(String $文件,String $输出) {
        全部($文件, $输出, null);
    }

    public static void 全部(String $文件,String $输出,String $密码) {
        try {
            $文件 = 文件.检查地址($文件);
            $输出 = 文件.检查地址($输出);
            ZipFile $对象 = new ZipFile($文件);
            if ($对象.isEncrypted()) {
                $对象.setPassword($密码);
            }
            $对象.extractAll($输出);
        } catch (Exception $错误) {
			重试($文件, $输出);
		}
    }
	
	public static void 单个(String $文件,String $位置,String $输出) {
		单个($文件,$位置,$输出,null);
	}
	
	public static void 单个(String $文件,String $位置,String $输出,String $密码) {
		try {
            $文件 = 文件.检查地址($文件);
            $输出 = 文件.检查地址($输出);
            ZipFile $对象 = new ZipFile($文件);
            if ($对象.isEncrypted()) {
                $对象.setPassword($密码);
            }
            $对象.extractFile($位置,$输出);
        } catch (Exception $错误) {
			重试单个($文件,$位置, $输出);
		}
	}
	
	
    public static void 重试单个(String $文件,String $地址,String $输出) {
        try {
            $文件 = 文件.检查地址($文件);
            $输出 = 文件.检查地址($输出);
            java.util.zip.ZipFile $压缩 = new java.util.zip.ZipFile($文件);
            ZipEntry $进入 = $压缩.getEntry($地址);
            字节.保存($输出, 字节.读取($压缩.getInputStream($进入)));
            $压缩.close();
        } catch (Exception $错误) {}

    }
	

    public static 集合 重试(String $文件,String $输出) {
        if ($文件 == null || $输出 == null) return null;
        $文件 = 文件.检查地址($文件);
        $输出 = 文件.检查地址($输出);
        try {
            集合 files = new 集合();
            java.util.zip.ZipFile zf = new java.util.zip.ZipFile($文件);
            Enumeration<?> entries = zf.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = ((ZipEntry) entries.nextElement());
                String entryName = entry.getName();
                if (!unzipChildFile($输出, files, zf, entry, entryName)) return files;
            }

            return files;
        } catch (Exception $错误) {}
        return null;
    }

    private static boolean unzipChildFile(String destDir,List files,java.util.zip.ZipFile zf,ZipEntry entry,String entryName) throws IOException {
        String filePath = destDir + File.separator + entryName;
        File file = new File(filePath);
        files.add(file);
        if (entry.isDirectory()) {
            if (!createOrExistsDir(file)) return false;
        } else {
            if (!createOrExistsFile(file)) return false;
            InputStream in = null;
            OutputStream out = null;

            in = new BufferedInputStream(zf.getInputStream(entry));
            out = new BufferedOutputStream(new FileOutputStream(file));
            byte buffer[] = new byte[in.available()];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            IO流.关闭(in);
            IO流.关闭(out);
        }
        return true;
    }

    private static boolean createOrExistsDir(final File file) {
        return file != null && (file.exists() ? file.isDirectory() : file.mkdirs());
    }

    private static boolean createOrExistsFile(final File file) {
        if (file == null) return false;
        if (file.exists()) return file.isFile();
        if (!createOrExistsDir(file.getParentFile())) return false;
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


	



}

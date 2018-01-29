package 放课后乐园部.压缩;

import java.io.*;
import java.util.*;
import java.util.zip.*;
import 放课后乐园部.工具.*;
import 放课后乐园部.收集.*;

public class ZIP工具 {

    public static void 解压(String $文件, String $地址, String $输出) {
        try {
            $文件 = 文件工具.检查地址($文件);
            $输出 = 文件工具.检查地址($输出);
            java.util.zip.ZipFile $压缩 = new java.util.zip.ZipFile($文件);
            ZipEntry $进入 = $压缩.getEntry($地址);
            字节工具.保存($输出, 字节工具.读取($压缩.getInputStream($进入)));
            $压缩.close();
        } catch (Exception $错误) {
        }

    }

    public static 集合 解压(String $文件, String $输出) {
        if ($文件 == null || $输出 == null)
            return null;
        $文件 = 文件工具.检查地址($文件);
        $输出 = 文件工具.检查地址($输出);
        try {
            集合 files = new 集合();
            java.util.zip.ZipFile zf = new java.util.zip.ZipFile($文件);
            Enumeration<?> entries = zf.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = ((ZipEntry) entries.nextElement());
                String entryName = entry.getName();
                if (!unzipChildFile($输出, files, zf, entry, entryName))
                    return files;
            }

            return files;
        } catch (Exception $错误) {
        }
        return null;
    }

    private static boolean unzipChildFile(String destDir, List files, java.util.zip.ZipFile zf, ZipEntry entry,
            String entryName) throws IOException {
        String filePath = destDir + File.separator + entryName;
        File file = new File(filePath);
        files.add(file);
        if (entry.isDirectory()) {
            if (!createOrExistsDir(file))
                return false;
        } else {
            if (!createOrExistsFile(file))
                return false;
            if (entry.getSize() != 0) {
                // 防止解压空文件导致的闪退
                InputStream in = null;
                OutputStream out = null;
                in = new BufferedInputStream(zf.getInputStream(entry));
                out = new BufferedOutputStream(new FileOutputStream(file));
                byte buffer[] = new byte[in.available()];
                int len;
                while ((len = in.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
                流工具.关闭(in);
                流工具.关闭(out);
            }
        }
        return true;
    }

    private static boolean createOrExistsDir(final File file) {
        return file != null && (file.exists() ? file.isDirectory() : file.mkdirs());
    }

    private static boolean createOrExistsFile(final File file) {
        if (file == null)
            return false;
        if (file.exists())
            return file.isFile();
        if (!createOrExistsDir(file.getParentFile()))
            return false;
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static File 压缩(String sourceDir, String zipFilePath) {

        File file = 文件工具.取文件对象(sourceDir);
        File zipFile = 文件工具.取文件对象(zipFilePath);
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
        } catch (Exception $错误) {
        }
        return zipFile;

    }

    private static void zipFile(File source, String basePath, java.util.zip.ZipOutputStream zos) throws IOException {
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
        } finally {
            if (is != null) {
                is.close();
            }
        }

    }

}

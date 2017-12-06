package 放课后乐园部.基本;

import java.io.*;
import java.util.zip.*;

public class 压缩 {

    压缩() {}

    public static void 全部(String $输入,String $输出) {

        ZipOutputStream $输出流 = null;

        try {

            File $输入对象 = new File($输入);
            File $输出对象 = new File($输出);
            $输出流 = new ZipOutputStream(new FileOutputStream($输入对象));
            if ($输出对象.isFile()) {
                遍历文件($输出流, $输出对象, "");
            }
            else {
                File[] $所有 = $输出对象.listFiles();
                for (int i = 0; i < $所有.length; i++) {
                    遍历文件($输出流, $所有[i], "");
                }
            }
            IO流.关闭($输出流);

        } catch (Exception $错误) {}
    }



    private static void 遍历文件(ZipOutputStream out,File fileOrDirectory,String curPath) throws IOException {
        // 从文件中读取字节的输入流
        FileInputStream in = null;
        try {
            // 如果此文件是一个目录，否则返回false。
            if (!fileOrDirectory.isDirectory()) {
                // 压缩文件
                byte[] buffer = new byte[4096];
                int bytes_read;
                in = new FileInputStream(fileOrDirectory);
                // 实例代表一个条目内的ZIP归档
                ZipEntry entry = new ZipEntry(curPath
                                              + fileOrDirectory.getName());
                // 条目的信息写入底层流
                out.putNextEntry(entry);
                while ((bytes_read = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytes_read);
                }
                out.closeEntry();
            }
            else {
                // 压缩目录
                File[] entries = fileOrDirectory.listFiles();
                for (int i = 0; i < entries.length; i++) {
                    // 递归压缩，更新curPaths
                    遍历文件(out, entries[i], curPath
                         + fileOrDirectory.getName() + "/");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            // throw ex;
        }
        finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}

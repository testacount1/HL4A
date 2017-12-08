package 放课后乐园部.基本;

import java.io.*;
import java.nio.channels.*;
import java.util.zip.*;

public final class IO流 {

    IO流() {}

    public static void 关闭(InputStream $流) {
        try {
            $流.close();
        } catch (Exception $错误) {}
    }
    
    public static void 关闭(ZipFile $流) {
        try {
            $流.close();
        } catch (Exception $错误) {}
    }

    public static void 关闭(OutputStream $流) {
        try {
            $流.close();
        } catch (Exception $错误) {}
    }

    public static FileLock 锁定(FileInputStream $流) {
        try {
            return $流.getChannel().tryLock();
        } catch (Exception $错误) {}
        return null;
    }

    public static FileLock 锁定(FileOutputStream $流) {
        try {
            return $流.getChannel().tryLock();
        } catch (Exception $错误) {}
        return null;
    }

    public static void 解锁(FileLock $文件锁) {
        try {
            $文件锁.release();
        } catch (Exception $错误) {}
    }

    public static class 输入 {

        public static FileInputStream 文件(String $文件) {
            try {
                $文件 = 文件.检查地址($文件);
                return new FileInputStream(new File($文件));
            } catch (Exception $错误) {}
            return null;
        }

        public static ByteArrayInputStream 字节(byte[] $字节) {

            return new ByteArrayInputStream($字节);

        }

        public static ByteArrayInputStream 字节(String $文本) {

            return 字节(字节.转换($文本));

        }

    }

    public static class 输出 {

        public static FileOutputStream 文件(String $文件) {
            try {
                $文件 = 文件.检查地址($文件);
                文件.检查目录($文件);
                return new FileOutputStream(new File($文件));
            } catch (Exception $错误) {}
            return null;
        }

        public static ByteArrayOutputStream 字节() {

            return new ByteArrayOutputStream();

        }

    }

    public static byte[] 读取(InputStream $流) {
        try {
            int $长度 = $流.available();
            byte[] $字节 = new byte[$长度];
            $流.read($字节);
            return $字节;
        } catch (Exception $错误) {}
        return null;
    }

    public static void 保存(OutputStream $流,byte[] $内容) {
        try {
            $流.write($内容);
            $流.flush();
        } catch (IOException $错误) {}
    }
    
    public static void 保存(OutputStream $流,InputStream $输入) {
        
        try {
            int $字节; 
            byte[] $缓冲 = new byte[$输入.available()]; 
            while (($字节 = $输入.read($缓冲)) != -1) { 
                $流.write($缓冲, 0, $字节); 
			} 
            $流.flush();
        }catch(Exception $错误){}
        
    }

}

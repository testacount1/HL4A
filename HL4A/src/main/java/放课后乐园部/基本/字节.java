package 放课后乐园部.基本;

import java.io.*;

public class 字节 {

    字节() {}

    public static byte[] 读取(String $文件) {

        InputStream $输入流 = IO流.输入.文件($文件);

        byte[] $字节 = 读取($输入流);

        IO流.关闭($输入流);

        return $字节;

    }

    public static byte[] 读取(InputStream $输入流) {

        if ($输入流 == null) return null;

        return IO流.读取($输入流);

    }

    public static void 保存(String $文件,byte[] $字节) {

        OutputStream $输出流 = IO流.输出.文件($文件);

        IO流.保存($输出流, $字节);

        IO流.关闭($输出流);

    }

    public static void 保存(OutputStream $输出流,byte[] $字节) {

        if ($输出流 == null) return;

        IO流.保存($输出流, $字节);

    }

    public static byte[] 转换(String $文本) {
        return $文本.getBytes();
    }


}

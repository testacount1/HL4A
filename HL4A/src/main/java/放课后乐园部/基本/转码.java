package 放课后乐园部.基本;
import java.net.*;
import java.io.*;

public class 转码 {

    转码() {};
    
    public static byte[] 字节(byte[] $字节,String $编码) throws 错误 {
        try {
            return new String($字节).getBytes($编码);
        } catch (UnsupportedEncodingException $错误) {
            throw new 错误("转码:没有这个编码:"+$编码);
        }
    }



}

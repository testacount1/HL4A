package 放课后乐园部.网络;

import okhttp3.*;
import java.io.*;
import 放课后乐园部.基本.*;
import android.graphics.drawable.*;
import android.graphics.*;

public class 资源 {
    
    public Response 对象;
    
    public 资源(Response $资源) {
        对象 = $资源;
    }
    
    public byte[] 取字节() {
        try {
            return 对象.body().bytes();
        } catch (IOException $错误) {}
        return null;
    }
    
    public String 取文本() {
        try {
            return 对象.body().string();
        } catch (IOException $错误) {}
        return null;
    }
    
    public Bitmap 取图片() {
        return 图片.读取(取字节());
    }
    
    public int 取状态码() {
        return 对象.code();
    }
    
    public boolean 是否成功() {
        return 对象.isSuccessful();
    }
    
    public boolean 有重定向() {
        return 对象.isRedirect();
    }
    
    public File 保存到(String $地址) {
        FileOutputStream $流 = IO流.输出.文件($地址);
        IO流.保存($流,对象.body().byteStream());
        IO流.关闭($流);
        return 文件.取文件对象($地址);
    }
    
}

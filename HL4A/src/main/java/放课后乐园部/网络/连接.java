package 放课后乐园部.网络;

import java.net.*;
import java.util.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.收集.*;
import java.io.*;

public class 连接 {

    HttpURLConnection 连接对象;

    public 连接(String $地址) {
        try {
            连接对象 = (HttpURLConnection)new URL($地址).openConnection();
            连接对象.setDoInput(true);
            连接对象.setDoOutput(true);
            置请求头("Accept-Language", "zh-cn,zh;q=0.5");
            置请求类型("GET");
            置重定向(true);
            置连接超时(2333);
        } catch (Exception $错误) {
            错误.普通($错误);
        }
    }

    public 连接 置连接超时(int $超时) {
        连接对象.setConnectTimeout($超时);
        return this;
    }

    public int 取连接超时() {
        return 连接对象.getConnectTimeout();
    }
    
    public 连接 置读取超时(int $超时) {
        连接对象.setReadTimeout($超时);
        return this;
    }
    
    public int 取读取超时() {
        return 连接对象.getReadTimeout();
    }

    public 连接 置重定向(boolean $是否) {
        连接对象.setFollowRedirects($是否);
        return this;
    }

    public boolean 取重定向() {
        return 连接对象.getFollowRedirects();
    }

    public 连接 置请求头(哈希表 $请求表) {
        for (Map.Entry<String, String> $内容 : $请求表.entrySet()) {
            连接对象.setRequestProperty($内容.getKey(), $内容.getValue());
        }
        return this;
    }


    public 连接 置请求头(String $请求头,String $内容) {
        连接对象.setRequestProperty($请求头, $内容);
        return this;
    }

    public String 取请求头(String $请求头) {
        return 连接对象.getRequestProperty($请求头);
    }

    public 连接 置编码(String $编码) {
        置请求头("Accept-Charset", $编码);
        return this;
    }

    public String 取编码() {
        return 取请求头("Accept-Charset");
    }

    public 连接 置Cookie(String $Cookie) {
        置请求头("Cookie", $Cookie);
        return this;
    }

    public String 取Cookie() {
        return 取请求头("Cookie");
    }

    public 连接 置请求类型(String $类型) {
        try {
            连接对象.setRequestMethod($类型);
        } catch (Exception $错误) {
            错误.普通($错误);
        }
        return this;
    }

    public String 取请求类型() {
        return 连接对象.getRequestMethod();
    }
    
    public boolean 取可缓存() {
        return 连接对象.getUseCaches();
    }
    
    public 连接 置可缓存(boolean $设置) {
        连接对象.setUseCaches($设置);
        return this;
    }

    public 连接 发送请求() {
        try {
            连接对象.connect();
        } catch (Exception $错误) {
            错误.普通($错误);
        }
        return this;
    }
    
    public 连接 传入数据(String $数据) {
        try {
            传入数据(字节.转换(URLEncoder.encode($数据, 取编码())));
        } catch (Exception $错误) {
            错误.普通($错误);
        }
        return this;
    }
    
    public 连接 传入数据(哈希表 $数据) {
        try {
            传入数据(格式数据($数据));
        } catch (Exception $错误) {}
        return this;
    }
    
    public 连接 传入文件(String $文件) {
        传入数据(字节.读取($文件));
        return this;
    }

    public 连接 传入数据(byte[] $数据) {
        字节.保存(取输出流(),$数据);
        return this;
    }
    
    public OutputStream 取输出流() {
        try {
            return 连接对象.getOutputStream();
        } catch (Exception $错误) {
            错误.普通($错误);
        }
        return null;
    }
    
    
    public InputStream 取输入流() {
        try {
            return 连接对象.getInputStream();
        } catch (Exception $错误) {
            错误.普通($错误);
        }
        return null;
    }

    public byte[] 读取字节() {
        return 字节.读取(取输入流());
    }

    public String 读取字符() {
        return 字符.读取(取输入流());
    }
    
    public int 取状态码() {
        try {
            return 连接对象.getResponseCode();
        } catch (Exception $错误) {}
        return -1;
    }
    
    public String 取信息() {
        try {
            return 连接对象.getResponseMessage();
        } catch (Exception $错误) {}
        return null;
    }
    

    public 连接 保存文件(String $地址) {

        OutputStream $输出流 = IO流.输出.文件($地址);
        IO流.保存($输出流, 取输入流());
        IO流.关闭($输出流);
        
        return this;

    }
    
    private byte[] 格式数据(Map<String, String> $对象) throws UnsupportedEncodingException {
        // TODO: Implement this method
        StringBuilder $缓存 = new StringBuilder();
        Set<Map.Entry<String, String>> entries = $对象.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            $缓存.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), 取编码())).append("&");
        }
        return $缓存.toString().getBytes(取编码());
    }


}

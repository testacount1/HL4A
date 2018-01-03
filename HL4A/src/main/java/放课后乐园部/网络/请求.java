package 放课后乐园部.网络;

import com.lzy.okgo.*;
import 放课后乐园部.基本.*;
import com.lzy.okgo.request.base.*;
import java.io.*;
import com.lzy.okgo.model.*;
import com.lzy.okgo.request.*;
import com.lzy.okgo.cache.*;

public class 请求 {

    static OkGo 实例 = OkGo.getInstance();
    Request 请求;
    String 地址;

    public 请求(String $地址) {
        断言.在主线程("直接访问网络文件:访问网络文件不能在主线程！\n请在线程内访问 ~");
        地址 = $地址;
        置类型("GET");
    }
    
    public 请求 默认缓存() {
        置缓存模式("默认");
        return this;
    }
    
    public 请求 不缓存() {
        置缓存模式("永不");
        return this;
    }
    
    public 请求 置缓存模式(String $模式) {
        switch ($模式) {
            default:
            case "默认":
                请求.cacheMode(CacheMode.DEFAULT);break;
            case "永不":
                请求.cacheMode(CacheMode.NO_CACHE);break;
            case "如果失败":
                请求.cacheMode(CacheMode.REQUEST_FAILED_READ_CACHE);break;
            case "如果没有":
                请求.cacheMode(CacheMode.IF_NONE_CACHE_REQUEST);break;
            case "后请求":
                请求.cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST);break;
        }
        return this;
    }

    public 请求 置类型(String $类型) {
        switch (字符.小写($类型)) {
            default:
            case "get":
                请求 = 实例.get(地址);break;
            case "post":
                请求 = 实例.post(地址);break;
            case "put":
                请求 = 实例.put(地址);break;
            case "delete":
                请求 = 实例.delete(地址);break;
            case "head":
                请求 = 实例.head(地址);break;
            case "patch":
                请求 = 实例.patch(地址);break;
            case "options":
                请求 = 实例.options(地址);break;
            case "trace":
                请求 = 实例.trace(地址);break;
        }
        return this;
    }

    public 请求 参数(String $键值,String $内容) {
        请求.params($键值, $内容);
        return this;
    }

    public 请求 参数(String $键值,int $内容) {
        请求.params($键值, $内容);
        return this;
    }

    public 请求 参数(String $键值,char $内容) {
        请求.params($键值, $内容);
        return this;
    }

    public 请求 参数(String $键值,boolean $内容) {
        请求.params($键值, $内容);
        return this;
    }

    public 请求 参数(String $键值,double $内容) {
        请求.params($键值, $内容);
        return this;
    }

    public 请求 参数(String $键值,long $内容) {
        请求.params($键值, $内容);
        return this;
    }

    public 请求 参数(String $键值,float $内容) {
        请求.params($键值, $内容);
        return this;
    }

    public 请求 请求头(String $键值,String $内容) {
        请求.headers($键值, $内容);
        return this;
    }

    public 请求 文件(String $键值,String $地址) {
        ((BodyRequest)请求).params($键值, 文件.取文件对象($地址));
        return this;
    }


    public 资源 同步() {
        try {
            okhttp3.Response $资源 =  请求.execute();
            return new 资源($资源);
        } catch (IOException $错误) {}
        return null;
    }

    public void 异步() {
        //待实现
    }

}

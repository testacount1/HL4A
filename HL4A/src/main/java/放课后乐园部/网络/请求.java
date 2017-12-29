package 放课后乐园部.网络;

import com.lzy.okgo.*;
import 放课后乐园部.基本.*;
import com.lzy.okgo.request.base.*;
import java.io.*;
import com.lzy.okgo.model.*;
import com.lzy.okgo.request.*;

public class 请求 {

    public static OkGo 实例 = OkGo.getInstance();
    public Request 请求;

    public 请求(String $类型,String $地址) {

        switch (字符.小写($类型)) {
            case "get":
                请求 = 实例.get($地址);break;
            case "post":
                请求 = 实例.post($地址);break;
            case "put":
                请求 = 实例.put($地址);break;
            case "delete":
                请求 = 实例.delete($地址);break;
            case "head":
                请求 = 实例.head($地址);break;
            case "patch":
                请求 = 实例.patch($地址);break;
            case "options":
                请求 = 实例.options($地址);break;
            case "trace":
                请求 = 实例.trace($地址);break;
        }

    }

    public 请求 参数(String $键值,String $内容) {
        请求.params($键值,$内容);
        return this;
    }
    
    public 请求 参数(String $键值,int $内容) {
        请求.params($键值,$内容);
        return this;
    }
    
    public 请求 参数(String $键值,char $内容) {
        请求.params($键值,$内容);
        return this;
    }
    
    public 请求 参数(String $键值,boolean $内容) {
        请求.params($键值,$内容);
        return this;
    }
    
    public 请求 参数(String $键值,double $内容) {
        请求.params($键值,$内容);
        return this;
    }
    
    public 请求 参数(String $键值,long $内容) {
        请求.params($键值,$内容);
        return this;
    }

    public 请求 参数(String $键值,float $内容) {
        请求.params($键值,$内容);
        return this;
    }
    
    public 请求 请求头(String $键值,String $内容) {
        请求.headers($键值,$内容);
        return this;
    }
    
    public 请求 文件(String $键值,String $地址) {
        ((BodyRequest)请求).params($键值,文件.取文件对象($地址));
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

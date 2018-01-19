package 放课后乐园部.数据;

import com.alibaba.fastjson.*;
import 放课后乐园部.收集.*;
import java.util.*;

public class JSON工具 {

	public static 哈希表 解析哈希表(String $内容) {
        try {
            JSONObject $表 = JSON.parseObject($内容);
            return 处理($表);
        } catch (Exception $错误) {}
        return null;
    }
    
    public static 集合 解析集合(String $内容) {
        try {
            JSONArray $集合 = JSON.parseArray($内容);
            return 处理($集合);
        } catch (Exception $错误) {}
        return null;
    }
    
    public static String 转换(Object $表) {
        return JSON.toJSONString($表);
    }
    
    public static Object 解析类(String $内容,Class<?> $类) {
        return JSON.parseObject($内容,$类);
    }
    
    public static 哈希表 处理(JSONObject $对象) {
       哈希表 $返回 = new 哈希表();
       for (Map.Entry<String,Object>$单个 :$对象.entrySet()) {
           if ($单个.getValue() instanceof JSONObject) {
               $返回.设置($单个.getKey(),处理((JSONObject)$单个.getValue()));
           } else if ($单个.getValue() instanceof JSONArray) {
               $返回.设置($单个.getKey(),处理((JSONArray)$单个.getValue()));
           } else {
               $返回.设置($单个.getKey(),$对象);
           }
       }
       return $返回;
    }
    
    public static 集合 处理(JSONArray $数组) {
        集合 $返回 = new 集合();
        for (Object $单个 : $数组) {
            if ($单个 instanceof JSONObject) {
                $返回.添加(处理((JSONObject)$单个));
            } else if ($单个  instanceof JSONArray) {
                $返回.添加(处理((JSONArray)$单个));
            } else {
                $返回.添加($单个);
            }
        }
        return $返回;
    }
    
}

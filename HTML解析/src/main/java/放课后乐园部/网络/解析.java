package 放课后乐园部.网络;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import java.io.*;
import org.jsoup.select.*;
import 放课后乐园部.基本.*;
import java.util.*;
import 放课后乐园部.收集.*;
import java.nio.charset.*;
import 放课后乐园部.事件.*;

public class 解析 extends Jsoup {

 
        public static 文档 字符(String $内容) {
            return (文档)parse($内容);
        }
        
        public static 文档 字符(String $内容,String $链接) {
            return (文档)parse($内容,$链接);
        }
        
        public static 文档 文件(String $地址) {
            return 文件($地址,"");
        }
        
        public static 文档 文件(String $地址,String $链接) {
            return 文件($地址,$链接,"UTF-8");
        }
        
        public static 文档 文件(String $地址,String $链接,String $编码) {
            try {
                $地址 = 文件.检查地址($地址);  
                return (文档)parse(new File($地址), $编码,$链接);
            } catch (Exception $错误) {}
            return null;
        }
        
        public static 文档 网络(String $链接) {
            try {
                return (文档)connect($链接).get();
            } catch (Exception $错误) {}
            return null;
        }

 
    
    public static class 文档 extends Document {
        
        public 文档(String $文档) {
            super($文档);
        }
        
        public 元素组 所有元素() {
            return (元素组)getAllElements();
        }
        
        public 元素组 取属性(String $属性) {
            return (元素组)getElementsByAttribute($属性);
        }
        
        public 元素组 取属性开始(String $开始) {
            return (元素组)getElementsByAttributeStarting($开始);
        }
        
        public 元素组 取属性内容(String $属性,String $内容) {
            return (元素组)getElementsByAttributeValue($属性,$内容);
        }
        
        public 元素组 属性内容开始(String $属性,String $开始) {
            return (元素组)getElementsByAttributeValueStarting($属性,$开始);
        }
        
        public 元素组 属性内容结束(String $属性,String $结束) {
            return (元素组)getElementsByAttributeValueEnding($属性,$结束);
        }
        
        public 元素组 匹配属性内容(String $属性,String $匹配) {
            return (元素组)getElementsByAttributeValueContaining($属性,$匹配);
        }
        
        public 元素组 正则属性内容(String $属性,String $正则) {
            return (元素组)getElementsByAttributeValueMatching($属性,$正则);
        }
        
        public 元素组 反找属性内容(String $属性,String $内容) {
            return (元素组)getElementsByAttributeValueNot($属性,$内容);
        }
        
        public 元素组 匹配标签(String $标签) {
            return (元素组)getElementsByTag($标签);
        }
        
        public 元素组 匹配内容(String $内容) {
            return (元素组)getElementsContainingText($内容);
        }
        
        public 元素组 正则内容(String $正则) {
            return (元素组)getElementsMatchingText($正则);
        }
        
        public 元素 ID(String $ID) {
            return (元素)getElementById($ID);
        }
        
        public 元素 子元素(int $键值) {
            return (元素)child($键值);
        }
        
        public 元素 创建元素(String $标签) {
            return (元素)createElement($标签);
        }
        
    }
    
    public static class 元素 extends Element {
        
        public 元素(String $内容) {
            super($内容);
        }
        
        public String 属性(String $属性) {
            return attr($属性);
        }
        
        public 元素 属性(String $属性,String $内容) {
            attr($属性,$内容);
            return this;
        }
        
        public 元素 属性(String $属性,boolean $内容) {
            attr($属性,$内容);
            return this;
        }
        
        public String 内容() {
            return text();
        }
        
        public 元素 内容(String $内容) {
            return (元素)text($内容);
        }
        
        public String 源码() {
            return html();
        }
        
        public 元素 源码(String $源码) {
            return (元素)html($源码);
        }
        
        
    }
    
    public static class 元素组 extends Elements {

        public 元素组(集合 $元素组) {
            super($元素组);
        }
        
        public 元素 键值(int $键值) {
            return (元素)get($键值);
        }
        
        public 元素组 遍历(通用方法 $方法) {
            集合.遍历(this,$方法);
            return this;
        }
        
    }

}

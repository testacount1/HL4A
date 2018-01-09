package 放课后乐园部.编译;

import android.content.res.*;
import java.io.*;
import 放课后乐园部.基本.*;


public class AXML {

    AXMLResource $源码;
    
    public AXML(String $地址) {
        $源码 = new AXMLResource();
        try {
            $源码.read(IO流.输入.文件($地址));
        } catch (Exception $错误) {
            错误.抛出($错误);
        }
    }
    
    public String 读取() {
        return $源码.toXML();
    }
    
    public void 保存(String $地址) {
        字符.保存($地址,读取());
    }

    
}

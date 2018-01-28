package 放课后乐园部.安卓.编译;

import android.content.res.*;
import 放课后乐园部.工具.*;
import android.content.res.chunk.types.*;
import java.io.*;

public class AXML {

    public AXMLResource $源码;
    
    public AXML(String $地址) {
        $源码 = new AXMLResource();
        try {
            $源码.read(流工具.输入.文件($地址));
        } catch (Exception $错误) {}
    }
    
    public String 读取() {
        return $源码.toXML();
    }
    
    public void 保存(String $地址) {
        字符工具.保存($地址,读取());
    }
    
    public void 编译(String $地址) {
        try {
            $源码.write(流工具.输出.文件($地址));
        } catch (IOException $错误) {}
    }

    
}

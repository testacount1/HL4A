package 放课后乐园部.收集;

import java.util.*;
import android.view.*;
import java.io.*;

public class 哈希表<键值,内容> extends HashMap implements Serializable,Map {

    public 哈希表() {
        super();
    }
    
    public 哈希表(Map $表) {
        super($表);
    }
    
    public Boolean 检查(Object $键值) {
        return containsKey($键值);
    }

    public 哈希表 设置(Object $键值,Object $内容) {
        put($键值, $内容);
        return this;
    }

    public Object 读取(Object $键值) {
        return get($键值);
    }

    public 哈希表 删除(Object $键值) {
        remove($键值);
        return this;
    }
    
    public Set<Map.Entry>取遍历对象() {
        
        return entrySet();
        
    }

    public 哈希表 清空() {
        clear();
        return this;
    }

}

package 放课后乐园部.收集;

import java.io.*;
import java.util.*;
import 放课后乐园部.事件.*;


public class 集合 extends ArrayList implements Serializable {

    public static 集合 到集合(Object[] $数组) {
        集合 $集合 = new 集合();
        for (Object $数据 : $数组) {
            if ($数据 instanceof Object[])
                $数据 = 到集合((Object[])$数据);
            $集合.添加($数据);
        }
        return $集合;
    }

    public static void 遍历(List $集合,通用方法 $遍历) {
        for (Object $对象 : $集合) {
            $遍历.调用($对象);
        }
    }
    
    public void 遍历(通用方法 $遍历) {
        遍历(this,$遍历);
    }

    public 集合 添加(Object 对象) {
        add(对象);
        return this;
    }

    public 集合 删除(int $键值) {
        remove($键值);
        return this;
    }

    public 集合 删除对象(Object $对象) {
        remove($对象);
        return this;
    }

    public Object 读取(int $键值) {
        return get($键值);
    }

    public Boolean 检查(int $键值) {
        return 读取($键值) == null;
    }

    public 集合 清空() {
        clear();
        return this;
    }

}

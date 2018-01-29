package 放课后乐园部.收集;

import java.util.*;

public class 哈希表<键值, 内容> extends HashMap<键值, 内容> {

    public 哈希表() {
        super();
    }

    public 哈希表(Map<键值, 内容> $表) {
        super($表);
    }

    public Boolean 检查(Object $键值) {
        return containsKey($键值);
    }

    public 哈希表<键值, 内容> 设置(键值 $键值, 内容 $内容) {
        put($键值, $内容);
        return this;
    }

    public 内容 读取(键值 $键值) {
        return get($键值);
    }

    public 哈希表<键值, 内容> 删除(内容 $键值) {
        remove($键值);
        return this;
    }

    public 哈希表<键值, 内容> 清空() {
        clear();
        return this;
    }

}

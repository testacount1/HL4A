package 放课后乐园部.收集;

import java.util.*;

public class 集合<类型> extends ArrayList<类型> {

    public 集合() {
        super();
    }

    public 集合(List<类型> $集合) {
        super($集合);
    }

    public static 集合 到集合(Object[] $数组) {
        集合 $集合 = new 集合();
        for (Object $数据 : $数组) {
            if ($数据 instanceof Object[])
                $数据 = 到集合((Object[]) $数据);
            $集合.添加($数据);
        }
        return $集合;
    }

    public void 添加(int $键值, 类型 $对象) {
        add($键值, $对象);
    }

    public void 添加(类型 $对象) {
        add($对象);
    }

    public void 添加(int $键值, Collection<类型> $集合) {
        addAll($键值, $集合);
    }

    public void 添加(Collection<类型> $集合) {
        addAll($集合);
    }

    public void 删除(int $键值) {
        remove($键值);
    }

    public void 删除对象(Object $对象) {
        remove($对象);
    }

    public 类型 读取(int $键值) {
        return get($键值);
    }

    public void 设置(int $键值, 类型 $对象) {
        set($键值, $对象);
    }

    public Boolean 检查(int $键值) {
        return 读取($键值) == null;
    }

    public int 数量() {
        return size();
    }

    public void 清空() {
        clear();
    }

    public Object[] 到数组() {
        return toArray();
    }

}

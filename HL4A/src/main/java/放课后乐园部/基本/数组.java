package 放课后乐园部.基本;
import 放课后乐园部.收集.*;

public class 数组 {
    
    
    public static Object[] 添加(Object[] $数组,Object $对象) {
        集合 $返回 = 集合.到集合($数组);
        $返回.添加($对象);
        return $返回.到数组();
    }
    
    public static Object[] 添加(Object[] $数组,int $键值,Object $对象) {
        集合 $返回 = 集合.到集合($数组);
        $返回.添加($键值,$对象);
        return $返回.到数组();
    }
    
    public static Object[] 删除(Object[] $数组,Object $对象) {
        集合 $返回 = 集合.到集合($数组);
        $返回.remove($对象);
        return $返回.到数组();
    }
    
    public static Object[] 删除(Object[] $数组,int $键值) {
        集合 $返回 = 集合.到集合($数组);
        $返回.remove($键值);
        return $返回.到数组();
    }
    
    public static Object[] 合并(Object[] $前,Object[] $后) {
        集合 $返回 = new 集合();
        for (Object $单个 : $前) $返回.添加($单个);
        for (Object $单个 : $后) $返回.添加($单个);
        return $返回.到数组();
    }
    
}

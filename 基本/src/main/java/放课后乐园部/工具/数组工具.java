package 放课后乐园部.工具;

import 放课后乐园部.收集.*;
import java.lang.reflect.*;

public class 数组工具 {

    public static Object[] 创建(Class<?> $类,int $长度) {
        return (Object[]) Array.newInstance($类, $长度);
    }

    public static Object[] 添加(Class $类,Object[] $数组,Object $对象) {
        集合 $返回 = 集合.到集合($数组);
        $返回.添加($对象);
        return $返回.到数组($类);
    }

    public static Object[] 添加(Class<?> $类,Object[] $数组,int $键值,Object $对象) {
        集合 $返回 = 集合.到集合($数组);
        $返回.添加($键值, $对象);
        return $返回.到数组($类);
    }

    public static Object[] 删除(Class<?> $类,Object[] $数组,Object $对象) {
        集合 $返回 = 集合.到集合($数组);
        $返回.remove($对象);
        return $返回.到数组($类);
    }

    public static Object[] 删除(Class<?> $类,Object[] $数组,int $键值) {
        集合 $返回 = 集合.到集合($数组);
        $返回.remove($键值);
        return $返回.到数组($类);
    }

    public static Object[] 截取(Class<?> $类,Object[] $数组,Integer $开始,Integer $结束) {
        int $开始位置 = $开始 == null ? 0 : $开始;
        int $结束位置 = $结束 == null ? $数组.length : $结束 + 1;
        int $长度 = $结束位置 - $开始位置;
        Object[] $返回 = 创建($类,$长度);
        int $当前位置 = 0;
        for (int $键值 = $开始位置;$键值 < $结束位置;$键值 ++) {
            $返回[$当前位置] = $数组[$键值];
            $当前位置 ++;
        }
        return $返回;
    }

    public static Object[] 转换(Class<?> $类,Object[] $数组) {
        if ($数组.getClass().isAssignableFrom($类)) {
            return $数组;
        } else {
            Object[] $返回 = 创建($类,$数组.length);
            for (int $键值 = 0;$键值 < $数组.length;$键值 ++) {
                $返回[$键值] = $数组;
            }
            return $返回;
        }
    }
    
    public static Object[] 合并(Class<?> $类,Object[] $前,Object[] $后) {
        集合 $返回 = new 集合();
        for (Object $单个 : $前)
            $返回.添加($单个);
        for (Object $单个 : $后)
            $返回.添加($单个);
        return $返回.到数组($类);
    }

}

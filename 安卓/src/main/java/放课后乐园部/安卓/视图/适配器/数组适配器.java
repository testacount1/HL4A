package 放课后乐园部.安卓.视图.适配器;

import android.content.*;
import android.view.*;
import java.util.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.资源.布局.*;
import 放课后乐园部.收集.*;

public class 数组适配器 extends 基本适配器 {

    public 数组适配器(Context $上下文,Object[] $数组) {
        this($上下文,集合.到集合($数组));
    }
    
    public 数组适配器(Context $上下文,List $数据) {
        super($上下文,$数据);
    }

	public void 添加(String $项目) {
		哈希表 $参数 = new 哈希表();
		$参数.设置("内容",$项目);
		数据.添加($参数);
		发送更新事件();
	}
	
    @Override
    public List 转换(List $数据) {
        集合 $返回 = new 集合();
        for (Object $单个 : $数据) {
            $返回.添加(new 哈希表().设置("内容",$单个.toString()));
        }
        return $返回;
    }
    
    @Override
    public View 创建() {
        return new 布局_适配器_数组(上下文);
    }

    @Override
    public View 处理(View $视图,哈希表 $参数) {
        文本视图 $内容 = ((布局_适配器_数组)$视图).文本;
        $内容.置文本((String)$参数.读取("内容"));
        return $视图;
    }
    
}

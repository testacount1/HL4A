package 放课后乐园部.视图.适配器;

import android.widget.*;
import android.view.*;
import 放课后乐园部.收集.*;
import android.content.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.基本.*;

public class 数组适配器 extends BaseAdapter {

    public Context 环境;
    public 集合 数组;
    public 哈希表 保存;

    public 数组适配器(Context $上下文) {
        环境 = $上下文;
        数组 = new 集合();
    }
    
    public 数组适配器 添加(String $内容) {
        数组.添加($内容);
        return this;
    }
    
    public View 读取(String $内容) {
        return (View)保存.读取($内容);
    }

    @Override
    public int getCount() {
        return 数组.size();
    }

    @Override
    public Object getItem(int $键值) {
        return 数组.get($键值+1);
    }

    @Override
    public long getItemId(int $键值) {
        return $键值;
    }

    @Override
    public View getView(int $键值,View $视图,ViewGroup $视图组) {

        线性布局 $布局 = new 线性布局(环境)
            .置背景("透明")
            .置宽度("最大")
            .置高度("自动")
            .置方向("水平")
            .置重力("中间垂直")
            .置左填充("16dp")
            .置标签("布局");

        文本控件 $文本 = new 文本控件(环境)
            .置主题("默认")
            .置文本((String)数组.get($键值+1))
            .加入到($布局)
            .置标签("文本");

        保存.设置((String)数组.get($键值+1), $文本);

        return $布局;
    }



}

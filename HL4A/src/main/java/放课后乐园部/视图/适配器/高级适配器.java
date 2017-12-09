package 放课后乐园部.视图.适配器;

import android.widget.*;
import android.view.*;
import 放课后乐园部.收集.*;

public class 高级适配器 extends BaseAdapter {

    哈希表 保存;
    集合 布局表;

    public void 添加视图(String $标签,View $视图) {
        布局表.添加($视图);
        保存.设置($标签, $视图);
    }

    public View 读取视图(int $键值) {
        return (View)布局表.get($键值);
    }

    public View 读取视图(String $标签) {
        return (View)保存.读取($标签);
    }

    @Override
    public int getCount() {
        return 布局表.toArray().length;
    }

    @Override
    public Object getItem(int $键值) {
        return 读取视图($键值);
    }

    @Override
    public long getItemId(int $键值) {
        return $键值;
    }

    @Override
    public View getView(int $键值,View $视图,ViewGroup $视图组) {
        return (View)布局表.get($键值);
    }

}

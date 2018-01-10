package 放课后乐园部.视图.实现;

import android.view.*;

public interface 基本布局 extends 基本视图 {
    
    public void 加入子元素(View $视图);
    public View 取子元素(Object $标签);
    public View 取子元素(int $键值);
    public View[] 取所有子元素();
    
    
}

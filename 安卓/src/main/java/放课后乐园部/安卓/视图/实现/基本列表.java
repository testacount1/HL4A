package 放课后乐园部.安卓.视图.实现;

import android.widget.*;
import 放课后乐园部.事件.*;

public interface 基本列表 extends 基本视图 {
    
    public void 置适配器(BaseAdapter $适配器);
    public void 置项目单击事件(通用方法 $方法);
    public void 置项目长按事件(通用方法 $方法);
    public void 置项目选中事件(通用方法 $方法);
    public void 置项目选中事件(通用方法 $选中,通用方法 $取消);
    
}

package 放课后乐园部.安卓.资源.布局;

import android.content.*;
import 放课后乐园部.工具.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.工具.*;

public class 布局_适配器_复选 extends 布局_适配器_数组 {
    
    public 线性布局 右项;
    public 复选框 复选;
    
    public 布局_适配器_复选(Context $上下文) {
        super($上下文);
        右项 = new 线性布局(this);
        右项.置宽度(主题工具.取中等填充());
        右项.置重力("中间");
        复选 = new 复选框(右项);
    }
    
}

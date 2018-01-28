package 放课后乐园部.安卓.资源.布局;

import android.content.*;
import 放课后乐园部.安卓.图形.*;
import 放课后乐园部.安卓.视图.*;

public class 布局_提示 extends 卡片视图 {
    
    public 文本视图 文本;
    
    public 布局_提示(Context $上下文) {
        super($上下文);
        置背景颜色(颜色.白色);
        线性布局 $内容 = new 线性布局(this);
        $内容.置填充("8dp");
        $内容.置重力("中间");
        文本 = new 文本视图($内容);
    }

}

package hl4a.ide.layout;

import android.content.*;
import 放课后乐园部.安卓.视图.*;

public class 布局_新建工程 extends 线性布局 {
    
    public 编辑框 工程名;
    public 编辑框 包名;
    
    public 布局_新建工程(Context $上下文) {
        super($上下文);
        置左填充("16dp");
        置右填充("16dp");
        工程名 = new 编辑框(this);
        工程名.置默认文本("工程名");
        包名 = new 编辑框(this);
        包名.置默认文本("包名");
    }
    
}

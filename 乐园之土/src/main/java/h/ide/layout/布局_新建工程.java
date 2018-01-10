package h.ide.layout;

import 放课后乐园部.资源.布局.*;
import android.content.*;
import 放课后乐园部.收集.*;
import 放课后乐园部.视图.*;

public class 布局_新建工程 extends 线性布局 {
    
    public 编辑框 工程名;
    public 编辑框 包名;
    
    public 布局_新建工程(Context $上下文) {
        super($上下文);
        置填充("16dp");
        工程名 = new 编辑框($上下文);
        工程名.置默认文本("工程名:");
    }
    
}

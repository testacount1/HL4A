package hl4a.ide.layout;

import 放课后乐园部.安卓.资源.布局.*;
import 放课后乐园部.安卓.视图.扩展.*;
import android.content.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.视图.适配器.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.安卓.工具.*;

public class 布局_帮助文档 extends 布局_基本界面 {
  
    public 列表视图 列表;
    public 数组适配器 适配器;
    
    public 布局_帮助文档(Context $上下文) {
        super($上下文);
        标题.置标题("帮助文档");
        列表 = new 列表视图(底层);
    }
    
    
}

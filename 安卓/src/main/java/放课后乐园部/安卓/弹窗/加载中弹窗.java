package 放课后乐园部.安卓.弹窗;

import android.app.*;
import 放课后乐园部.安卓.资源.布局.*;

public class 加载中弹窗 extends 基本弹窗 {
    
    public 布局_加载中 布局对象;
    
    public 加载中弹窗(Activity $界面) {
        super($界面);
        布局对象 = new 布局_加载中($界面);
        置内容(布局对象);
    }
  
    
}

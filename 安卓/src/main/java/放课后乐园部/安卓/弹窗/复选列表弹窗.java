package 放课后乐园部.安卓.弹窗;

import android.content.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.视图.适配器.*;

public class 复选列表弹窗 extends 基本弹窗 {
    
    private 列表视图 列表;
    private 复选适配器 适配器;

    public 复选列表弹窗(Context $上下文) {
        super($上下文);
        列表 = new 列表视图($上下文);
        适配器 = new 复选适配器($上下文,new String[0]);
        列表.置适配器(适配器);
        置内容(列表);
    }

    public void 置数组(String... $数组) {
        适配器.设置($数组);
    }

    public void 添加(String... $数组) {
        适配器.添加($数组);
    }

    public void 清空() {
        适配器.清空();
    }

    public void 置单击(通用方法 $单击) {
        列表.置项目单击事件($单击);
    }
    
}

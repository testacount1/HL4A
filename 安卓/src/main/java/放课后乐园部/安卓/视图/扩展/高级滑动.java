package 放课后乐园部.安卓.视图.扩展;

import android.content.*;
import android.view.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.视图.实现.*;
import 放课后乐园部.安卓.视图.适配器.*;

public class 高级滑动 extends 线性布局 {
	
	public 滑动视图 滑动;
	public 界面适配器 适配器;
	
	public 高级滑动(Context $上下文) {
        super($上下文);
		滑动 = new 滑动视图(this);
    }

    public 高级滑动(ViewGroup $父视图) {
        this($父视图.getContext());
        加入到($父视图);
    }
	
	public static class 滑动{}
	
}

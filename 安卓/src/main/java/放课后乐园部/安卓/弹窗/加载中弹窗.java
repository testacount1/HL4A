package 放课后乐园部.安卓.弹窗;

import android.app.*;
import 放课后乐园部.安卓.资源.布局.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.事件.*;

public class 加载中弹窗 extends 基本弹窗 {
    
    public 布局_加载中 布局;
	public 文本视图 文本;
    
    public 加载中弹窗(Activity $界面) {
        super($界面);
        布局 = new 布局_加载中($界面);
		文本 = 布局.文本对象;
        置内容(布局);
    }
	
	public void 更新(final String $内容) {
		处理工具.主线程(new 通用方法() {
				@Override
				public Object 调用(Object[] $参数) {
					文本.置文本($内容);
					return null;
				}
			});
	}
  
    
}

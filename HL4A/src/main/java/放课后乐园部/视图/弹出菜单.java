package 放课后乐园部.视图;

import android.view.*;
import android.widget.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.视图.事件.*;
import 放课后乐园部.视图.适配器.*;
import 放课后乐园部.收集.*;
import 放课后乐园部.视图.实现.*;
import 放课后乐园部.弹窗.*;

public class 弹出菜单 extends ListPopupWindow {
    
	数组适配器 适配器;
	
	哈希表 单击 = new 哈希表();

    public 弹出菜单(View $视图) {
        super($视图.getContext());
		setAnchorView($视图);
		适配器 = new 数组适配器($视图.getContext(),new 集合());
		setAdapter(适配器);
		setOnItemClickListener(new 项目单击(单击事件));
		setWidth(new Float(应用.取屏幕宽度()*0.618*0.618).intValue());
		setModal(true);
    }

	通用方法 单击事件 = new 通用方法() {
		@Override
		public Object 调用(Object[] $参数) {
			int $位置 = $参数[2];
			if (单击.检查($位置)) {
				通用方法 $单击 = (通用方法)单击.读取($位置);
				调用方法.事件($单击);
			}
			return null;
		}
	};
	
	public void 添加(String $名称,通用方法 $单击) {
		单击.设置(适配器.数据.数量(),$单击);
		适配器.添加($名称);
	}
	
	public void 置宽度(int $宽度) {
		setWidth($宽度);
	}

    public void 显示() {
        show();
    }
	
	public void 隐藏() {
		dismiss();
	}
    
}

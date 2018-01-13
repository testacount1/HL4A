package 放课后乐园部.基本;

import android.content.*;
import android.widget.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.事件.*;
import android.view.*;
import 放课后乐园部.收集.*;
import 放课后乐园部.视图.适配器.*;
import 放课后乐园部.资源.布局.*;

public class 菜单 extends PopupWindow {

    View 控件;
    Context 上下文;
	数组适配器 数组;
	卡片视图 卡片;
	列表视图 列表;

	哈希表 单击;
	
    public 菜单(View $控件) {
        super($控件);
        控件 = $控件;
        上下文 = $控件.getContext();
        setWidth(-2);
        setHeight(-2);
        setFocusable(true);
		单击 = new 哈希表();
		卡片 = new 卡片视图(上下文);
		卡片.setRadius(20);
		列表 = new 列表视图(卡片);
		列表.置项目单击事件(项目单击);
		数组 = new 数组适配器(上下文,new Object[0]);
		列表.置适配器(数组);
		setContentView(卡片);
        //setBackgroundDrawable(绘画.颜色转绘画(颜色.白色));
    }
	
	public void 添加(String $内容,通用方法 $单击) {
		单击.设置($内容,$单击);
		数组.添加($内容);
	}

    public void 显示() {
        showAsDropDown(控件);
    }

    public void 隐藏() {
        dismiss();
    }
	
	通用方法 项目单击 = new 通用方法() {
		@Override
		public Object 调用(Object[] $参数) {
			String $内容 = ((布局_适配器_数组)$参数[1]).文本.取文本();;
			if (单击.检查($内容)) {
				调用方法.事件((通用方法)单击.读取($内容));
			}
			return null;
		}
	};

}

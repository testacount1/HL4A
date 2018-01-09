package 放课后乐园部.基本;

import android.app.*;
import android.os.*;
import android.view.*;
import 放课后乐园部.视图.*;
import org.autojs.dynamiclayoutinflater.*;
import android.content.*;

public class 布局 {

    布局() {}

	static final boolean 可直接 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;

    public static View 读取(Context $上下文,String $地址) {
        return new DynamicLayoutInflater($上下文).inflate(字符.读取($地址));
    }
    
    public static void 打开(Activity $界面,View $视图) {
		if (可直接) {
			Window $窗口 = $界面.getWindow();
			$窗口.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); //Then call setStatusBarColor. 
			$窗口.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			$窗口.setStatusBarColor(视图.检查颜色(主题.基本深色()));
			$界面.setContentView($视图);
			return;
		}
        if ($视图 instanceof ViewGroup) {
            if ($视图.findViewWithTag("$状态栏") != null) {
                $界面.setContentView($视图);
                return;
            }
        }
        $界面.setContentView(加入沉浸状态栏($界面, $视图));
    }

    public static View 加入沉浸状态栏(Activity $上下文,View $视图) {
		线性布局 $内容 = new 线性布局($上下文);
		$内容.置背景颜色(主题.基本深色());
		$内容.置宽度("最大");
		$内容.置高度(应用.取状态栏高度($上下文));
        线性布局 $状态栏 = new 线性布局($上下文);
		$状态栏.置标签("$状态栏");
		$状态栏.加入子元素($内容);
		$状态栏.加入子元素($视图);
		return $状态栏;
    }

}

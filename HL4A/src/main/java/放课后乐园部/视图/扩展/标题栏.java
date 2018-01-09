package 放课后乐园部.视图.扩展;

import android.app.*;
import android.content.*;
import android.view.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.视图.实现.*;

public class 标题栏 extends 线性布局 {

    public 文本控件 标题对象;
    public 线性布局 左按钮栏;
    public 线性布局 右按钮栏;

    Context 上下文;

    public 标题栏(Context $上下文) {
        super($上下文);

        上下文 = $上下文;

		置标签("标题");
        置方向("水平");
        置高度("56dp");
        置重力("中间垂直");
        置背景颜色(主题.基本色());

        左按钮栏 = new 线性布局(上下文);
        左按钮栏.置宽度("自动");
        左按钮栏.加入到(this);

        标题对象 = new 文本控件(上下文);
		标题对象.置文本大小(主题.大文本());
		标题对象.置文本颜色(颜色.白色);
		标题对象.置左填充("16dp");
        标题对象.setHorizontallyScrolling(true);
		标题对象.加入到(this);

        右按钮栏 = new 线性布局(上下文);
		右按钮栏.置高度("56dp");
		右按钮栏.置方向("水平");
		右按钮栏.置重力("右边");
		右按钮栏.加入到(this);

    }

    public void 切换() {
        标题对象.置文本颜色(主题.基本色());
        置背景(颜色.白色);
    }

    public String 取标题() {
        return 标题对象.取文本();
    }

    public void 置标题(String $内容) {
        标题对象.置文本($内容);
    }

    public 线性按钮 左按钮(通用方法 $事件) {
        线性按钮 $按钮 = new 线性按钮(上下文, "图片.菜单");
        $按钮.加入到(左按钮栏);
		$按钮.置单击事件($事件);
        return $按钮;
    }

    public 线性按钮 左按钮(String $图片,通用方法 $事件) {
        线性按钮 $按钮 = new 线性按钮(上下文, $图片);
        $按钮.加入到(左按钮栏);
		$按钮.置单击事件($事件);
        return $按钮;
    }

    public 线性按钮 右按钮(通用方法 $事件) {
        线性按钮 $按钮 = new 线性按钮(上下文, "图片.更多");
        $按钮.加入到(右按钮栏);
		$按钮.置单击事件($事件);
        return $按钮;
    }

    public 线性按钮 右按钮(String $图片,通用方法 $事件) {
        线性按钮 $按钮 = new 线性按钮(上下文, $图片);
        $按钮.加入到(右按钮栏);
		$按钮.置单击事件($事件);
        return $按钮;
    }


}

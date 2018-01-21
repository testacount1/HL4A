package 放课后乐园部.安卓.视图.扩展;

import android.content.*;
import android.view.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.安卓.图形.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.安卓.资源.*;
import 放课后乐园部.工具.*;

public class 标题栏 extends 线性布局 {

    public 文本视图 标题对象;
    public 线性布局 左按钮栏;
    public 线性布局 右按钮栏;
	
	public static final byte[] 阴影图片 = 编码工具.Base64.解码("iVBORw0KGgoAAAANSUhEUgAAAAYAAAAGCAMAAADXEh96AAAAD1BMVEUAAAAAAAAAAAAAAAD///9PsMGfAAAABXRSTlMtIhEGALq/5HAAAAAaSURBVAjXY2CAAEYwYGACAwZmMGBgAQMoBQAEmABVxsd5dwAAAABJRU5ErkJggg==");
	
	public 图片视图 阴影视图;

    Context 上下文;

    public 标题栏(Context $上下文) {
        super($上下文);

        上下文 = $上下文;

		置标签("标题");
        置方向("水平");
        置高度(主题工具.取中等填充());
        置重力("中间垂直");
        置背景颜色(主题工具.取主题颜色().取基本色());

        左按钮栏 = new 线性布局(this);
        左按钮栏.置宽度("自动");

        标题对象 = new 文本视图(this);
		标题对象.置文本大小(主题工具.取大文本大小());
		标题对象.置文本颜色(颜色.白色);
		标题对象.置左填充(主题工具.取默认填充());
        标题对象.setHorizontallyScrolling(true);

        右按钮栏 = new 线性布局(this);
		右按钮栏.置方向("水平");
		右按钮栏.置重力("右边");

    }
    
    public 标题栏(ViewGroup $父视图) {
        this($父视图.getContext());
        加入到($父视图);
    }

    public void 切换() {
        标题对象.置文本颜色(主题工具.取主题颜色().取基本色());
        置背景(颜色.白色);
    }

    public String 取标题() {
        return 标题对象.取文本();
    }

    public void 置标题(String $内容) {
        标题对象.置文本($内容);
    }

    public 线性按钮 左按钮(通用方法 $事件) {
        线性按钮 $按钮 = new 线性按钮(上下文, 图标.图标_menu_白色);
        $按钮.加入到(左按钮栏);
		$按钮.置单击事件($事件);
        return $按钮;
    }

    public 线性按钮 左按钮(byte[] $图片,通用方法 $事件) {
        线性按钮 $按钮 = new 线性按钮(上下文, $图片);
        $按钮.加入到(左按钮栏);
		$按钮.置单击事件($事件);
        return $按钮;
    }

    public 线性按钮 右按钮(通用方法 $事件) {
        线性按钮 $按钮 = new 线性按钮(上下文, 图标.图标_more_vert_白色);
        $按钮.加入到(右按钮栏);
		$按钮.置单击事件($事件);
        return $按钮;
    }

    public 线性按钮 右按钮(byte[] $图片,通用方法 $事件) {
        线性按钮 $按钮 = new 线性按钮(上下文, $图片);
        $按钮.加入到(右按钮栏);
		$按钮.置单击事件($事件);
        return $按钮;
    }


}

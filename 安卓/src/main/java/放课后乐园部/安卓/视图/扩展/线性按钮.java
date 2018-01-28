package 放课后乐园部.安卓.视图.扩展;

import android.content.*;
import android.view.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.安卓.视图.*;

public class 线性按钮 extends 线性布局 {

    public 图片视图 图片;

    public 线性按钮(Context $上下文,Object $图片) {
        super($上下文);
        置宽度("56dp");
        置高度("56dp");
        置背景(绘画工具.透明());
        置重力("中间");
        图片 = new 图片视图(this);
        图片.置宽度("22dp");
        图片.置高度("22dp");
        图片.置图片($图片);
    }
    
    public 线性按钮(ViewGroup $父视图,byte[] $图片) {
        this($父视图.getContext(),$图片);
        加入到($父视图);
    }

}

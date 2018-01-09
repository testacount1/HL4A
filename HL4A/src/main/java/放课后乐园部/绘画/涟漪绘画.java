package 放课后乐园部.绘画;

import android.graphics.drawable.*;
import android.content.*;
import android.content.res.*;
import 放课后乐园部.基本.*;

public class 涟漪绘画 extends RippleDrawable {

    public 涟漪绘画(Object $普通,Object $按下) {
        this($普通,$按下,绘画.颜色转绘画($普通),null);
	}
    
	public 涟漪绘画(Object $普通,Object $按下,Drawable $内容,Drawable $单击) {
		super(视图.创建颜色列表($普通,$按下), $内容, $单击);
	}
    
    public void 置圆角半径(Object $大小) {
        setRadius(视图.检查大小($大小));
    }

}

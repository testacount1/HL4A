package 放课后乐园部.绘画;

import android.graphics.drawable.*;
import android.content.*;
import android.content.res.*;
import 放课后乐园部.基本.*;

public class 涟漪绘画 extends RippleDrawable {

	public 涟漪绘画(int $普通,int $按下,Drawable $内容,Drawable $单击) {
		super(视图.创建颜色列表($普通,$按下), $内容, $单击);
	}

}

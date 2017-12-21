package 放课后乐园部.绘画;

import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import 放课后乐园部.基本.视图;

public class 按下变色绘画 extends StateListDrawable {

		public 按下变色绘画(Object $颜色,Object $按下) {
				GradientDrawable $普通颜色 = new GradientDrawable();
				$普通颜色.setColor(视图.检查颜色($颜色));
				GradientDrawable $按下颜色 = new GradientDrawable();
				$按下颜色.setColor(视图.检查颜色($按下));
				addState(new int[]{android.R.attr.state_pressed}, $按下颜色);
				addState(new int[]{}, $普通颜色);
		}

}

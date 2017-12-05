package 放课后乐园部.绘画;

import android.graphics.drawable.*;

public class 按下变色绘画 extends StateListDrawable {

		public 按下变色绘画(Object $颜色,Object $按下) {
				GradientDrawable $普通颜色 = new GradientDrawable();
				$普通颜色.setColor($颜色);
				GradientDrawable $按下颜色 = new GradientDrawable();
				$按下颜色.setColor($按下);
				addState(new int[]{android.R.attr.state_pressed}, $按下颜色);
				addState(new int[]{}, $普通颜色);
		}

}

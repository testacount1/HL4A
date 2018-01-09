package 放课后乐园部.视图.实现;

import android.widget.*;
import 放课后乐园部.基本.*;

public class 进度条实现 {
		
		private 进度条实现() {}
		
		public static void 置进度(ProgressBar $视图,int $进度) {
				$视图.setProgress($进度);
		}
		
		public static int 取进度(ProgressBar $视图) {
				return $视图.getProgress();
		}
		
		public static void 置二级进度(ProgressBar $视图,int $进度) {
				$视图.setSecondaryProgress($进度);
		}
		
		public static int 取二级进度(ProgressBar $视图) {
				return $视图.getSecondaryProgress();
		}
		
		public static void 置进度颜色(ProgressBar $视图,Object $颜色) {
				$视图.setProgressDrawable(绘画.颜色转绘画(视图.检查颜色($颜色)));
		}
		
}

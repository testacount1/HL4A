package 放课后乐园部.安卓.工具;

import android.util.TypedValue;
import java.lang.reflect.TypeVariable;
import android.util.DisplayMetrics;

public class 转换工具 {

		private static DisplayMetrics rdm = 上下文工具.取全局上下文().getResources().getDisplayMetrics();

		public static Integer px(Integer $值) {
				return 转换大小(TypedValue.COMPLEX_UNIT_PX, $值);
		}

		public static Integer dp(Integer $值) {
				return 转换大小(TypedValue.COMPLEX_UNIT_DIP, $值);
		}

		public static Integer sp(Integer $值) {
				return 转换大小(TypedValue.COMPLEX_UNIT_SP, $值);
		}
		
		public static Integer pt(Integer $值) {
				return 转换大小(TypedValue.COMPLEX_UNIT_PT,$值);
		}
		
		public static Integer mm(Integer $值) {
				return 转换大小(TypedValue.COMPLEX_UNIT_MM,$值);
		}

		public static Integer in(Integer $值) {
				return 转换大小(TypedValue.COMPLEX_UNIT_IN,$值);
		}
		
		public static Integer 数字(String $值) {
				return new Integer($值);
		}

		private static Integer 转换大小(Integer $类型,Integer $值) {
				return (int) TypedValue.applyDimension($类型, $值, rdm);
		}

}

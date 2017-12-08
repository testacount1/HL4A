package 放课后乐园部.基本;

import android.graphics.*;
import 放课后乐园部.注解.注释.*;

public class 字体 {

	 字体() {}

		public static Typeface 取字体(String $文件) {
				return Typeface.createFromFile($文件);
		}

}

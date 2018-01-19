package 放课后乐园部.安卓.工具;

import android.graphics.Typeface;
import 放课后乐园部.工具.*;

public class 字体工具 {

    public static Typeface 取字体(String $文件) {
        return Typeface.createFromFile(文件工具.取文件对象($文件));
    }

}

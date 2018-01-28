package 放课后乐园部.安卓.工具;

import android.util.TypedValue;
import java.lang.reflect.TypeVariable;
import android.util.DisplayMetrics;

public class 转换工具 {

    public static DisplayMetrics rdm = 上下文工具.取全局上下文().getResources().getDisplayMetrics();

    public static Float px(int $值) {
        return 转换大小(TypedValue.COMPLEX_UNIT_PX, $值);
    }

    public static Float dp(int $值) {
        return 转换大小(TypedValue.COMPLEX_UNIT_DIP, $值);
    }

    public static Float sp(int $值) {
        return 转换大小(TypedValue.COMPLEX_UNIT_SP, $值);
    }

    public static Float pt(int $值) {
        return 转换大小(TypedValue.COMPLEX_UNIT_PT, $值);
    }

    public static Float mm(int $值) {
        return 转换大小(TypedValue.COMPLEX_UNIT_MM, $值);
    }

    public static Float in(int $值) {
        return 转换大小(TypedValue.COMPLEX_UNIT_IN, $值);
    }

    public static Float 数字(String $值) {
        return new Float($值);
    }
    
    private static Float 转换大小(int $类型,int $值) {
        return TypedValue.applyDimension($类型, $值, rdm);
    }

}

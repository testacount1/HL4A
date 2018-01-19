package 放课后乐园部.安卓.视图.扩展;

import android.content.*;
import android.view.*;
import 放课后乐园部.安卓.视图.*;

public class 底层布局 extends 涟漪布局 {
    
    public 线性布局 底层;
    
    public 底层布局(Context $上下文) {
        super($上下文);
        置涟漪类型("矩形");
        底层 = new 线性布局($上下文);
        addView(底层);
    }
    
    public 底层布局(ViewGroup $父视图) {
        this($父视图.getContext());
        加入到($父视图);
    }

    @Override
    public void 加入子元素(View $子元素) {
        底层.加入子元素($子元素);
    }
    
}

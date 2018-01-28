package 放课后乐园部.安卓.视图.事件;

import android.view.*;
import android.view.View.*;
import 放课后乐园部.事件.*;

public class 触摸 implements OnTouchListener {

    private 通用方法 事件;
    
    public 触摸(通用方法 $事件) {
        事件 = $事件;
    }
    
    @Override
    public boolean onTouch(View $对象, MotionEvent $触摸信息) {
        // TODO: Implement this method
        return (调用方法.事件(事件,$对象,$触摸信息) == true);
    }

}

package 放课后乐园部.安卓.视图.事件;

import android.support.v4.view.*;
import 放课后乐园部.事件.*;

public class 界面滑动 implements ViewPager.OnPageChangeListener {
    
    public 通用方法 滑动;
    public 通用方法 改变;
    public 通用方法 状态;
    
    
    public 界面滑动(通用方法 $滑动,通用方法 $改变,通用方法 $状态) {
        滑动 = $滑动;
        改变 = $改变;
        状态 = $状态;
    }
    
    @Override
    public void onPageScrolled(int $界面,float $比例,int $像素) {
        调用方法.事件(滑动,$界面,$比例,$像素);
    }

    @Override
    public void onPageSelected(int $界面) {
        调用方法.事件(改变,$界面);
    }

    @Override
    public void onPageScrollStateChanged(int $状态) {
        调用方法.事件(状态,$状态);
        // 0 结束
        // 1 按下
        // 2 抬起
    }

}

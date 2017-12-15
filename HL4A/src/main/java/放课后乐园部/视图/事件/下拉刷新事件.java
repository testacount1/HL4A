package 放课后乐园部.视图.事件;

import android.support.v4.widget.*;
import 放课后乐园部.事件.*;

public class 下拉刷新事件 implements SwipeRefreshLayout.OnRefreshListener {

    通用方法 方法;
    
    public 下拉刷新事件(通用方法 $事件) {
        方法 = $事件;
    }
    
    @Override
    public void onRefresh() {
        调用方法.事件(方法);
    }
    
}

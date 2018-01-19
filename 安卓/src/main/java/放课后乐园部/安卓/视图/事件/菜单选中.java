package 放课后乐园部.安卓.视图.事件;

import android.view.*;
import android.view.MenuItem.*;
import 放课后乐园部.事件.*;

public class 菜单选中 implements OnMenuItemClickListener {

    通用方法 事件;
    
    public 菜单选中(通用方法 $方法) {
        事件 = $方法;
    } 
    
    @Override
    public boolean onMenuItemClick(MenuItem $选项) {
        return 调用方法.事件(事件,$选项) == true;
    }

}

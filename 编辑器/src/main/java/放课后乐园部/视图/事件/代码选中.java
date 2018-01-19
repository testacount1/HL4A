package 放课后乐园部.视图.事件;

import com.myopicmobile.textwarrior.android.*;
import 放课后乐园部.事件.*;

public class 代码选中 implements OnSelectionChangedListener  {

    通用方法 事件;
    
    public 代码选中(通用方法 $方法) {
        事件 = $方法;
    }
    
    @Override
    public void onSelectionChanged(boolean active,int selStart,int selEnd) {
       调用方法.事件(事件,active,selStart,selEnd);
    }
    
}

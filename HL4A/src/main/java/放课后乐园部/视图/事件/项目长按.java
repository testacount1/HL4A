package 放课后乐园部.视图.事件;

import android.widget.AdapterView.*;
import android.view.*;
import android.widget.*;
import 放课后乐园部.事件.*;

public class 项目长按 implements OnItemLongClickListener {

    通用方法 长按;
    
    public 项目长按(通用方法 $方法) {
        长按 = $方法;
    }
    
    @Override
    public boolean onItemLongClick(AdapterView<?> $适配器视图,View $视图,int $键值,long $ID) {
        Object $返回值 = 调用方法.事件(长按,$适配器视图,$视图,$键值,$ID);
        return $返回值 == true;
    }

}

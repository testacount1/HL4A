package 放课后乐园部.视图.事件;

import android.widget.AdapterView.*;
import android.view.*;
import android.widget.*;
import 放课后乐园部.事件.*;

public class 项目选中 implements OnItemSelectedListener {

    通用方法 选中;
    通用方法 取消;
    
    public 项目选中(通用方法 $选中,通用方法 $没选中) {
        选中 = $选中;
        取消 = $没选中;
    }
    
    
    @Override
    public void onItemSelected(AdapterView<?> $适配器视图,View $视图,int $键值,long $ID) {
        调用方法.事件(选中,$适配器视图,$视图,$键值,$ID);
    }

    @Override
    public void onNothingSelected(AdapterView<?> $适配器视图) {
        调用方法.事件(取消,$适配器视图);
    }

}

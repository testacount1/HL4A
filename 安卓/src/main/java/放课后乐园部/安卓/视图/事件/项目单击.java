package 放课后乐园部.安卓.视图.事件;

import android.widget.AdapterView.*;
import android.view.*;
import android.widget.*;
import 放课后乐园部.事件.*;

public class 项目单击 implements OnItemClickListener {

    通用方法 单击;
    
    public 项目单击(通用方法 $方法) {
        单击 = $方法;
    }
    
    @Override
    public void onItemClick(AdapterView<?> $适配器视图,View $视图,int $键值,long $ID) {
        调用方法.事件(单击,$适配器视图,$视图,$键值,$ID);
    }

}

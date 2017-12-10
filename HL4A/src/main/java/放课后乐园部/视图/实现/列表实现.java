package 放课后乐园部.视图.实现;
import android.widget.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.视图.事件.*;

public class 列表实现 {
    
    列表实现() {}
    
    public static void 置项目选中事件(AdapterView $视图,通用方法 $选中,通用方法 $取消) {
        $视图.setOnItemSelectedListener(new 项目选中($选中,$取消));
    }
    
    public static void 置项目选中事件(AdapterView $视图,通用方法 $方法) {
        置项目选中事件($视图,$方法,null);
    }
    
    public static void 置项目单击事件(AdapterView $视图,通用方法 $方法) {
        $视图.setOnItemClickListener(new 项目单击($方法));
    }
    
    public static void 置项目长按事件(AdapterView $视图,通用方法 $方法) {
        $视图.setOnItemLongClickListener(new 项目长按($方法));
    }
    
    
    
}

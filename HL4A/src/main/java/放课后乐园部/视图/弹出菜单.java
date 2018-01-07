package 放课后乐园部.视图;

import android.content.*;
import android.view.*;
import android.widget.*;
import 放课后乐园部.视图.事件.*;
import 放课后乐园部.事件.*;

public class 弹出菜单 extends PopupMenu {
    
    Menu 菜单;
    
    public 弹出菜单(View $视图) {
        super($视图.getContext(),$视图);
        菜单 = getMenu();
    }
    
    public void 添加(String $名称,通用方法 $单击) {
        菜单.add($名称).setOnMenuItemClickListener(new 菜单选中($单击));
    }
    
    public void 显示() {
        show();
    }
    
}

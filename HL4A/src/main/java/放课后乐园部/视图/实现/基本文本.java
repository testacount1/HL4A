package 放课后乐园部.视图.实现;

import android.graphics.*;
import android.widget.*;
import 放课后乐园部.事件.*;

public interface 基本文本 extends 基本视图 {
    
    public void 置文本(String $文本);
    public void 置HTML文本(String $HTML);
    public String 取文本();
    
    public void 置文本大小(Object $大小);
    public void 置文本颜色(Object $颜色);
    
    public void 置文本字体(String $地址);
    public void 置文本字体(Typeface $字体);
    
    public void 置文本重力(String $重力);
    
    public void 置文本显示在同一行();
    public void 置文本显示在同一行(Boolean $是否);
    
    public void 置行数(int $函数);
    public void 置最小行数(int $函数);
    public void 置最大行数(int $函数);
    
    public void 置链接可点击();
    public void 置链接可点击(Boolean $是否);
    
    public void 置链接颜色(Object $颜色);
    
    public void 置文本改变事件(通用方法 $改变);
    public void 置文本改变事件(通用方法 $改变前,通用方法 $已改变,通用方法 $改变后);
    
}

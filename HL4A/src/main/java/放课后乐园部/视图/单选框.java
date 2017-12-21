package 放课后乐园部.视图;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.视图.实现.*;

public class 单选框 extends RadioButton implements 基本视图 {
    
    public 单选框(Context $上下文) {
        super($上下文);
        视图实现.初始化控件(this);
    }
    

    @Override
    public 单选框 置布局重力(String $重力) {
        视图实现.置布局重力(this,$重力);
        return this;
    }

    @Override
    public 单选框 置布局权重(float $权重) {
        视图实现.置布局权重(this,$权重);
        return this;
    }
    
    public 单选框 置选中状态(boolean $是否打开) {
        setSelected($是否打开);
        return this;
    }

    public 单选框 选中() {
        置选中状态(true);
        return this;
    }

    public 单选框 取消() {
        置选中状态(false);
        return this;
    }

    public boolean 取选中状态() {
        return isSelected();
    }

    public 单选框 置文本(String $文本) {
        文本实现.置文本(this, $文本);
        return this;
    }

    public 单选框 置HTML文本(String $HTML) {
        文本实现.置HTML文本(this, $HTML);
        return this;
    }


    public String 取文本() {
        return 文本实现.取文本(this);
    }


    public 单选框 置文本大小(Object $大小) {
        文本实现.置文本大小(this, $大小);
        return this;
    }


    public 单选框 置文本颜色(Object $颜色) {
        文本实现.置文本颜色(this, $颜色);
        return this;
    }


    public 单选框 置文本字体(String $地址) {
        文本实现.置文本字体(this, $地址);
        return this;
    }


    public 单选框 置文本字体(Typeface $字体) {
        文本实现.置文本字体(this, $字体);
        return this;
    }


    public 单选框 置文本重力(String $重力) {
        文本实现.置文本重力(this, $重力);
        return this;
    }


    public 单选框 置文本显示在同一行() {
        文本实现.置文本显示在同一行(this);
        return this;

    }


    public 单选框 置文本显示在同一行(Boolean $是否) {
        文本实现.置文本显示在同一行(this, $是否);
        return this;
    }


    public 单选框 置行数(int $行数) {
        文本实现.置行数(this, $行数);
        return this;
    }


    public 单选框 置最小行数(int $行数) {
        文本实现.置最小行数(this, $行数);
        return this;
    }


    public 单选框 置最大行数(int $行数) {
        文本实现.置最大行数(this, $行数);
        return this;
    }


    public 单选框 置链接可点击() {
        文本实现.置链接可点击(this);
        return this;
    }


    public 单选框 置链接可点击(Boolean $是否) {
        文本实现.置链接可点击(this, $是否);
        return this;
    }


    public 单选框 置链接颜色(Object $颜色) {
        文本实现.置链接颜色(this, $颜色);
        return this;
    }


    public 单选框 置文本改变事件(通用方法 $事件) {
        文本实现.置文本改变事件(this, $事件);
        return this;
    }


    public 单选框 置文本改变事件(通用方法 $改变前,通用方法 $已改变,通用方法 $改变后) {
        文本实现.置文本改变事件(this, $改变前, $已改变, $改变后);
        return this;
    }


    @Override
    public 单选框 加入到(ViewGroup $布局) {
        视图实现.加入到(this, $布局);
        return this;
    }

    @Override
    public 单选框 打开(Activity $界面) {
        视图实现.打开(this, $界面);
        return this;
    }

    @Override
    public 单选框 置标签(Object $标签) {
        视图实现.置标签(this, $标签);
        return this;
    }

    @Override
    public Object 取标签() {
        return 视图实现.取标签(this);
    }

    @Override
    public 单选框 置单击事件(通用方法 $事件) {
        视图实现.置单击事件(this, $事件);
        return this;
    }

    @Override
    public 单选框 置长按事件(通用方法 $事件) {
        视图实现.置长按事件(this, $事件);
        return this;
    }

    @Override
    public 单选框 置触摸事件(通用方法 $事件) {
        视图实现.置触摸事件(this, $事件);
        return this;
    }

    @Override
    public 单选框 置宽度(Object $宽度) {
        视图实现.置宽度(this, $宽度);
        return this;
    }

    @Override
    public 单选框 置高度(Object $高度) {
        视图实现.置高度(this, $高度);
        return this;
    }

    @Override
    public 单选框 置状态(String $状态) {
        视图实现.置状态(this, $状态);
        return this;
    }

    @Override
    public String 取状态() {
        return 视图实现.取状态(this);
    }

    @Override
    public 单选框 显示() {
        视图实现.显示(this);
        return this;
    }

    @Override
    public 单选框 占位() {
        视图实现.占位(this);
        return this;
    }

    @Override
    public 单选框 隐藏() {
        视图实现.隐藏(this);
        return this;
    }

    @Override
    public 单选框 置边距(Object $边距) {
        视图实现.置边距(this, $边距);
        return this;
    }

    @Override
    public 单选框 置边距(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置边距(this, $上, $下, $左, $右);
        return this;
    }

    @Override
    public 单选框 置上边距(Object $边距) {
        视图实现.置上边距(this, $边距);
        return this;
    }

    @Override
    public 单选框 置下边距(Object $边距) {
        视图实现.置下边距(this, $边距);
        return this;
    }

    @Override
    public 单选框 置左边距(Object $边距) {
        视图实现.置左边距(this, $边距);
        return this;
    }

    @Override
    public 单选框 置右边距(Object $边距) {
        视图实现.置右边距(this, $边距);
        return this;
    }

    @Override
    public 单选框 置填充(Object $填充) {
        视图实现.置填充(this, $填充);
        return this;
    }

    @Override
    public 单选框 置填充(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置填充(this, $上, $下, $左, $右);
        return this;
    }

    @Override
    public 单选框 置上填充(Object $填充) {
        视图实现.置上填充(this, $填充);
        return this;
    }

    @Override
    public 单选框 置下填充(Object $填充) {
        视图实现.置下填充(this, $填充);
        return this;
    }

    @Override
    public 单选框 置左填充(Object $填充) {
        视图实现.置左填充(this, $填充);
        return this;
    }

    @Override
    public 单选框 置右填充(Object $填充) {
        视图实现.置右填充(this, $填充);
        return this;
    }

    @Override
    public 单选框 置背景(Object $背景) {
        视图实现.置背景(this, $背景);
        return this;
    }

    @Override
    public 单选框 置背景颜色(Object $颜色) {
        视图实现.置背景颜色(this, $颜色);
        return this;
    }
    
    
}

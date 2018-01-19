package 放课后乐园部.安卓.视图;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.安卓.视图.实现.*;

public class 复选框 extends CheckBox implements 基本视图 {
    
    
    public 复选框(Context $上下文) {
        super($上下文);
        视图实现.初始化控件(this);
    }
    
    public 复选框(ViewGroup $父视图) {
        this($父视图.getContext());
        加入到($父视图);
    }

    @Override
    public void 置布局重力(String $重力) {
        视图实现.置布局重力(this,$重力);
    }

    @Override
    public void 置布局权重(float $权重) {
        视图实现.置布局权重(this,$权重);
    }

    public void 置选中状态(boolean $是否打开) {
        setSelected($是否打开);
    }

    public void 选中() {
        置选中状态(true);
    }

    public void 取消() {
        置选中状态(false);
    }

    public boolean 取选中状态() {
        return isSelected();
    }

    public void 置文本(String $文本) {
        文本实现.置文本(this, $文本);
    }

    public void 置HTML文本(String $HTML) {
        文本实现.置HTML文本(this, $HTML);
    }

    public String 取文本() {
        return 文本实现.取文本(this);
    }

    public void 置文本大小(Object $大小) {
        文本实现.置文本大小(this, $大小);
    }

    public void 置文本颜色(Object $颜色) {
        文本实现.置文本颜色(this, $颜色);
    }

    public void 置文本字体(String $地址) {
        文本实现.置文本字体(this, $地址);
    }

    public void 置文本字体(Typeface $字体) {
        文本实现.置文本字体(this, $字体);
    }

    public void 置文本重力(String $重力) {
        文本实现.置文本重力(this, $重力);
    }

    public void 置文本显示在同一行() {
        文本实现.置文本显示在同一行(this);

    }

    public void 置文本显示在同一行(Boolean $是否) {
        文本实现.置文本显示在同一行(this, $是否);
    }

    public void 置行数(int $行数) {
        文本实现.置行数(this, $行数);
    }

    public void 置最小行数(int $行数) {
        文本实现.置最小行数(this, $行数);
    }

    public void 置最大行数(int $行数) {
        文本实现.置最大行数(this, $行数);
    }

    public void 置链接可点击() {
        文本实现.置链接可点击(this);
    }

    public void 置链接可点击(Boolean $是否) {
        文本实现.置链接可点击(this, $是否);
    }

    public void 置链接颜色(Object $颜色) {
        文本实现.置链接颜色(this, $颜色);
    }

    public void 置文本改变事件(通用方法 $事件) {
        文本实现.置文本改变事件(this, $事件);
    }

    public void 置文本改变事件(通用方法 $改变前,通用方法 $已改变,通用方法 $改变后) {
        文本实现.置文本改变事件(this, $改变前, $已改变, $改变后);
    }

    @Override
    public void 加入到(ViewGroup $布局) {
        视图实现.加入到(this, $布局);
    }

    @Override
    public void 打开(Activity $界面) {
        视图实现.打开(this, $界面);
    }

    @Override
    public void 置标签(Object $标签) {
        视图实现.置标签(this, $标签);
    }

    @Override
    public Object 取标签() {
        return 视图实现.取标签(this);
    }

    @Override
    public void 置单击事件(通用方法 $事件) {
        视图实现.置单击事件(this, $事件);
    }

    @Override
    public void 置长按事件(通用方法 $事件) {
        视图实现.置长按事件(this, $事件);
    }

    @Override
    public void 置触摸事件(通用方法 $事件) {
        视图实现.置触摸事件(this, $事件);
    }

    @Override
    public void 置宽度(Object $宽度) {
        视图实现.置宽度(this, $宽度);
    }

    @Override
    public void 置高度(Object $高度) {
        视图实现.置高度(this, $高度);
    }

    @Override
    public void 置状态(String $状态) {
        视图实现.置状态(this, $状态);
    }

    @Override
    public String 取状态() {
        return 视图实现.取状态(this);
    }

    @Override
    public void 显示() {
        视图实现.显示(this);
    }

    @Override
    public void 占位() {
        视图实现.占位(this);
    }

    @Override
    public void 隐藏() {
        视图实现.隐藏(this);
    }

    @Override
    public void 置边距(Object $边距) {
        视图实现.置边距(this, $边距);
    }

    @Override
    public void 置边距(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置边距(this, $上, $下, $左, $右);
    }

    @Override
    public void 置上边距(Object $边距) {
        视图实现.置上边距(this, $边距);
    }

    @Override
    public void 置下边距(Object $边距) {
        视图实现.置下边距(this, $边距);
    }

    @Override
    public void 置左边距(Object $边距) {
        视图实现.置左边距(this, $边距);
    }

    @Override
    public void 置右边距(Object $边距) {
        视图实现.置右边距(this, $边距);
    }

    @Override
    public void 置填充(Object $填充) {
        视图实现.置填充(this, $填充);
    }

    @Override
    public void 置填充(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置填充(this, $上, $下, $左, $右);
    }

    @Override
    public void 置上填充(Object $填充) {
        视图实现.置上填充(this, $填充);
    }

    @Override
    public void 置下填充(Object $填充) {
        视图实现.置下填充(this, $填充);
    }

    @Override
    public void 置左填充(Object $填充) {
        视图实现.置左填充(this, $填充);
    }

    @Override
    public void 置右填充(Object $填充) {
        视图实现.置右填充(this, $填充);
    }

    @Override
    public void 置背景(Object $背景) {
        视图实现.置背景(this, $背景);
    }

    @Override
    public void 置背景颜色(Object $颜色) {
        视图实现.置背景颜色(this, $颜色);
    }
    
}

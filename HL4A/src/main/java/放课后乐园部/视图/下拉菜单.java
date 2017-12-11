package 放课后乐园部.视图;

import android.app.*;
import android.content.*;
import android.view.*;
import android.widget.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.视图.实现.*;
import 放课后乐园部.视图.适配器.*;

public class 下拉菜单 extends Spinner implements 基本视图 {
    
    public 下拉菜单(Context $上下文) {
        super($上下文);
        视图实现.初始化控件(this);
        置主题("默认");
    }
    

    @Override
    public 下拉菜单 置布局重力(String $重力) {
        视图实现.置布局重力(this,$重力);
        return this;
    }

    @Override
    public 下拉菜单 置布局权重(float $权重) {
        视图实现.置布局权重(this,$权重);
        return this;
    }
    
    public 下拉菜单 置适配器(BaseAdapter $适配器) {
        setAdapter($适配器);
        return this;
    }

    public 下拉菜单 置项目单击事件(通用方法 $单击) {
        列表实现.置项目单击事件(this, $单击);
        return this;
    }

    public 下拉菜单 置项目长按事件(通用方法 $长按) {
        列表实现.置项目长按事件(this, $长按);
        return this;
    }

    public 下拉菜单 置项目选中事件(通用方法 $选中) {
        列表实现.置项目选中事件(this, $选中);
        return this;
    }

    public 下拉菜单 置项目选中事件(通用方法 $选中,通用方法 $取消) {
        列表实现.置项目选中事件(this, $选中,$取消);
        return this;
    }

    @Override
    public 下拉菜单 加入到(ViewGroup $布局) {
        视图实现.加入到(this, $布局);
        return this;
    }

    @Override
    public 下拉菜单 打开(Activity $界面) {
        视图实现.打开(this, $界面);
        return this;
    }

    @Override
    public 下拉菜单 置标签(Object $标签) {
        视图实现.置标签(this, $标签);
        return this;
    }

    @Override
    public Object 取标签() {
        return 视图实现.取标签(this);
    }

    @Override
    public 下拉菜单 置主题(String $主题) {
        视图实现.置主题(this, $主题);
        return this;
    }

    @Override
    public 下拉菜单 置单击事件(通用方法 $事件) {
        视图实现.置单击事件(this, $事件);
        return this;
    }

    @Override
    public 下拉菜单 置长按事件(通用方法 $事件) {
        视图实现.置长按事件(this, $事件);
        return this;
    }

    @Override
    public 下拉菜单 置触摸事件(通用方法 $事件) {
        视图实现.置触摸事件(this, $事件);
        return this;
    }

    @Override
    public 下拉菜单 置宽度(Object $宽度) {
        视图实现.置宽度(this, $宽度);
        return this;
    }

    @Override
    public 下拉菜单 置高度(Object $高度) {
        视图实现.置高度(this, $高度);
        return this;
    }

    @Override
    public 下拉菜单 置状态(String $状态) {
        视图实现.置状态(this, $状态);
        return this;
    }

    @Override
    public String 取状态() {
        return 视图实现.取状态(this);
    }

    @Override
    public 下拉菜单 显示() {
        视图实现.显示(this);
        return this;
    }

    @Override
    public 下拉菜单 占位() {
        视图实现.占位(this);
        return this;
    }

    @Override
    public 下拉菜单 隐藏() {
        视图实现.隐藏(this);
        return this;
    }

    @Override
    public 下拉菜单 置边距(Object $边距) {
        视图实现.置边距(this, $边距);
        return this;
    }

    @Override
    public 下拉菜单 置边距(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置边距(this, $上, $下, $左, $右);
        return this;
    }

    @Override
    public 下拉菜单 置上边距(Object $边距) {
        视图实现.置上边距(this, $边距);
        return this;
    }

    @Override
    public 下拉菜单 置下边距(Object $边距) {
        视图实现.置下边距(this, $边距);
        return this;
    }

    @Override
    public 下拉菜单 置左边距(Object $边距) {
        视图实现.置左边距(this, $边距);
        return this;
    }

    @Override
    public 下拉菜单 置右边距(Object $边距) {
        视图实现.置右边距(this, $边距);
        return this;
    }

    @Override
    public 下拉菜单 置填充(Object $填充) {
        视图实现.置填充(this, $填充);
        return this;
    }

    @Override
    public 下拉菜单 置填充(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置填充(this, $上, $下, $左, $右);
        return this;
    }

    @Override
    public 下拉菜单 置上填充(Object $填充) {
        视图实现.置上填充(this, $填充);
        return this;
    }

    @Override
    public 下拉菜单 置下填充(Object $填充) {
        视图实现.置下填充(this, $填充);
        return this;
    }

    @Override
    public 下拉菜单 置左填充(Object $填充) {
        视图实现.置左填充(this, $填充);
        return this;
    }

    @Override
    public 下拉菜单 置右填充(Object $填充) {
        视图实现.置右填充(this, $填充);
        return this;
    }

    @Override
    public 下拉菜单 置背景(Object $背景) {
        视图实现.置背景(this, $背景);
        return this;
    }

    @Override
    public 下拉菜单 置背景颜色(Object $颜色) {
        视图实现.置背景颜色(this, $颜色);
        return this;
    }

    
    
}

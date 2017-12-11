package 放课后乐园部.视图;

import android.app.*;
import android.content.*;
import android.view.*;
import android.widget.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.视图.实现.*;

public class 菜单布局 extends SlidingLayout implements 基本视图 {

    public 菜单布局(Context $上下文) {
        super($上下文);
        视图实现.初始化控件(this);
        置主题("默认");
    }
    
    

    @Override
    public 菜单布局 置布局重力(String $重力) {
        视图实现.置布局重力(this,$重力);
        return this;
    }

    @Override
    public 菜单布局 置布局权重(float $权重) {
        视图实现.置布局权重(this,$权重);
        return this;
    }
    public 菜单布局 加入子元素(View $子元素) {
        布局实现.加入子元素(this, $子元素);
        return this;
    }

    public View 取子元素从标签(Object $标签) {
        return 布局实现.取子元素从标签(this, $标签);
    }

    public View 取子元素从键值(int $键值) {
        return 布局实现.取子元素从键值(this, $键值);
    }

    public View[] 取所有子元素() {
        return 布局实现.取所有子元素(this);
    }


    public 菜单布局 打开菜单() {
        openMenu();
        return this;
    }

    public 菜单布局 关闭菜单() {
        closeMenu();
        return this;
    }

    public 菜单布局 切换状态() {
        toggle();
        return this;
    }

    public boolean 是否打开() {
        return isOpen;
    }

    @Override
    public 菜单布局 加入到(ViewGroup $布局) {
        视图实现.加入到(this, $布局);
        return this;
    }

    @Override
    public 菜单布局 打开(Activity $界面) {
        视图实现.打开(this, $界面);
        return this;
    }

    @Override
    public 菜单布局 置标签(Object $标签) {
        视图实现.置标签(this, $标签);
        return this;
    }

    @Override
    public Object 取标签() {
        return 视图实现.取标签(this);
    }

    @Override
    public 菜单布局 置主题(String $主题) {
        视图实现.置主题(this, $主题);
        return this;
    }

    @Override
    public 菜单布局 置单击事件(通用方法 $事件) {
        视图实现.置单击事件(this, $事件);
        return this;
    }

    @Override
    public 菜单布局 置长按事件(通用方法 $事件) {
        视图实现.置长按事件(this, $事件);
        return this;
    }

    @Override
    public 菜单布局 置触摸事件(通用方法 $事件) {
        视图实现.置触摸事件(this, $事件);
        return this;
    }

    @Override
    public 菜单布局 置宽度(Object $宽度) {
        视图实现.置宽度(this, $宽度);
        return this;
    }

    @Override
    public 菜单布局 置高度(Object $高度) {
        视图实现.置高度(this, $高度);
        return this;
    }

    @Override
    public 菜单布局 置状态(String $状态) {
        视图实现.置状态(this, $状态);
        return this;
    }

    @Override
    public String 取状态() {
        return 视图实现.取状态(this);
    }

    @Override
    public 菜单布局 显示() {
        视图实现.显示(this);
        return this;
    }

    @Override
    public 菜单布局 占位() {
        视图实现.占位(this);
        return this;
    }

    @Override
    public 菜单布局 隐藏() {
        视图实现.隐藏(this);
        return this;
    }

    @Override
    public 菜单布局 置边距(Object $边距) {
        视图实现.置边距(this, $边距);
        return this;
    }

    @Override
    public 菜单布局 置边距(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置边距(this, $上, $下, $左, $右);
        return this;
    }

    @Override
    public 菜单布局 置上边距(Object $边距) {
        视图实现.置上边距(this, $边距);
        return this;
    }

    @Override
    public 菜单布局 置下边距(Object $边距) {
        视图实现.置下边距(this, $边距);
        return this;
    }

    @Override
    public 菜单布局 置左边距(Object $边距) {
        视图实现.置左边距(this, $边距);
        return this;
    }

    @Override
    public 菜单布局 置右边距(Object $边距) {
        视图实现.置右边距(this, $边距);
        return this;
    }

    @Override
    public 菜单布局 置填充(Object $填充) {
        视图实现.置填充(this, $填充);
        return this;
    }

    @Override
    public 菜单布局 置填充(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置填充(this, $上, $下, $左, $右);
        return this;
    }

    @Override
    public 菜单布局 置上填充(Object $填充) {
        视图实现.置上填充(this, $填充);
        return this;
    }

    @Override
    public 菜单布局 置下填充(Object $填充) {
        视图实现.置下填充(this, $填充);
        return this;
    }

    @Override
    public 菜单布局 置左填充(Object $填充) {
        视图实现.置左填充(this, $填充);
        return this;
    }

    @Override
    public 菜单布局 置右填充(Object $填充) {
        视图实现.置右填充(this, $填充);
        return this;
    }

    @Override
    public 菜单布局 置背景(Object $背景) {
        视图实现.置背景(this, $背景);
        return this;
    }

    @Override
    public 菜单布局 置背景颜色(Object $颜色) {
        视图实现.置背景颜色(this, $颜色);
        return this;
    }

}

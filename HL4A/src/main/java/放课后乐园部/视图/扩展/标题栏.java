package 放课后乐园部.视图.扩展;

import android.app.*;
import android.content.*;
import android.view.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.视图.实现.*;

public class 标题栏 extends 线性布局 {

    public 文本控件 标题对象;
    public 线性布局 左按钮栏;
    public 线性布局 右按钮栏;

    Context 上下文;
    
    public 标题栏(Context $上下文) {
        this($上下文, "");
    }

    public 标题栏(Context $上下文,String $标题内容) {
        super($上下文);

        上下文 = $上下文;
        
        置方向("水平");
        置高度("56dp");
        置重力("中间垂直");
        置背景颜色(主题.基本色());

        左按钮栏 = new 线性布局(上下文)
        .置宽度("自动")
        .加入到(this);
        
        标题对象 = new 文本控件(上下文)
            .置文本大小(主题.大文本())
            .置文本($标题内容)
            .置文本颜色(颜色.白色)
            .置左填充("16dp")
            .加入到(this);

        右按钮栏 = new 线性布局(上下文)
            .置高度("56dp")
            .置方向("水平")
            .置重力("右边")
            .加入到(this);

    }

    public 标题栏 切换() {
        标题对象.置文本颜色(主题.基本色());
        置背景(颜色.白色);
        return this;
    }

    public String 取标题() {
        return 标题对象.取文本();
    }

    public 标题栏 置标题(String $内容) {
        标题对象.置文本($内容);
        return this;
    }

    public 线性按钮 左按钮(通用方法 $事件) {
        线性按钮 $按钮 = new 线性按钮(上下文,"图片.菜单");
        $按钮.加入到(左按钮栏).置单击事件($事件);
        return $按钮;
    }

    public 线性按钮 左按钮(String $图片,通用方法 $事件) {
        线性按钮 $按钮 = new 线性按钮(上下文,$图片);
        $按钮.加入到(左按钮栏).置单击事件($事件);
        return $按钮;
    }

    public 线性按钮 右按钮(通用方法 $事件) {
        线性按钮 $按钮 = new 线性按钮(上下文,"图片.更多");
        $按钮.加入到(右按钮栏).置单击事件($事件);
        return $按钮;
    }

    public 线性按钮 右按钮(String $图片,通用方法 $事件) {
        线性按钮 $按钮 = new 线性按钮(上下文,$图片);
        $按钮.加入到(右按钮栏).置单击事件($事件);
        return $按钮;
    }
    

    @Override
    public 标题栏 置布局重力(String $重力) {
        视图实现.置布局重力(this, $重力);
        return this;
    }

    @Override
    public 标题栏 置布局权重(float $权重) {
        视图实现.置布局权重(this, $权重);
        return this;
    }

    // 布局实现

    public 标题栏 置重力(String $重力) {
        布局实现.置重力(this, $重力);
        return this;
    }

    public 标题栏 置方向(String $方向) {
        布局实现.置方向(this, $方向);
        return this;
    }

    public 标题栏 加入子元素(View $子元素) {
        布局实现.加入子元素(this, $子元素);
        return this;
    }

    public View 取子元素(Object $标签) {
        return 布局实现.取子元素(this, $标签);
    }

    public View 取子元素(int $键值) {
        return 布局实现.取子元素(this, $键值);
    }

    public View[] 取所有子元素() {
        return 布局实现.取所有子元素(this);
    }

    // 视图实现

    @Override
    public 标题栏 加入到(ViewGroup $布局) {
        视图实现.加入到(this, $布局);
        return this;
    }

    @Override
    public 标题栏 打开(Activity $界面) {
        视图实现.打开(this, $界面);
        return this;
    }

    @Override
    public 标题栏 置标签(Object $标签) {
        视图实现.置标签(this, $标签);
        return this;
    }

    @Override
    public Object 取标签() {
        return 视图实现.取标签(this);
    }

    @Override
    public 标题栏 置单击事件(通用方法 $事件) {
        视图实现.置单击事件(this, $事件);
        return this;
    }

    @Override
    public 标题栏 置长按事件(通用方法 $事件) {
        视图实现.置长按事件(this, $事件);
        return this;
    }

    @Override
    public 标题栏 置触摸事件(通用方法 $事件) {
        视图实现.置触摸事件(this, $事件);
        return this;
    }

    @Override
    public 标题栏 置宽度(Object $宽度) {
        视图实现.置宽度(this, $宽度);
        return this;
    }

    @Override
    public 标题栏 置高度(Object $高度) {
        视图实现.置高度(this, $高度);
        return this;
    }

    @Override
    public 标题栏 置状态(String $状态) {
        视图实现.置状态(this, $状态);
        return this;
    }

    @Override
    public String 取状态() {
        return 视图实现.取状态(this);
    }

    @Override
    public 标题栏 显示() {
        视图实现.显示(this);
        return this;
    }

    @Override
    public 标题栏 占位() {
        视图实现.占位(this);
        return this;
    }

    @Override
    public 标题栏 隐藏() {
        视图实现.隐藏(this);
        return this;
    }

    @Override
    public 标题栏 置边距(Object $边距) {
        视图实现.置边距(this, $边距);
        return this;
    }

    @Override
    public 标题栏 置边距(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置边距(this, $上, $下, $左, $右);
        return this;
    }

    @Override
    public 标题栏 置上边距(Object $边距) {
        视图实现.置上边距(this, $边距);
        return this;
    }

    @Override
    public 标题栏 置下边距(Object $边距) {
        视图实现.置下边距(this, $边距);
        return this;
    }

    @Override
    public 标题栏 置左边距(Object $边距) {
        视图实现.置左边距(this, $边距);
        return this;
    }

    @Override
    public 标题栏 置右边距(Object $边距) {
        视图实现.置右边距(this, $边距);
        return this;
    }

    @Override
    public 标题栏 置填充(Object $填充) {
        视图实现.置填充(this, $填充);
        return this;
    }

    @Override
    public 标题栏 置填充(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置填充(this, $上, $下, $左, $右);
        return this;
    }

    @Override
    public 标题栏 置上填充(Object $填充) {
        视图实现.置上填充(this, $填充);
        return this;
    }

    @Override
    public 标题栏 置下填充(Object $填充) {
        视图实现.置下填充(this, $填充);
        return this;
    }

    @Override
    public 标题栏 置左填充(Object $填充) {
        视图实现.置左填充(this, $填充);
        return this;
    }

    @Override
    public 标题栏 置右填充(Object $填充) {
        视图实现.置右填充(this, $填充);
        return this;
    }

    @Override
    public 标题栏 置背景(Object $背景) {
        视图实现.置背景(this, $背景);
        return this;
    }

    @Override
    public 标题栏 置背景颜色(Object $颜色) {
        视图实现.置背景颜色(this, $颜色);
        return this;
    }



}

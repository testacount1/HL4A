package 放课后乐园部.视图.扩展;

import android.content.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.事件.*;

public class 标题栏 extends 线性布局 {

    public 文本控件 标题对象;
    public 线性按钮 左按钮对象;
    public 线性按钮 右按钮对象;

    public 标题栏(Context $上下文) {
        this($上下文, "");
    }

    public 标题栏(Context $上下文,String $标题内容) {
        super($上下文);

        this
            .置宽度("最大")
            .置高度("56dp")
            .置重力("中间垂直")
            .置背景颜色(主题.标题栏());

        左按钮对象 = new 线性按钮($上下文, "@assets/icon/ic_menu.png");
        左按钮对象.隐藏().加入到(this);

        标题对象 = new 文本控件($上下文)
            .置主题("标题")
            .置文本($标题内容)
            .置左填充("16dp")
            .加入到(this);

        右按钮对象 = new 线性按钮($上下文,"@assets/icon/ic_more.png");
            
        new 线性布局($上下文)
            .置宽度("最大")
            .置高度("56dp")
            .置方向("水平")
            .置重力("右边")
            .加入子元素(右按钮对象.隐藏())
            .加入到(this);

    }
    
    public 标题栏 切换() {
        标题对象.置文本颜色(主题.文字());
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

    public 标题栏 左按钮(通用方法 $事件) {
        左按钮对象.显示().置单击事件($事件);
        return this;
    }
    
    public 标题栏 左按钮(String $图片,通用方法 $事件) {
        左按钮对象.图片.置图片($图片);
        左按钮对象.显示().置单击事件($事件);
        return this;
    }
    
    public 标题栏 右按钮(通用方法 $事件) {
        右按钮对象.显示().置单击事件($事件);
        return this;
    }
    
    public 标题栏 右按钮(String $图片,通用方法 $事件) {
        右按钮对象.图片.置图片($图片);
        右按钮对象.显示().置单击事件($事件);
        return this;
    }


}

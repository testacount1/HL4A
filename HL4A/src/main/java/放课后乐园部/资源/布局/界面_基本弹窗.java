package 放课后乐园部.资源.布局;

import android.content.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.视图.扩展.*;
import android.view.*;
import 放课后乐园部.基本.*;

public class 界面_基本弹窗 extends 线性布局 {

    public 标题栏 标题对象;
    public 线性布局 内容底层;
    public View 内容布局;
    public 线性布局 操作布局;

    public 界面_基本弹窗(Context $上下文,String $标题,Object $内容) {

        super($上下文);
        置填充("24dp");
        置宽度("最大");
        置高度("最大");
        置方向("垂直");

        标题对象 = new 标题栏($上下文);
        标题对象
            .切换()
            .置标题($标题)
            .加入到(this);

        内容底层 = new 线性布局($上下文)
            .置背景(颜色.白色)
            .置下填充("4dp")
            .置左填充("19dp")
            .置右填充("16dp")
            .加入到(new 滚动视图($上下文)
                 .置宽度("最大")
                 .置高度("最大")
                 .加入到(this));

        if ($内容 == null) $内容 = "null";

        if ($内容 instanceof View) {
            内容布局 = (View)$内容;
        } else {
            内容布局 = new 文本控件($上下文)
                .置文本($内容.toString());
        }

        内容底层.加入子元素(内容布局);

        操作布局 = new 线性布局($上下文)
            .置方向("水平")
            .置高度("45dp")
            .置重力("右边")
            .置填充("4dp")
            .置背景(颜色.白色)
            .加入到(this)
            .隐藏();

    }

} 

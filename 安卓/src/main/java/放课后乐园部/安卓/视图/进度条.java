package 放课后乐园部.安卓.视图;

import android.app.*;
import android.content.*;
import android.view.*;
import android.widget.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.安卓.视图.实现.*;
import 放课后乐园部.安卓.工具.*;

public class 进度条 extends ProgressBar implements 基本视图 {

    public 进度条(Context $上下文) {
        this($上下文, android.R.attr.progressBarStyleHorizontal);
    }

    public 进度条(ViewGroup $父视图) {
        this($父视图.getContext());
        置宽度("最大");
        加入到($父视图);
    }

    public 进度条(Context $上下文,int $主题) {
        super($上下文, null, $主题);
        视图实现.初始化控件(this);
        置颜色(主题工具.取主题颜色().取控件色());
    }

    public void 置自动(boolean $状态) {
        setIndeterminate($状态);
    }

    public void 置颜色(Object $颜色) {
        if (设备工具.取SDK() > 23) {
            setProgressTintList(视图工具.创建单颜色列表(主题工具.取主题颜色().取控件色()));
            setIndeterminateTintList(视图工具.创建单颜色列表(主题工具.取主题颜色().取控件色()));
        }
    }

    @Override
    public void 置布局重力(String $重力) {
        视图实现.置布局重力(this, $重力);
    }

    @Override
    public void 置布局权重(float $权重) {
        视图实现.置布局权重(this, $权重);
    }

    //进度条实现


    public void 置进度(int $进度) {
        进度条实现.置进度(this, $进度);
    }


    public void 置二级进度(int $进度) {
        进度条实现.置二级进度(this, $进度);
    }


    public void 置进度颜色(Object $颜色) {
        进度条实现.置进度颜色(this, $颜色);
    }


    public int 取进度() {
        return 进度条实现.取进度(this);
    }


    public int 取二级进度() {
        return 进度条实现.取二级进度(this);
    }

    //视图实现

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

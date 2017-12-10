package 放课后乐园部.视图;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.util.*;
import android.view.*;
import android.webkit.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.视图.实现.*;

public class 浏览器 extends WebView implements 基本视图 {

    public WebSettings 设置;

    public 浏览器(Context $上下文) {
        super($上下文);
        视图实现.初始化控件(this);
        置主题("默认");
        设置 = getSettings();
        设置.setJavaScriptEnabled(true);
        设置.setJavaScriptCanOpenWindowsAutomatically(true);
        设置.setDisplayZoomControls(true);
        设置.setSupportZoom(true);
        setWebViewClient(new 浏览器实例());
    }

    public 浏览器 置网址(String $地址) {
        loadUrl($地址);
        return this;
    }

    public String 取网址() {
        return getUrl();
    }

    通用方法 加载开始事件;
    通用方法 加载完成事件;
    通用方法 加载错误事件;
    
    class 浏览器实例 extends WebViewClient {

        @Override
        public void onReceivedError(WebView $视图,int $错误码,String $描述,String $链接) {
            调用方法.事件(加载错误事件,(浏览器)$视图,$错误码,$描述,$链接);
        }

        public void onPageStarted(WebView $视图,String $链接,Bitmap $图标) {
            super.onPageStarted($视图, $链接, $图标);
            调用方法.事件(加载开始事件,(浏览器)$视图,$链接,$图标);
        }

        public void onPageFinished(WebView $视图,String $链接) {
            super.onPageFinished($视图, $链接);
            调用方法.事件(加载完成事件,(浏览器)$视图,$链接);
        }

    }

    @Override
    public 浏览器 加入到(ViewGroup $布局) {
        视图实现.加入到(this, $布局);
        return this;
    }

    @Override
    public 浏览器 打开(Activity $界面) {
        视图实现.打开(this, $界面);
        return this;
    }

    @Override
    public 浏览器 置标签(Object $标签) {
        视图实现.置标签(this, $标签);
        return this;
    }

    @Override
    public Object 取标签() {
        return 视图实现.取标签(this);
    }

    @Override
    public 浏览器 置主题(String $主题) {
        视图实现.置主题(this, $主题);
        return this;
    }

    @Override
    public 浏览器 置单击事件(通用方法 $事件) {
        视图实现.置单击事件(this, $事件);
        return this;
    }

    @Override
    public 浏览器 置长按事件(通用方法 $事件) {
        视图实现.置长按事件(this, $事件);
        return this;
    }

    @Override
    public 浏览器 置触摸事件(通用方法 $事件) {
        视图实现.置触摸事件(this, $事件);
        return this;
    }

    @Override
    public 浏览器 置宽度(Object $宽度) {
        视图实现.置宽度(this, $宽度);
        return this;
    }

    @Override
    public 浏览器 置高度(Object $高度) {
        视图实现.置高度(this, $高度);
        return this;
    }

    @Override
    public 浏览器 置状态(String $状态) {
        视图实现.置状态(this, $状态);
        return this;
    }

    @Override
    public String 取状态() {
        return 视图实现.取状态(this);
    }

    @Override
    public 浏览器 显示() {
        视图实现.显示(this);
        return this;
    }

    @Override
    public 浏览器 占位() {
        视图实现.占位(this);
        return this;
    }

    @Override
    public 浏览器 隐藏() {
        视图实现.隐藏(this);
        return this;
    }

    @Override
    public 浏览器 置边距(Object $边距) {
        视图实现.置边距(this, $边距);
        return this;
    }

    @Override
    public 浏览器 置边距(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置边距(this, $上, $下, $左, $右);
        return this;
    }

    @Override
    public 浏览器 置上边距(Object $边距) {
        视图实现.置上边距(this, $边距);
        return this;
    }

    @Override
    public 浏览器 置下边距(Object $边距) {
        视图实现.置下边距(this, $边距);
        return this;
    }

    @Override
    public 浏览器 置左边距(Object $边距) {
        视图实现.置左边距(this, $边距);
        return this;
    }

    @Override
    public 浏览器 置右边距(Object $边距) {
        视图实现.置右边距(this, $边距);
        return this;
    }

    @Override
    public 浏览器 置填充(Object $填充) {
        视图实现.置填充(this, $填充);
        return this;
    }

    @Override
    public 浏览器 置填充(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置填充(this, $上, $下, $左, $右);
        return this;
    }

    @Override
    public 浏览器 置上填充(Object $填充) {
        视图实现.置上填充(this, $填充);
        return this;
    }

    @Override
    public 浏览器 置下填充(Object $填充) {
        视图实现.置下填充(this, $填充);
        return this;
    }

    @Override
    public 浏览器 置左填充(Object $填充) {
        视图实现.置左填充(this, $填充);
        return this;
    }

    @Override
    public 浏览器 置右填充(Object $填充) {
        视图实现.置右填充(this, $填充);
        return this;
    }

    @Override
    public 浏览器 置背景(Object $背景) {
        视图实现.置背景(this, $背景);
        return this;
    }

    @Override
    public 浏览器 置背景颜色(Object $颜色) {
        视图实现.置背景颜色(this, $颜色);
        return this;
    }


}

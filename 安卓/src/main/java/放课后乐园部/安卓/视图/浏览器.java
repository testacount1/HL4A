package 放课后乐园部.安卓.视图;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.view.*;
import android.webkit.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.安卓.视图.实现.*;
import 放课后乐园部.安卓.组件.*;
import 放课后乐园部.工具.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.安卓.弹窗.*;

public class 浏览器 extends WebView implements 基本视图 {

    public WebSettings 设置;

    public 浏览器(Context $上下文) {
        super($上下文);
		if ($上下文 instanceof 基本界面) {
			((基本界面)$上下文).所有浏览器.添加(this);
		}
        视图实现.初始化控件(this);
        置宽度("最大");
        置高度("最大");
        设置 = getSettings();
        设置.setJavaScriptEnabled(true);
        设置.setJavaScriptCanOpenWindowsAutomatically(true);
        设置.setDisplayZoomControls(true);
        设置.setSupportZoom(true);
        setWebViewClient(new 浏览器实例());
		setWebChromeClient(new Chrome实例());
		addJavascriptInterface(new JS置源码(),"$__置源码");
    }

	@Override
    public boolean onKeyDown(int keyCode,KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && canGoBack()) {
            goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public 浏览器(ViewGroup $父视图) {
        this($父视图.getContext());
        加入到($父视图);
    }

    @Override
    public void 置布局重力(String $重力) {
        视图实现.置布局重力(this, $重力);
    }

    @Override
    public void 置布局权重(float $权重) {
        视图实现.置布局权重(this, $权重);
    }

    public void 置网址(String $地址) {
        loadUrl($地址);
    }

    public String 取网址() {
        return getUrl();
    }
	
	public String 取源码() {
		return 源码;
	}
	
	public void 置源码(String $源码) {
		loadData($源码, "text/html", "UTF-8");
		源码 = $源码;
	}
	
	public String 取标题() {
		
		return getTitle();
	}

    public 通用方法 加载开始事件;
    public 通用方法 加载完成事件;
    public 通用方法 加载错误事件;
	
	private String 源码;

    class 浏览器实例 extends WebViewClient {

        @Override
        public void onReceivedError(WebView $视图,int $错误码,String $描述,String $链接) {
            调用方法.事件(加载错误事件, (浏览器)$视图, $错误码, $描述, $链接);
        }

		@Override
        public void onPageStarted(WebView $视图,String $链接,Bitmap $图标) {
            super.onPageStarted($视图, $链接, $图标);
            调用方法.事件(加载开始事件, (浏览器)$视图, $链接, $图标);
        }

		@Override
        public void onPageFinished(WebView $视图,String $链接) {
            super.onPageFinished($视图, $链接);
			loadUrl("javascript:window.$__置源码.置源码('<head>'+" +
                    "document.getElementsByTagName('html')[0].innerHTML+'</head>');");
            调用方法.事件(加载完成事件, (浏览器)$视图, $链接);
        }

		@Override
		public boolean shouldOverrideUrlLoading(WebView $视图,String $链接) {
			if (字符工具.以开始($链接, "http") || 字符工具.以开始($链接, "file")) {
				$视图.loadUrl($链接);
				return true;
			} else {
				链接工具.打开($链接);
				return false;
			}
		}

    }

	class Chrome实例 extends WebChromeClient {

		@Override
		public boolean onJsAlert(WebView $视图,String $链接,String $信息,final JsResult $返回) {
			基本弹窗 $弹窗 = new 基本弹窗(getContext());
			$弹窗.置标题("来自网页的提示");
			$弹窗.置内容($信息);
			$弹窗.置右按钮("确定", $弹窗.隐藏);
			$弹窗.setOnDismissListener(new DialogInterface.OnDismissListener(){
					@Override
					public void onDismiss(DialogInterface $弹窗) {
						$返回.cancel();
					}
				});
			$弹窗.显示();
			return true;
		}

	}
	
	class JS置源码 {
		
		@JavascriptInterface
		public void 置源码(String $源码) {
			源码 = $源码;
		}
		
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

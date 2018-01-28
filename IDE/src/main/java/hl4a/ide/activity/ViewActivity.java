package hl4a.ide.activity;

import 放课后乐园部.安卓.组件.*;
import android.os.*;
import android.content.*;
import 放课后乐园部.安卓.资源.布局.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.安卓.视图.*;

public class ViewActivity extends 基本界面 {

    @Override
    public void 界面创建事件(Bundle $恢复) {
        String $标题 = (String)传入参数[0];
        String $内容 = (String)传入参数[1];
        布局_滚动界面 $布局 = new 布局_滚动界面(this);
        $布局.标题.置标题($标题);
        $布局.底层.置填充(主题工具.取默认填充());
        文本视图 $文本 = new 文本视图($布局.底层);
        $文本.置文本($内容);
        打开布局($布局);
    }

    @Override
    public Boolean 返回按下事件() {
        结束界面();
        return true;
    }

}

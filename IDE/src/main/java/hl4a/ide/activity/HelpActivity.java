package hl4a.ide.activity;

import android.os.*;
import hl4a.ide.layout.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.安卓.组件.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.资源.布局.*;
import 放课后乐园部.安卓.视图.适配器.*;
import 放课后乐园部.工具.*;
import java.io.*;
import 放课后乐园部.收集.*;

public class HelpActivity extends 基本界面 {

    public String 地址 = "$帮助";
    public 布局_帮助文档 布局;
    public 数组适配器 适配器;

    @Override
    public void 界面创建事件(Bundle $恢复) {
        布局 = new 布局_帮助文档(this);
        集合<String> $显示 = new 集合<>();
        File[] $所有 = 文件工具.取文件列表(地址);
        for (File $单个 : $所有) {
            String $名称 = 文件工具.取前缀($单个.getPath());
            $显示.添加($名称);
        }
        适配器 = new 数组适配器(this, $显示.toArray(new String[$显示.数量()]));
        布局.列表.置适配器(适配器);
        布局.列表.置项目单击事件($列表单击);
        打开布局(布局);
    }

    通用方法 $列表单击 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            String $内容 = ((布局_适配器_数组)$参数[1]).文本.取文本();
            跳转界面(ViewActivity.class, $内容, 字符工具.读取(地址 + "/" + $内容 + ".txt"));
            return null;
        }
    };

    @Override
    public Boolean 返回按下事件() {
        结束界面();
        return true;
    }

}


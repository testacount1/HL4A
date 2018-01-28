package hl4a.ide;

import android.os.*;
import hl4a.ide.activity.*;
import 放课后乐园部.安卓.组件.*;
import 放课后乐园部.安卓.资源.布局.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.工具.*;
import android.content.*;
import java.io.*;
import java.net.*;
import 放课后乐园部.线程.*;
import 放课后乐园部.事件.*;
import hl4a.ide.util.*;
import android.net.*;
import 放课后乐园部.压缩.*;

public class LaunchPad extends 基本界面 {

    @Override
    public void 界面创建事件(Bundle $恢复) {
        打开布局(new 布局_初始化(this));
        请求权限();
    }

    @Override
    public void 权限回调事件() {
        final Uri 文件 = getIntent().getData();
        new 线程<Object>(new 通用方法<Object>() {
                @Override
                public Object 调用(Object[] $参数) {
                    Uri $文件 = 文件;
                    if ($文件 != null) {
                        if (文件工具.是文件($文件.getPath())) {
                            跳转界面(MainActivity.class,$文件.getPath());
                            结束界面();
                            return null;
                        }
                    }
                    // if (!文件工具.是目录("$帮助")) {
                    ZIP工具.解压(应用工具.取安装包位置(),"assets/help.zip","$cache/帮助.zip");
                    ZIP工具.解压("$cache/帮助.zip","$帮助");
                    // }
                    跳转界面(MainActivity.class);
                    结束界面();
                    return null;
                }
            }).启动();
    }

}

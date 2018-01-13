package 放课后乐园部.组件;

import android.content.*;
import android.content.pm.*;
import android.os.*;
import android.view.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.视图.扩展.*;
import 放课后乐园部.收集.*;
import 放课后乐园部.资源.布局.*;
import com.lzy.okgo.*;
import okhttp3.*;
import java.util.concurrent.*;

public class 启动界面 extends 基本界面 {

    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);
        打开布局(new 界面_初始化(this));
        按键按下事件 = new 通用方法() {
            @Override
            public Object 调用(Object[] $参数) {
                return null;
            }
        };
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

		new 线程($初始化).启动();

    }

    通用方法 $初始化 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            String $旧 = (String) 设置.读取("APK散列");
            String $当前 = 散列.文件("MD5", 文件.取安装包位置());
            if (!$当前.equals($旧)) {
                文件.删除("@");
                解压.全部(文件.取安装包位置(), "@");
                设置.保存("APK散列", $当前);
            }
            if (权限.检查所有()) {
                初始化成功事件();
            } else {
                权限.请求所有(启动界面.this);
            }
            return null;
        }
    };

	public void 初始化成功事件() {
		跳转脚本("@script/index.js");
        结束();
	}

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		/*
		 for (int i = 0; i < permissions.length; i++) {
		 if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
		 错误.普通("\n\n请授权应用使用权限:\n" + permissions[i] + "\n否则程序无法运行。");
		 }
		 }
		 */
        初始化成功事件();
    }

}

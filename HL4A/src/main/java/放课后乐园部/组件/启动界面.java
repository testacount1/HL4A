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
import android.support.multidexs.*;
import 放课后乐园部.资源.布局.*;
import com.lzy.okgo.*;
import okhttp3.*;
import java.util.concurrent.*;

public class 启动界面 extends 基本界面 {

    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);
        try {
      
            打开布局(new 界面_初始化(this));
            
            

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                new 线程($初始化).启动();
                return;
            }

            按键按下事件 = new 通用方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    return null;
                }
            };

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            if (权限.检查所有() == true) {
                new 线程($初始化).启动();
            }
			else {
                权限.请求所有(this);
            }

        }
		catch (Exception $错误) {
            错误.保存($错误);
        }
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
            MultiDex.install(启动界面.this);
            环境.读取().已初始化 = true;
            OkHttpClient.Builder $工厂 = new OkHttpClient.Builder();
            $工厂.connectTimeout(1,TimeUnit.SECONDS);
            OkGo.getInstance().init(环境.读取())
                .setOkHttpClient($工厂.build());
			初始化成功事件();
			结束();
            return null;
        }
    };

	public void 初始化成功事件() {
		跳转脚本("@script/index.js");
	}

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 0x38:
                for (int i = 0; i < permissions.length; i++) {
                    if (grantResults[i] == PackageManager.PERMISSION_GRANTED)
                        错误.抛出(new Exception("权限错误 应用无法运行:" + permissions[i]));
                }
                new 线程($初始化).启动();
                break;
        }
    }

}

package 放课后乐园部.组件;

import android.content.*;
import android.os.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.资源.布局.*;

public class 启动界面 extends 基本界面 {

    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);
        布局.打开(this, new 界面_初始化(this));
    }

    @Override
    public void onStart() {
        super.onStart();
        new 线程($初始化).启动();
    }

    通用方法 $初始化 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            String $旧 = (String) 设置.读取("APK散列");
            String $当前 = 散列.文件("MD5", 文件.取安装包位置());
            if ($旧.equals($当前)) {
                解压.全部(文件.取安装包位置(), 文件.取数据目录("apk"));
                设置.设置("APK散列", $当前);
            }
            处理.界面(启动界面.this, 跳转);
            return null;
        }
    };

    通用方法 跳转 = new 通用方法() {

        @Override
        public Object 调用(Object[] $参数) {
            Intent 启动 = new Intent(启动界面.this, 反射.取类(应用.取包名() + ".MainActivity"));
            启动.putExtra("参数", 启动界面.this.getIntent().getStringExtra("参数"));
            startActivity(启动);
            finish();
            return null;
        }
    };

}

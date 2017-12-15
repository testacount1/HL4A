package 放课后乐园部.组件;

import android.os.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.视图.扩展.*;

public class 启动界面 extends 基本界面 {

    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);

        线性布局 $底层 = new 线性布局(this)
            .置主题("底层");

        new 标题栏(this, 应用.取应用名() + " - 初始化")
            .置标签("标题栏")
            .加入到($底层);

        线性布局 $布局 = new 线性布局(this)
            .置主题("底层")
            .置高度("自动")
            .置标签("布局")
            .置填充("16dp")
            .置方向("水平")
            .置重力("中间垂直")
            .加入到($底层);

        new 进度条(this)
            .置标签("进度")
            .加入到($布局);

        new 文本控件(this)
            .置标签("文本")
            .置文本("正在初始化 ~ \n这可能需要几分钟的时间。")
            .置左填充("16dp")
            .加入到($布局);

        打开布局($底层);

    }


    @Override
    public void onStart() {
        super.onStart();
        权限.检查($检查成功,$检查失败);
    }

    通用方法 $检查成功 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            new 线程($初始化).启动();
            return null;
        }
    };
    
    通用方法 $检查失败 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            错误.普通(new Exception("权限错误,程序无法运行。"));
            return null;
        }
    };
    
    
    通用方法 $初始化 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            String $旧 = (String) 设置.读取("APK散列");
            String $当前 = 散列.文件("MD5", 文件.取安装包位置());
            if (!$当前.equals($旧)) {
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
            跳转界面("#index.js");
            结束();
            return null;
        }
    };

}

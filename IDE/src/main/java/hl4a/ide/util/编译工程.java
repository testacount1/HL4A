package hl4a.ide.util;

import android.content.*;
import android.net.*;
import java.io.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.压缩.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.安卓.弹窗.*;
import 放课后乐园部.安卓.组件.*;
import 放课后乐园部.安卓.编译.*;
import 放课后乐园部.工具.*;
import 放课后乐园部.线程.*;
import android.os.*;

public class 编译工程 {

    private 基本界面 界面;
    private 工程 工程;

    private 加载中弹窗 弹窗;

    public 编译工程(基本界面 $界面,工程 $工程) {
        界面 = $界面;
        工程 = $工程;
        弹窗 = new 加载中弹窗($界面);
        弹窗.更新("初始化");
    }

    public void 启动() {
        弹窗.显示();
        new 线程($初始化).启动();
    }

    通用方法 $初始化 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            主程序();
            return null;
        }
    };

    public void 主程序() {
        String $编译 = 工程.取地址("编译");
        if (文件工具.是文件($编译)) {
            文件工具.删除($编译);
        }
        String $打包 = 工程.取地址("编译", "打包");
        文件工具.创建目录($打包);
        弹窗.更新("释放打包文件");
        ZIP工具.解压(应用工具.取安装包位置(), $打包);
        File[] $替换 = 文件工具.取文件列表($打包 + "/assets/client");
        for (File $单个 : $替换) {
            文件工具.剪切($单个.getPath(), $打包 + "/" + $单个.getName());
        }
        文件工具.删除($打包 + "/assets");
        弹窗.更新("打包脚本/资源");
        String $脚本 = 工程.取地址("编译", "打包", "lib", "armeabi", "libHL4A.so");
        文件工具.创建文件($脚本);
        ZIP工具.压缩(工程.取地址("源码/"), $脚本);
        字符工具.保存($脚本, 编码工具.Base64.编码(字节工具.读取($脚本)));
        弹窗.更新("编译应用类文件");
        CLASS $应用 = new CLASS(工程.信息.包名 + ".Application", "放课后乐园部.安卓.组件.基本应用", "Application.java");
        $应用.初始化();
        $应用.编译(工程.取地址("编译", "类", 字符工具.替换(工程.信息.包名, ".", "/"), "Application.class"));
        弹窗.更新("编译启动界面");
        CLASS $启动 = new CLASS(工程.信息.包名 + ".LaunchPad", "放课后乐园部.安卓.实例.启动界面", "LaunchPad.java");
        $启动.初始化();
        $启动.编译(工程.取地址("编译", "类", 字符工具.替换(工程.信息.包名, ".", "/"), "LaunchPad.class"));
        弹窗.更新("编译到Dex");
        try {
            int $d = 2;
            /*
             while (文件工具.是文件(工程.取地址("编译", "打包", "classes" + $d + ".dex"))) {
             $d ++;
             }
             */
            String $DEX = 工程.取地址("编译", "打包", "classes" + $d + ".dex");
            文件工具.删除($DEX);
            DEX.多个($DEX, 工程.取地址("编译", "类"));
        } catch (IOException $错误) {
            提示工具.普通($错误);
            return;
        }
        弹窗.更新("检查图标资源");
        String $图标 = 工程.取地址("图标.png");
        if (文件工具.是文件($图标)) {
            文件工具.复制($图标, 工程.取地址("编译", "打包", "res", "drawable", "icon.png"));
        }
        弹窗.更新("编译清单文件");
        APK $签名 = new APK($打包);
        final String $APK = $签名.初始化(工程.信息.包名);
        if (文件工具.是否存在($APK)) {
            文件工具.删除($APK);
        }
        $签名.置工程名(工程.信息.工程名);
        $签名.置版本号(工程.信息.版本号);
        $签名.置版本名(工程.信息.版本名);
        $签名.编译清单();
        弹窗.更新("编译资源");
        $签名.编译资源();
        弹窗.更新("打包签名");
        $签名.打包签名();
        文件工具.删除($编译);
        处理工具.主线程(new 通用方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    弹窗.隐藏();
                    提示工具.普通("打包成功 ~\n存放在: " + $APK);
                    安卓文件.打开($APK);
                    return null;
                }
            });
    }

}

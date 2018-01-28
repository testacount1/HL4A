package hl4a.ide.activity;

import android.content.*;
import android.os.*;
import hl4a.ide.layout.*;
import hl4a.ide.util.*;
import java.lang.reflect.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.安卓.弹窗.*;
import 放课后乐园部.安卓.组件.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.资源.*;
import 放课后乐园部.工具.*;
import 放课后乐园部.收集.*;
import 放课后乐园部.安卓.编译.*;
import 放课后乐园部.压缩.*;

public class ProjActivity extends 基本界面 {

    布局_工程管理 布局;
    String 地址;
    工程 当前;
    基本弹窗 设置;
    基本弹窗 删除;
    布局_设置弹窗 内容;
    哈希表 所有 = new 哈希表();
    基本弹窗 协议;

    @Override
    public void 界面回调事件(int $请求码,int $返回码,Intent $意图) {
        if ($返回码 == 233) {
            结束界面();
        }
    }

    @Override
    public void 结束界面(Exception $错误) {
        //super.结束界面($错误);
    }

    public boolean 检查() {
        if (!文件工具.是文件(当前.取地址("应用.json"))) {
            提示工具.警告("工程已损坏!");
            结束界面();
            return true;
        }
        return false;
    }
    @Override
    public void 界面刷新事件() {
        检查();
    }

    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);
        地址 = (String)传入参数[0];
        if (!工程.检查(地址)) {
            提示工具.警告("工程已损坏!");
            结束界面();
        }
        当前 = 工程.读取(地址);
        布局 = new 布局_工程管理(this);
        布局.标题.左按钮(图标.返回, 界面结束);
        打开布局(布局);
        创建设置("工程名", "包名", "版本名", "版本号");
        内容 = new 布局_设置弹窗(this);
        设置 = new 基本弹窗(this);
        设置.置内容(内容);
        设置.置中按钮("取消", 设置.隐藏);
        删除 = new 基本弹窗(this);
        删除.置标题("删除工程");
        删除.置内容("真的要删除 " + 当前.信息.工程名 + " 吗？");
        删除.置中按钮("取消", 删除.隐藏);
        删除.置右按钮("删除", 直接删除);
        协议 = new 基本弹窗(this);
        协议.置标题("自由软件协议");
        协议.置内容("HL4A项目 基于GNU通用公共授权第三版\n您必须同意并在项目使用\nGNU公共授权才能制作独立应用");
        协议.置左按钮("详细", 详细协议);
        协议.置中按钮("拒绝", 协议.隐藏);
        协议.置右按钮("同意", 打包APK);
        //创建按钮("编辑权限").置单击事件(直接运行);
        创建按钮("直接运行").置单击事件(直接运行);
        创建按钮("进入编辑").置单击事件(进入编辑);
        创建按钮("打包HPK").置单击事件(打包HPK);
        创建按钮("打包APK").置单击事件(协议.显示);
        创建按钮("删除工程").置单击事件(删除工程);
    }

    通用方法 详细协议 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            链接工具.打开("http://www.gnu.org/licenses/gpl-3.0.html");
            return null;
        }


    };

    通用方法 直接运行 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            if (检查()) return null;
            String $入口 = 当前.取地址("源码", "入口.js");
            if (!文件工具.是文件($入口)) {
                提示工具.普通("没有入口文件 ！");
            } else {
                跳转脚本($入口);
            }
            return null;
        }
    };

    通用方法 打包HPK = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            if (检查()) return null;
            String $输出 = 文件工具.取目录(当前.取地址()) + "/" + 当前.信息.工程名 + ".hpk";
            ZIP工具.压缩(当前.取地址(), $输出);
            字符工具.保存($输出, 编码工具.Base64.编码(字节工具.读取($输出)));
            提示工具.普通("打包成功 ~ \n保存到 :" + $输出);
            return null;
        }
    };

    通用方法 打包APK = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            if (检查()) return null;
            协议.隐藏();
            if (!工程.检查包名(当前.信息.包名)) {
                内容.类型 = "包名";
                设置.置标题("包名不符合规范");
                内容.编辑.置默认文本("新的包名");
                设置.置右按钮("打包", 更改打包);
                设置.显示();
                return null;
            }
            new 编译工程(ProjActivity.this, 当前).启动();
            return null;
        }
    };

    通用方法 删除工程 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            删除.显示();
            return null;
        }
    };

    通用方法 直接删除 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            if (检查())return null;
            文件工具.删除(当前.取地址());
            提示工具.普通("删除成功 ！");
            删除.隐藏();
            结束界面();
            return null;
        }
    };


    通用方法 进入编辑 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            if (检查())return null;
            跳转界面(666, EditActivity.class, 当前.地址);
            return null;
        }
    };

    通用方法 更改打包 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            if (更改设置.调用() == null) return null;
                打包APK.调用();
           
            return null;
        }
    };

    通用方法 更改设置 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            if (检查())return null;
            String $内容 = 内容.编辑.取文本();
            String $类型 = 内容.类型;
            String $原内容 = (String)反射工具.取变量(当前.信息, $类型);
            if ("".equals($内容)) {
                提示工具.警告("请不要留空 ~");
                return null;
            } else if ($类型 == "包名") {
                if (!工程.检查包名($内容)) {
                    return null;
                } else if (工程.检查($内容)) {
                    提示工具.警告("该包名已存在 ~");
                    return null;
                }
                if (!工程.移动($原内容, $内容)) {
                    提示工具.警告("移动失败 未知错误!");
                    return null;
                }
                地址 = $内容;
                当前.地址 = $内容;
            } else {
                提示工具.普通("更改成功 ~");
            }
            ((文本视图)所有.读取($类型)).置文本($内容);
            反射工具.置变量(当前.信息, $类型, $内容);
            当前.保存();
            设置.隐藏();
            return 233;
        }
    };

    通用方法 界面结束 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            结束界面();
            return null;
        }
    };

    通用方法 启动设置 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            if (检查())return null;
            线性布局 $按钮 = (线性布局)$参数[0];
            文本视图 $文本 = (文本视图)$按钮.取子元素("文本");
            文本视图 $内容 = (文本视图)$按钮.取子元素("内容");
            内容.类型 = $文本.取文本();
            内容.编辑.置文本($内容.取文本());
            内容.编辑.置默认文本("请输入新" + 内容.类型);
            设置.置标题("更改" + $文本.取文本());
            设置.置右按钮("更改", 更改设置);
            设置.显示();
            return null;
        }
    };

    public void 创建设置(String... $所有) {
        for (String $设置 :$所有) {
            线性布局 $按钮 = new 线性布局(布局.底层);
            $按钮.置高度("自动");
            $按钮.置背景("透明");
            $按钮.置方向("水平");
            $按钮.置重力("中间垂直");
            $按钮.置单击事件(启动设置);
            $按钮.置填充("16dp", "16dp", "16dp", "16dp");
            文本视图 $文本 = new 文本视图($按钮);
            $文本.置文本($设置);
            $文本.置标签("文本");
            线性布局 $布局 = new 线性布局($按钮);
            $布局.置方向("水平");
            $布局.置重力("右边");
            $布局.置高度("自动");
            文本视图 $内容 = new 文本视图($布局);
            $内容.置标签("内容");
            $内容.置文本(反射工具.取变量(当前.信息,$设置).toString());
            所有.设置($设置, $内容);
        }
    }

    public 线性布局 创建按钮(String $名称) {
        线性布局 $按钮 = new 线性布局(布局.底层);
        $按钮.置高度("自动");
        $按钮.置背景("透明");
        $按钮.置方向("水平");
        $按钮.置重力("中间垂直");
        $按钮.置填充("16dp", "16dp", "16dp", 0);
        文本视图 $文本 = new 文本视图($按钮);
        $文本.置文本($名称);
        $文本.置标签("文本");
        return $按钮;
    }



}

package hl4a.ide.adapter;

import android.view.*;
import hl4a.ide.activity.*;
import hl4a.ide.layout.*;
import hl4a.ide.util.*;
import java.io.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.安卓.弹窗.*;
import 放课后乐园部.安卓.组件.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.视图.适配器.*;
import 放课后乐园部.安卓.资源.布局.*;
import 放课后乐园部.工具.*;
import 放课后乐园部.收集.*;

public class 工程适配器 extends 数组适配器 {

    列表视图 列表;
    基本界面 界面;

    布局_新建工程 新建工程布局;

    public 工程适配器(列表视图 $视图) {
        super($视图.getContext(), new 集合());
        界面 = (基本界面)$视图.getContext();
        列表 = $视图;
        更新工程();
        $视图.置适配器(this);
        $视图.置项目单击事件(列表单击);
        新建工程布局 = new 布局_新建工程(界面);
        新建工程 = new 基本弹窗(界面);
        新建工程.置标题("新建工程");
        新建工程.置内容(新建工程布局);
        新建工程.置中按钮("取消", 新建工程.隐藏);
        新建工程.置右按钮("创建", 创建);

    }

    基本弹窗 新建工程;

    通用方法 创建 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            String $包名 = 新建工程布局.包名.取文本();
            String $工程名 = 新建工程布局.工程名.取文本();
            if ("".equals($包名)) {
                提示工具.普通("包名不能为空 ~");
            } else if(!工程.检查包名($包名)) {
            } else if ("".equals($工程名)) {
                提示工具.普通("工程名不能为空 ~");
            } else if (工程.检查($包名)) {
                提示工具.普通("包名已存在 ~");
            } else {
                新建工程布局.工程名.置文本("");
                新建工程布局.包名.置文本("");
                工程.创建($工程名, $包名);
                更新工程();
                新建工程.隐藏();
            }
            return null;
        }
    };

    通用方法 列表单击 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            int $键值 = $参数[2];
            if ($键值 == 0) {
                新建工程.显示();
            } else {
                View $项目 = (View)$参数[1];
                哈希表 $表 = (哈希表)$项目.getTag();
                String $地址 = (String)$表.读取("地址");
                界面.跳转界面(ProjActivity.class, $地址);
            }
            return null;
        }
    };

    public void 更新工程() {
        数据.清空();
        File[] $所有 = 文件工具.取文件列表(工程.工程目录);
        添加项目("新建工程", null);
        for (File $单个 : $所有) {
            if ($单个.isDirectory()) {
                工程 $工程 = 工程.读取($单个.getName());
                if ($工程 != null && $工程.信息 != null) {
                    if (!$单个.getName().equals($工程.信息.包名)) {
                        $工程.信息.包名 = $单个.getName();
                        $工程.保存();
                    }
                    添加项目($工程.信息.工程名,$单个.getName());
                }
            }
        }
        发送重绘事件();
    }


    void 添加项目(String $内容,String $地址) {
        哈希表 $添加 = new 哈希表();
        $添加.设置("内容", $内容);
        $添加.设置("地址", $地址);
        数据.添加($添加);
    }

    @Override
    public View 处理(View $视图,哈希表 $参数) {
        $视图.setTag($参数);
        文本视图 $内容 = ((布局_适配器_数组)$视图).文本;
        $内容.置文本((String)$参数.读取("内容"));
        return $视图;
    }

}

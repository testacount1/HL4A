package 放课后乐园部.组件;

import android.os.*;
import android.support.multidexs.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.组件.*;
import 放课后乐园部.脚本.*;

public class 脚本界面 extends 基本界面 {

    public 基本脚本 当前环境;
    public String 当前目录;
    public String 当前文件;
    public String 当前脚本;

    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);
        if ($数据 != null) {
            MultiDex.install(this);
            当前脚本 = $数据.getString("脚本");
        } else {
            当前脚本 = 文件.检查地址(getIntent().getStringExtra("文件"));
        }
        if (当前脚本 == null || !文件.是文件(当前脚本))
            错误.抛出(new Exception("脚本不存在:" + 当前脚本));
        else {
            当前目录 = 文件.取目录(当前脚本);
            当前文件 = 文件.取名称(当前脚本);
            文件.默认地址 = 当前目录;
        }
        当前环境 = 脚本.取脚本引擎(当前脚本);
        当前环境.压入变量("当前上下文",this);
        当前环境.压入变量("当前界面",this);
        try {
            当前环境.运行文件(当前脚本);
        } catch (Exception $错误) {
            错误.跳转($错误);
        }
    }

    @Override
    public void onRestart() {
        文件.默认地址 = 当前目录;
        super.onRestart();
    }

    @Override
    protected void onSaveInstanceState(Bundle $输出) {
        $输出.putString("脚本", 当前脚本);
        super.onSaveInstanceState($输出);
    }

}

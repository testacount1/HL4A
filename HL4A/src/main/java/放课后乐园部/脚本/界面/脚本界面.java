package 放课后乐园部.脚本.界面;

import 放课后乐园部.组件.基本界面;
import android.os.Bundle;
import 放课后乐园部.基本.文件;
import 放课后乐园部.基本.错误;

public class 脚本界面 extends 基本界面 {

    public String 当前目录;
    public String 当前文件;
    public String 当前脚本;

    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);
        当前脚本 = 文件.检查地址(getIntent().getStringExtra("文件"));
        if (当前脚本 == null || !文件.是文件(当前脚本))
            错误.普通(new Exception("脚本不存在:" + 当前脚本));
        else {
            当前目录 = 文件.取目录(当前脚本);
            当前文件 = 文件.取名称(当前脚本);
            文件.默认地址 = 当前目录;
        }
    }

    @Override
    public void onRestart() {
        文件.默认地址 = 当前目录;
        super.onRestart();
    }



}

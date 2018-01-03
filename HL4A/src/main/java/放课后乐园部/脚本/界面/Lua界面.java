package 放课后乐园部.脚本.界面;

import android.os.Bundle;
import 放课后乐园部.脚本.Lua;
import 放课后乐园部.基本.*;

public class Lua界面 extends 脚本界面 {

    public Lua 当前环境;
    
    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);
        当前环境 = new Lua();
        当前环境.压入变量("当前上下文",this);
        当前环境.压入变量("当前界面",this);
        try {
            当前环境.运行文件(当前脚本);
        } catch (Exception $错误) {
            错误.跳转($错误);
        }
    }
    
}

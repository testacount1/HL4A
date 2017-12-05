package 放课后乐园部.脚本.服务;

import 放课后乐园部.组件.*;
import 放课后乐园部.脚本.*;

public class Lua服务 extends 基本服务 {

    public Lua 当前环境;

	@Override
    public void onCreate() {
        super.onCreate();
        当前环境 = new Lua();
        当前环境.压入变量("当前上下文", this);
        当前环境.压入变量("当前服务", this);
        当前环境.运行文件("service.lua");
    }

}

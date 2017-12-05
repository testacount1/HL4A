package 放课后乐园部.脚本.界面;

import android.content.*;
import android.os.*;
import 放课后乐园部.组件.*;
import 放课后乐园部.脚本.*;

public class JS界面 extends 基本界面 {

    public JavaScript 当前环境;
    
    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);
        当前环境 = new JavaScript();
        当前环境.压入变量("当前上下文",this);
        当前环境.压入变量("当前界面",this);
        当前环境.初始化();
        Intent $意图 = this.getIntent();
        String $文件 = $意图.getStringExtra("文件");
        当前环境.运行文件($文件);
    }
    
}

package 放课后乐园部.脚本.界面;

import android.os.Bundle;
import 放课后乐园部.脚本.JavaScript;

public class JS界面 extends 脚本界面 {

    public JavaScript 当前环境;
    
    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);
        当前环境 = new JavaScript();
        当前环境.压入变量("当前上下文",this);
        当前环境.压入变量("当前界面",this);
        当前环境.运行文件(当前脚本);
    }
    
}

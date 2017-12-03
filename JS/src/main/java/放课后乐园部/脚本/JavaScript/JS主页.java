package 放课后乐园部.脚本.JavaScript;
import android.os.*;
import 放课后乐园部.基本.*;

public class JS主页 extends JS基本界面 {

    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);
        当前环境.运行文件("#index.js");
        界面创建事件($数据);
    }
    
    
}

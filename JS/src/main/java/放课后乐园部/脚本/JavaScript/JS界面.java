package 放课后乐园部.脚本.JavaScript;

import android.content.*;
import android.os.*;

public class JS界面 extends JS基本界面 {

    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);
        Intent $意图 = this.getIntent();
        String $文件 = $意图.getStringExtra("文件");
        当前环境.运行文件($文件);
        界面创建事件($数据);
    }
    
}

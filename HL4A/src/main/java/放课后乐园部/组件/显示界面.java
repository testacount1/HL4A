package 放课后乐园部.组件;

import android.content.*;
import android.os.*;

public class 显示界面 extends 基本界面 {

    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);
        Intent $意图 = getIntent();
        if ($意图.getStringExtra("种类") == "文件") {
            
        }
    }

}

package h.kl.activity;

import 放课后乐园部.组件.*;
import android.os.*;
import h.kl.layout.*;

public class ManageActivity extends 基本界面 {

    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);
        打开布局(new 布局_管理界面(this));
    }
    
}

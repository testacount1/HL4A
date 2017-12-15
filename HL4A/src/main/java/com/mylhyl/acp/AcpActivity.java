package com.mylhyl.acp;

import android.content.*;
import android.os.*;
import android.view.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.组件.*;

public class AcpActivity extends 基本界面 {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        权限.权限界面 = this;
        //不接受触摸屏事件
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        if (savedInstanceState == null)
            Acp.getInstance().getAcpManager().checkRequestPermissionRationale(this);
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Acp.getInstance().getAcpManager().checkRequestPermissionRationale(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Acp.getInstance().getAcpManager().onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        Acp.getInstance().getAcpManager().onActivityResult(requestCode, resultCode, data);
    }
}

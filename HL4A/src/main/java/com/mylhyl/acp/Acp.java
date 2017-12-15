package com.mylhyl.acp;

import android.content.Context;
import 放课后乐园部.基本.*;

/**
 * Created by hupei on 2016/4/26.
 */
public class Acp {

    private static Acp mInstance;
    private AcpManager mAcpManager;

    public static Acp getInstance() {
        if (mInstance == null)
            synchronized (Acp.class) {
                if (mInstance == null) {
                    mInstance = new Acp(环境.读取());
                }
            }
        return mInstance;
    }

    private Acp(Context context) {
        mAcpManager = new AcpManager(context.getApplicationContext());
    }

    /**
     * 开始请求
     *
     * @param options
     * @param acpListener
     */
    public void request(AcpOptions options, AcpListener acpListener) {
        if (options == null) new NullPointerException("AcpOptions is null...");
        if (acpListener == null) new NullPointerException("AcpListener is null...");
        mAcpManager.request(options, acpListener);
    }

    AcpManager getAcpManager() {
        return mAcpManager;
    }
}

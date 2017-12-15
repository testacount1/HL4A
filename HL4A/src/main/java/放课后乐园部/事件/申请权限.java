package 放课后乐园部.事件;

import com.mylhyl.acp.*;
import java.util.*;
import 放课后乐园部.收集.*;

public class 申请权限 implements AcpListener {

    通用方法 成功;
    通用方法 失败;
    
    public 申请权限(通用方法 $成功,通用方法 $失败) {
        成功 = $成功;
        失败 = $失败;
    }
    
    @Override
    public void onGranted() {
        调用方法.事件(成功);
    }

    @Override
    public void onDenied(List<String> permissions) {
        调用方法.事件(失败,(集合)permissions);
    }

}

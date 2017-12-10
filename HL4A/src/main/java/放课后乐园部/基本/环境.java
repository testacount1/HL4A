package 放课后乐园部.基本;

import android.content.*;
import android.app.*;

public class 环境 {

    环境() {}

    static Context 全局上下文;
    static Activity 界面;

    public static void 设置(Context 上下文) {
        全局上下文 = 上下文;
    }
    
    public static Context 读取() {
        return 全局上下文;
    }
    
    public static void 设置界面(Activity 上下文) {
        界面 = 上下文;
    }

    public static Activity 读取界面() {
        return 界面;
    }

}

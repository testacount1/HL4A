package 放课后乐园部.基本;

import android.content.*;
import android.app.*;
import 放课后乐园部.组件.*;

public class 环境 {

    环境() {}

    static 基本应用 全局上下文;

    public static void 设置(基本应用 上下文) {
        全局上下文 = 上下文;
    }
    
    public static 基本应用 读取() {
        return 全局上下文;
    }

}

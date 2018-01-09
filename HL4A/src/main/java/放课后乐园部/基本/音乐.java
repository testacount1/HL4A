package 放课后乐园部.基本;

import 放课后乐园部.组件.*;

public class 音乐 {

    public static void 初始化() {
        try {
            服务.启动(环境.读取(), "MusicService");
        } catch (Exception $错误) {}
    }
    
    public static void 结束() {
        音乐服务.实例.销毁();
    }

}




package 放课后乐园部.组件;

import android.media.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.收集.*;
import java.io.*;

public class 音乐服务 extends 基本服务 {

    public static volatile 音乐服务 实例;
    
    public MediaPlayer 播放器 = new MediaPlayer();

    public void 销毁() {
        stopSelf();
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
        实例 = this;
    }
    
    public void 置音乐(String $地址) {
        try {
            String $音乐 = 文件.检查地址($地址);
            播放器.setDataSource($音乐);
            播放器.prepare();
        }  catch (Exception $错误) {
            错误.抛出($错误);
        }
    }
    
    public void 置音乐(final String $地址,final 通用方法 $回调) {
        new 线程(new 通用方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    try {
                        置音乐($地址);
                        调用方法.事件($回调,true);
                    }  catch (Exception $错误) {
                        调用方法.事件($回调,false,new 错误($错误));
                    }
                    return null;
                }
        }).启动();
    }
    
    public void 开始() {
        播放器.start();
    }
    
    public void 停止() {
        播放器.stop();
    }
    
    public void 暂停() {
        播放器.pause();
    }
    
    public void 跳转(int $位置) {
        播放器.seekTo($位置);
    }
    
    public boolean 是播放中() {
        return 播放器.isPlaying();
    }
    
    public int 取长度() {
        return 播放器.getDuration();
    }
    
    public int 取进度() {
        return 播放器.getCurrentPosition();
    }

}

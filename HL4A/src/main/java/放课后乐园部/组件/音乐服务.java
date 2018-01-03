package 放课后乐园部.组件;

import android.media.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.收集.*;
import java.io.*;
import android.widget.SeekBar.*;

public class 音乐服务 extends 基本服务 {

    String 保存地址 = "$数据/所有音乐.H";
    集合 所有音乐;
    boolean 需要;

    @Override
    public void onCreate() {
        super.onCreate();
        所有音乐 = 序列化.读取集合(保存地址);
    }

    @Override
    public void onDestroy() {
        if (所有音乐.isEmpty())
            文件.删除(保存地址);
        else
            序列化.保存(保存地址, 所有音乐);
        super.onDestroy();
    }

    MediaPlayer 播放器 = new MediaPlayer();

    public 错误 置音乐(String $地址) {
        try {
            String $音乐 = 文件.检查地址($地址);
            播放器.setDataSource($音乐);
            播放器.prepare();
            return null;
        }  catch (Exception $错误) {
            return new 错误($错误);
        }
    }
    
    public void 置音乐(final String $地址,final 通用方法 $回调) {
        new 线程(new 通用方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    try {
                        String $音乐 = 文件.检查地址($地址);
                        播放器.setDataSource($音乐);
                        播放器.prepare();
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

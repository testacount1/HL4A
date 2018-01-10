package h.kl.layout;

import android.content.*;
import h.kl.util.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.资源.布局.*;

public class 布局_管理界面 extends 布局_基本界面 {

    public 编辑框 地址;
    public 文本视图 次数;
    public 文本视图 状态;
    public 按钮 控制;

    public 连接管理 发送;

    public 布局_管理界面(Context $上下文) {
        super($上下文);
        标题.置标题("KL4A 定制版");
        次数 = new 文本视图($上下文);
        次数.加入到(底层);
        次数.置文本("未开始");
        次数.置填充("4dp");
        状态 = new 文本视图($上下文);
        状态.加入到(底层);
        状态.置文本("未开始");
        状态.置填充("4dp");
        地址 = new 编辑框($上下文);
        地址.加入到(底层);
        地址.置默认文本("线程数量");
        地址.置输入类型("数字");
        控制 = new 按钮($上下文);
        控制.置宽度("最大");
        控制.加入到(底层);
        控制.置文本("启动发送");
        控制.置单击事件(启动);
    }

    通用方法 启动 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
           try {
            if ("".equals(地址.取文本())) {
                弹窗.提示("请输入线程数量");
            } else {
                状态.置文本("正在发送");
                次数.置文本("正在发送");
                控制.置文本("停止发送");
                控制.置单击事件(停止);
                Integer $数量 = Integer.parseInt(地址.取文本());
                //连接管理.初始化($数量, "http://qdbyb.cn/abc/int.php",状态,次数,停止);
                连接管理.初始化($数量, "http://www.thbattle.net",状态,次数,停止);
                连接管理.启动();
  
            }
            }catch(Exception $错误) {
                错误.保存($错误);
            }
            return null;
        }
    };

    通用方法 停止 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            控制.置文本("启动发送");
            控制.置单击事件(启动);
            发送.停止();
            return null;
        }
    };

}

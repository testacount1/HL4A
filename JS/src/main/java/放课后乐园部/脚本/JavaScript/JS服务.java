package 放课后乐园部.脚本.JavaScript;

public class JS服务 extends JS基本服务 {

    @Override
    public void onCreate() {
        super.onCreate();
        当前环境.运行文件("#service.js");
        服务创建事件();
    }
    
}

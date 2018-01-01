package 放课后乐园部.基本;

import java.io.*;

public class 命令 {

    boolean 成功 = true;
    Process 进程 = null;

    public 命令(String $命令) {
        this($命令,文件.取文件对象("#"));
    }
    
    public 命令(String $命令,File $当前) {
        this($命令,$当前,new String[0]);
    }

    public 命令(String $命令,String... $参数) {
        this($命令,文件.取文件对象("#"),$参数);
    }

    public 命令(String $命令,File $当前,String... $参数) {
        try {
            if ($命令 == null) $命令 = "";
            进程 =  Runtime.getRuntime().exec($命令, $参数, $当前);
        } catch (Exception $错误) {
            成功 = false;
        }
    }

    public 命令 等待() {
        try {
            进程.waitFor();
        } catch (Exception $错误) {
            成功 = false;
        }
        return this;
    }

    public boolean 状态() {
        return 成功;
    }

    public String 读取() {

        InputStream $输入流 = 进程.getInputStream();

        String $文本 = 字符.读取($输入流);

        IO流.关闭($输入流);

        return $文本;

    }

}

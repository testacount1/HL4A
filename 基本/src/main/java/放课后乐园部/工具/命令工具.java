package 放课后乐园部.工具;

import java.io.*;

public class 命令工具 {

    private boolean 成功 = true;
    private Process 进程 = null;

    public 命令工具(String $命令,File $当前,String... $参数) {
        try {
            if ($命令 == null) $命令 = "";
            进程 =  Runtime.getRuntime().exec($命令, $参数, $当前);
        } catch (Exception $错误) {
            成功 = false;
        }
    }

    public void 等待() {
        try {
            进程.waitFor();
        } catch (Exception $错误) {
            成功 = false;
        }
    }

    public boolean 状态() {
        return 成功;
    }

    public String 读取() {

        InputStream $输入流 = 进程.getInputStream();

        String $文本 = 字符工具.读取($输入流);

        流工具.关闭($输入流);

        return $文本;

    }

}

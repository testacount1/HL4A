package 放课后乐园部.编译;

import org.mozilla.javascript.*;
import org.mozilla.javascript.optimizer.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.收集.*;
import java.io.*;

public class JSC {

    CompilerEnvirons 编译参数;
    ClassCompiler 编译器;

    String 文件名;
    String 包名;
    String 源码;

    String 类名;

    String 输出;

    public JSC(String $文件) {
        if (文件.是文件($文件)) {
            文件名 = 文件.取名称($文件);
            源码 = 字符.读取($文件);
        } else 源码 = "";
        编译参数 = new CompilerEnvirons();
        编译器 = new ClassCompiler(编译参数);
        置编译源码(false);
    }

    public JSC 置编译版本(int $版本) {
        编译参数.setLanguageVersion($版本);
        return this;
    }

    public JSC 置严格模式(boolean $模式) {
        编译参数.setStrictMode($模式);
        return this;
    }

    public JSC 置IDE模式(boolean $模式) {
        编译参数.setIdeMode($模式);
        return this;
    }

    public JSC 置编译源码(boolean $模式) {
        编译参数.setGeneratingSource($模式);
        return this;
    }

    public JSC 置调试模式(boolean $模式) {
        编译参数.setGenerateDebugInfo($模式);
        return this;
    }

    public String 编译() {

            if (源码 != "") {
                类名 = 字符.替换(文件名, ".", "$");
                类名 = 包名 + "." + 类名;
            }

            Object[] $结果 =  编译器.compileToClassFiles(源码, 文件名, 1, 类名);

            if ($结果 == null || $结果.length == 0) return null;

            for (int j = 0; j != $结果.length; j += 2) {
                String $路径 = 字符.替换((String)$结果[j],".","/");
                byte[] $字节 = (byte[])$结果[j + 1];
                String $保存 = 输出 + "/" + $路径 + ".class";
                字节.保存($保存, $字节);
            }

            return 包名 + "." + 文件名 + ".exec(当前环境.JS上下文,当前环境.函数环境);";

    }


    public JSC 置输出(String $地址) {
        输出 = $地址;
        return this;
    }

    public JSC 置包名(String $包名) {
        包名 = $包名;
        return this;
    }

    public JSC 置方法名(String $方法名) {
        编译器.setMainMethodClass($方法名);
        return this;
    }

    public JSC 置继承(String $类名) {
        Class<?> $类 = 反射.取类($类名);
        编译器.setTargetExtends($类);
        return this;
    }

    public JSC 置实现(String... $类名) {
        集合 $所有 = new 集合();
        for (String $单个 : $类名) {
            Class $类 = 反射.取类($单个);
            if ($类 != null) {
                $所有.添加($类);
            }
        }
        编译器.setTargetImplements((Class<?>[])$所有.toArray(new Class[$所有.size()]));
        return this;
    }

}



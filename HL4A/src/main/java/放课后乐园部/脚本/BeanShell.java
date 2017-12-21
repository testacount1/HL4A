package 放课后乐园部.脚本;

import android.content.*;
import bsh.*;
import 放课后乐园部.基本.*;

public class BeanShell {

    public Interpreter BSH实例;

    public BeanShell() {	
        BSH实例 = new Interpreter();
        压入变量("当前环境", this);
        压入变量("当前应用",环境.读取());
        运行文件("#lib/android.bsh");
    }

    public Interpreter 取BSH实例() {
        return BSH实例;
    }

    public Object 执行代码(String $内容) {
        try {
            return BSH实例.eval($内容);
        } catch (Exception $错误) {
            错误.默认($错误);
        }
        return null;
    }

    public Object 运行文件(String $文件) {
        try {
            return BSH实例.source(文件.检查地址($文件));
        } catch (Exception $错误) {}
        return null;
    }

    public BeanShell 压入变量(String $BSH实例名,Object $BSH实例) {
        try {
            BSH实例.set($BSH实例名, $BSH实例);
        } catch (EvalError $错误) {
            错误.默认($错误);
        }
        return this;
    }

    public Object 读取对象(String $BSH实例名) {
        try {
            return BSH实例.get($BSH实例名);
        } catch (EvalError $错误) {
            错误.默认($错误);
        }
        return null;
    }

    public Object 调用函数(String $方法名,Object... $参数组) {

        int $数量 = $参数组.length;

        if ($数量 == 0) return 执行代码("return " + $方法名 + "()");

        String $传入 = "$0";
        压入变量("$0", $参数组[0]);

        for (int $键值 = 1;$键值 != $数量;$键值 ++) {
            $传入 += ",$" + $键值;
            压入变量("$" + $键值, $参数组[$键值]);
        }

        return 执行代码("return " + $方法名 + "(" + $传入 + ");");
    }

}

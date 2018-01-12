package 放课后乐园部.脚本;

import com.eclipsesource.v8.*;
import 放课后乐园部.基本.*;
import com.eclipsesource.v8.utils.*;
import 放课后乐园部.收集.*;
import java.lang.reflect.*;
import 放课后乐园部.弹窗.*;

public class J2V8 implements 基本脚本 {

    @Override
    public String 取脚本类型() {
        return "J2V8";
    }

    public V8 上下文;

    public J2V8() {
        上下文 = V8.createV8Runtime();
    }

    public void 压入Java对象(String $名称,Object $对象) {
        Class $类 = $对象.getClass();
        //V8Object $JS对象 = 上下文.add($名称, new V8Object(上下文));
        V8Array $数组 = new V8Array(上下文);
        上下文.add($名称,$数组);
        Method[] $所有 = $类.getMethods();
        for (Method $单个 : $所有) {
            $数组.registerJavaMethod($对象, $单个, $单个.getName(),false);
        }
    }

    public void 压入JAVA类(String $名称,Class $类) {
        //V8Object $JS对象 = 上下文.add($名称, new V8Object(上下文));
        V8Array $数组 = new V8Array(上下文);
        上下文.add($名称,$数组);
        Method[] $所有 = $类.getMethods();
        for (Method $单个 : $所有) {
            $数组.registerJavaMethod(null, $单个,$单个.getName(),false);
        }
    }
    
    @Override
    public void 压入变量(String $名称,Object $对象) {
        上下文.setData($名称, $对象);
    }

    @Override
    public Object 读取对象(String $名称) {
        return 上下文.get($名称);
    }

    @Override
    public Object 执行代码(String $代码) {
        return 上下文.executeScript($代码);
    }

    @Override
    public Object 运行文件(String $文件) {
        if (!文件.是文件($文件)) return null;
        return 执行代码(字符.读取($文件));
    }

    @Override
    public Object 调用函数(String $方法,Object[] $参数) {
        return 上下文.executeFunction($方法, V8ObjectUtils.toV8Array(上下文, 集合.到集合($参数)));
    }

}

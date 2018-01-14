package 放课后乐园部.脚本;

import org.mozilla.javascript.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.脚本.事件.*;
import 放课后乐园部.收集.*;
import java.util.*;

public class JavaScript implements 基本脚本 {

    @Override
    public String 取脚本类型() {
        return "JavaScript";
    }
	
	public static String 实例 = "提示.普通(\"Hello World\");";

    public static 哈希表 替换关键字表 = new 哈希表();
    
    public static String[][] 默认替换表 = {
        {"出", "break"},
        {"为", "case"},
        {"续", "continue"},
        {"默", "default"},
        {"删", "delete"},
        {"执", "do"},
        {"另", "else"},
        {"假", "false"},
        {"循环", "for"},
        {"函数", "function"},
        {"如", "if"},
        {"在", "in"},
        {"变量", "let"},
        {"新", "new"},
        {"空", "null"},
        {"返", "return"},
        {"选", "switch"},
        {"此", "this"},
        {"真", "true"},
        {"型", "typeof"},
        {"自由变量", "var"},
        {"当", "while"},
        {"扩", "with"},
        {"让", "yield"},
        {"捕", "catch"},
        {"常量", "const"},
        {"终", "finally"},
        {"类为", "instanceof"},
        {"抛", "throw"},
        {"试", "try"},
       
    };
    
    static {
        替换关键字(默认替换表);
    }
    
    public static void 替换关键字(String $新,String $旧) {
        替换关键字表.设置($新,$旧);
    }
    
    public static void 替换关键字(String[][] $表) {
        for (String[] $单个 : $表) {
            替换关键字表.设置((String)$单个[0],(String)$单个[1]);
        }
    }

	public Context JS上下文;
	public Scriptable 函数环境;

	public JavaScript() {

		JS上下文 = Context.enter();
		JS上下文.setOptimizationLevel(-1);
		JS上下文.setLanguageVersion(Context.VERSION_ES6);
		ImporterTopLevel 初始化环境 = new ImporterTopLevel();
		初始化环境.initStandardObjects(JS上下文, false);
		函数环境 = 初始化环境;

        //置错误监听(默认警告监听, 默认错误监听, 默认运行时错误监听);
		压入变量("当前环境", this);
		压入变量("是复制环境", false);
        压入变量("当前应用", 环境.读取());
        运行文件("@lib/android.js");

	}

	public JavaScript(JavaScript $被继承) {

		JS上下文 = Context.enter();
		函数环境 =  $被继承.JS上下文.newObject($被继承.函数环境);
		函数环境.setParentScope(null);
		JS上下文.setOptimizationLevel(-1);
		JS上下文.setLanguageVersion(Context.VERSION_ES6);

		压入变量("复制环境", this);
		压入变量("是复制环境", true);
		压入变量("全局上下文", 环境.读取());

	}

    public JavaScript 置错误监听(通用方法 $警告,通用方法 $错误,通用方法 $运行时错误) {
        JS上下文.setErrorReporter(new 错误监听($警告, $错误, $运行时错误));
        return this;
    }

    @Override
	public void 压入变量(String $对象名,Object $对象) {
		try {
			ScriptableObject.putProperty(函数环境, $对象名, Context.javaToJS($对象, 函数环境));
		} catch (Exception $错误) {
			错误.抛出($错误);
		}
	}

	public void 压入常量(String $对象名,Object $对象) {
		try {
			ScriptableObject.putConstProperty(函数环境, $对象名, Context.javaToJS($对象, 函数环境));
		} catch (Exception $错误) {
			错误.抛出($错误);
		}
	}
    

    @Override
	public Object 读取对象(String $对象名) {
		Object $对象 = 函数环境.get($对象名, 函数环境);
		if ($对象 != Scriptable.NOT_FOUND) {
			return $对象;
		}
		return null;
	}

    
	public Function 读取函数(String $函数名) {
		Object $对象 = 读取对象($函数名);
		if ($对象 instanceof Function) {
			return (Function) $对象;
		}
		return null;
	}

	public Object 调用函数(Function $函数,Object... $传入) {
		if ($传入 == null) $传入 = new Object[]{};
		try {
			return $函数.call(JS上下文, 函数环境, 函数环境, $传入);
		} catch (Exception $错误) {
			错误.抛出($错误);
		}
		return null;
	}

    @Override
	public Object 调用函数(String $函数名,Object... $传入) {
		Function $函数 = 读取函数($函数名);
		if ($函数 != null)return 调用函数($函数, $传入);
		return null;
	}

    @Override
    public Object 执行代码(String $内容) {
        return 执行代码($内容, $内容);
    }

	public Object 执行代码(String $内容,String $环境名) {

		if ($内容 == null) $内容 = "";

		try {
			return JS上下文.evaluateString(函数环境, $内容.toString(), $环境名, 1, null);
		} catch (Exception $错误) {
			错误.抛出($错误);
		}

		return null;

	}

    @Override
    public Object 运行文件(String $地址) {
        String $ = 字符.读取($地址);
        return 执行代码($, $地址);
	}

	public Object 运行文件(String $地址,String $环境名) {
        String $ = 字符.读取($地址);
		return 执行代码($, $环境名);
	}

	public void 退出() {
		JS上下文.exit();
	}

}

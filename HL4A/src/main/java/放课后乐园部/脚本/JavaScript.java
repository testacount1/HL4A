package 放课后乐园部.脚本;

import java.util.List;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.ImporterTopLevel;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import 放课后乐园部.基本.字符;
import 放课后乐园部.基本.注入;
import 放课后乐园部.基本.环境;
import 放课后乐园部.基本.错误;

public class JavaScript {

	public Context JS上下文;
	public Scriptable 函数环境;

	public JavaScript() {

		JS上下文 = Context.enter();
		JS上下文.setOptimizationLevel(-1);
		JS上下文.setLanguageVersion(Context.VERSION_ES6);
		ImporterTopLevel 初始化环境 = new ImporterTopLevel();
		初始化环境.initStandardObjects(JS上下文, false);
		函数环境 = 初始化环境;

		压入变量("当前环境", this);
		压入变量("是复制环境", false);
		压入变量("全局上下文", 环境.读取());
        压入变量("当前应用",环境.读取());
        运行文件("@script/lib/android.js");

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
   
	public JavaScript 压入变量(String $对象名,Object $对象) {
		try {
			ScriptableObject.putProperty(函数环境, $对象名, Context.javaToJS($对象, 函数环境));
		} catch (Exception $错误) {
			错误.默认($错误);
		}
        return this;
	}

	public JavaScript 压入常量(String $对象名,Object $对象) {
		try {
			ScriptableObject.putConstProperty(函数环境, $对象名, Context.javaToJS($对象, 函数环境));
		} catch (Exception $错误) {
			错误.默认($错误);
		}
        return this;
	}

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
			错误.默认($错误);
		}
		return null;
	}


	public Object 调用函数(String $函数名,Object... $传入) {
		Function $函数 = 读取函数($函数名);
		if ($函数 != null)return 调用函数($函数, $传入);
		return null;
	}

    public Object 执行代码(String $内容) {
        
        return 执行代码($内容,$内容);
        
    }
    
	public Object 执行代码(String $内容,String $环境名) {

		if ($内容 == null) $内容 = "";

		try {
			return JS上下文.evaluateString(函数环境, $内容.toString(), "文件:<" + $环境名 + ">", 1, null);
		} catch (Exception $错误) {
			错误.默认($错误);
		}

		return null;

	}

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

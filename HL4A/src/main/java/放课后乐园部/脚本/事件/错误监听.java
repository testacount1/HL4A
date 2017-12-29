package 放课后乐园部.脚本.事件;

import org.mozilla.javascript.*;
import 放课后乐园部.事件.*;

public class 错误监听 implements ErrorReporter {
    
    public 错误监听(通用方法 $警告,通用方法 $错误,通用方法 $运行时错误) {
        警告 = $警告;
        错误 = $错误;
        运行时错误 = $运行时错误;
    }
    
    public 通用方法 警告;
    public 通用方法 错误;
    public 通用方法 运行时错误;
    
    
    @Override
    public void warning(String $信息,String $源码名,int $行数,String $单行源码,int $行数结束) {
        调用方法.事件(警告,$信息,$源码名,$行数,$单行源码,$行数结束);
    }

    @Override
    public void error(String $信息,String $源码名,int $行数,String $单行源码,int $行数结束) {
        调用方法.事件(警告,$信息,$源码名,$行数,$单行源码,$行数结束);
    }

    @Override
    public EvaluatorException runtimeError(String $信息,String $源码名,int $行数,String $单行源码,int $行数结束) {
        Object $返回值 = 调用方法.事件(警告,$信息,$源码名,$行数,$单行源码,$行数结束);
        if ($返回值 instanceof EvaluatorException) {
            return (EvaluatorException)$返回值;
        } else if ($返回值 instanceof String) {
            return new EvaluatorException((String)$返回值);
        } else if ($返回值 == null) {
            return new EvaluatorException($信息,$源码名,$行数,$单行源码,$行数结束);
        } else {
            return new EvaluatorException($返回值.toString());
        }
    }

}

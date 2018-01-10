package 放课后乐园部.视图.扩展;

import android.content.*;
import 放课后乐园部.视图.*;

public class 滚动文本 extends 滚动视图 {

    public 文本视图 文本;

    public 滚动文本(Context $上下文) {
        super($上下文);
		横向滚动 $滚动 = new 横向滚动($上下文);
		$滚动.置宽度("最大");
		$滚动.置高度("最大");
		$滚动.加入到(this);
        文本 = new 文本视图($上下文);
		文本.加入到($滚动);

        文本.setHorizontallyScrolling(true);
    }

    public void 置文本(String $文本) {
        文本.置文本($文本);
    }

    public String 取文本() {
        return 文本.取文本();
    }

}

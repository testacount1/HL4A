package 放课后乐园部.视图.扩展;

import android.content.*;
import 放课后乐园部.视图.*;

public class 滚动文本 extends 滚动视图 {

    public 文本控件 文本;

    public 滚动文本(Context $上下文) {
        super($上下文);
        文本 = new 文本控件($上下文)
        
            .加入到(new 横向滚动($上下文)
                 .置宽度("最大")
                 .置高度("最大")
                 .加入到(this));
                 
        文本.setHorizontallyScrolling(true);
    }

    public 滚动文本 置文本(String $文本) {
        文本.置文本($文本);
        return this;
    }

    public String 取文本() {
        return 文本.取文本();
    }

}

package h.ide.layout;

import android.content.*;
import 放课后乐园部.安卓.视图.*;

public class 布局_新建文件 extends 线性布局 {

	public 编辑框 内容;

	public 布局_新建文件(Context $上下文) {
		super($上下文);
		置左填充("16dp");
        置右填充("16dp");
        内容 = new 编辑框(this);
	}

}

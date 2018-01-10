package 放课后乐园部.视图;

import android.content.*;
import android.support.v4.widget.*;
import 放课后乐园部.基本.*;
import android.view.*;

public class 进度圈 extends 进度条 {
    
    public 进度圈(Context $上下文) {
        super($上下文,android.R.attr.progressBarStyleInverse);
    }
    
    public 进度圈(Context $上下文,ViewGroup $父视图) {
        this($上下文);
        加入到($父视图);
    }
    
    
}

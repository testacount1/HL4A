package 放课后乐园部.安卓.视图;

import android.content.*;
import android.view.*;

public class 进度圈 extends 进度条 {
    
    public 进度圈(Context $上下文) {
        super($上下文,android.R.attr.progressBarStyleInverse);
    }
    
    public 进度圈(ViewGroup $父视图) {
        this($父视图.getContext());
        加入到($父视图);
    }
    
    
}

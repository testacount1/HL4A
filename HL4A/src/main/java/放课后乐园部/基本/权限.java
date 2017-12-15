package 放课后乐园部.基本;
import android.content.*;
import com.mylhyl.acp.*;
import android.*;
import java.util.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.组件.*;

public class 权限 {
    
    public static 基本界面 权限界面;
    
    public static 基本界面 取界面() {
        return 权限界面;
    }
    
    public static void 检查(通用方法 $失败) {
        检查(null,$失败);
    }
    
    public static void 检查(通用方法 $成功,通用方法 $失败) {
        Acp.getInstance().request(new AcpOptions.Builder()
            .build(), new 申请权限($成功,$失败));
    }
    
}

package 放课后乐园部.安卓.工具;

import 放课后乐园部.工具.*;
import android.os.*;
import android.content.*;
import android.net.*;

public class 安卓文件 {
    
    protected static void 初始化() {
        文件工具.替换地址("%",取存储卡目录(""));
        文件工具.替换地址("$",取数据目录(""));
        文件工具.替换地址("#",取存储卡目录("Android","data",应用工具.取包名(),""));
    }
    
    public static void 打开(String $地址) {
        Intent $意图 = new Intent(Intent.ACTION_VIEW);
        $意图.setDataAndType(Uri.fromFile(文件工具.取文件对象($地址)), 文件工具.取MIME($地址));
        $意图.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        上下文工具.取全局上下文().startActivity($意图);
    }
    
    public static String 取存储卡目录() {
        return Environment.getExternalStorageDirectory().getPath();
    }

    public static String 取存储卡目录(String... $地址) {
        return 取存储卡目录() + "/" + 字符工具.分解($地址,"/");
    }
    
    public static String 取数据目录() {
        return 上下文工具.取全局上下文().getFilesDir().getParent();
    }
    
    public static String 取数据目录(String... $地址) {
        return 取数据目录() + "/" + 字符工具.分解($地址,"/");
    }
    
    public static String 取缓存目录() {
        return 上下文工具.取全局上下文().getCacheDir().getPath();
    }

    public static String 取缓存目录(String... $地址) {
        return 取数据目录() + "/" + 字符工具.分解($地址,"/");
    }

}

package 放课后乐园部.安卓.视图.适配器;

import android.content.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import 放课后乐园部.收集.*;

public abstract class 基本适配器 extends BaseAdapter {

    public Context 上下文;
    public 集合<哈希表<String,String>> 数据;
    
    public 基本适配器(Context $上下文,List<String> $数据) {
        上下文 = $上下文;
        数据 = new 集合<>(转换($数据));
    }
    
    @Override
    public int getCount() {
        return 数据.数量();
    }

    @Override
    public Object getItem(int $键值) {
        return $键值;
    }

    @Override
    public long getItemId(int $键值) {
        return $键值;
    }

    @Override
    public View getView(int $键值,View $视图,ViewGroup $视图组) {
        if ($视图 == null) {
            $视图 = 创建();
        }
        $视图 = 处理($视图,(哈希表)数据.读取($键值));
        return $视图;
    }
    
    public void 清空() {
        数据 = new 集合<>();
        发送更新事件();
    }
    
    public void 发送更新事件() {
        notifyDataSetChanged();
    }
    
    public void 发送重绘事件() {
        notifyDataSetInvalidated();
    }
    
    public abstract 集合<哈希表<String,String>> 转换(List<String> $数据);
   
    public abstract View 创建();
    
    public abstract View 处理(View $视图,哈希表 $参数);
   
    
    
}

package 放课后乐园部.安卓.视图.适配器;

import android.support.v4.view.*;
import android.view.*;
import 放课后乐园部.收集.*;
import 放课后乐园部.安卓.视图.实现.*;

public class 界面适配器 extends PagerAdapter {

    private 集合<View> 视图集合;
    
    public 界面适配器() {
        视图集合 = new 集合<View>();
    }
    
    public void 添加(View $视图) {
        视图集合.添加($视图);
        发送重绘事件();
    }
    
    public void 发送重绘事件() {
        notifyDataSetChanged();
    }
    
    @Override
    public int getCount() {
        return 视图集合.数量();
    }

    @Override
    public void destroyItem(ViewGroup container,int position,Object object) {
        container.removeView((View)object);
    }
    
    @Override
    public boolean isViewFromObject(View $视图,Object $对象) {
        return $视图 == $对象;
    }
    
    @Override
    public Object instantiateItem(ViewGroup $视图组,int $键值) {
        View $视图 = 视图集合.读取($键值);
        布局实现.加入子元素($视图组,$视图);
        return $视图;
    }
    
}

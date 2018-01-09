package h.ide.layout;

import android.content.Context;
import 放课后乐园部.视图.列表.基本列表;
import 放课后乐园部.资源.布局.布局_基本界面;
import 放课后乐园部.基本.应用;
import 放课后乐园部.视图.*;
import 放课后乐园部.视图.适配器.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.数据.*;
import org.jsoup.nodes.*;
import 放课后乐园部.收集.*;
import 放课后乐园部.基本.*;
import h.ide.adapter.*;
import 放课后乐园部.组件.*;
import h.kl.activity.*;

public class 布局_主页 extends 布局_基本界面 {

    public 下拉刷新布局 布局;
	public 列表视图 列表;
    public 工程适配器 适配器;

	public 布局_主页(final Context $上下文) {
		super($上下文);
		标题.置标题(应用.取应用名());
        布局 = new 下拉刷新布局($上下文);
        布局.加入到(底层);
		列表 = new 列表视图($上下文);
		列表.加入到(布局);
        布局.置刷新事件(刷新);
        适配器 = new 工程适配器(列表);
        标题.右按钮("图片.发送", new 通用方法(){
                @Override
                public Object 调用(Object[] $参数) {
                    ((基本界面)$上下文).跳转界面(ManageActivity.class);
                    return null;
                }
           });
	}
    
    通用方法 刷新 = new 通用方法() {
        @Override
        public Object 调用(Object[] $参数) {
            适配器.更新工程();
            布局.置刷新状态(false);
            return null;
        }
    };

}

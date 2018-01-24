package 放课后乐园部.安卓.组件;

import android.os.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.安卓.弹窗.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.视图.扩展.*;
import 放课后乐园部.安卓.资源.*;

public class 错误界面 extends 基本界面 {

    String 错误内容;

    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);

        线性布局 $底层 = new 线性布局(this);
		$底层.打开(this);

        标题栏 $标题 = new 标题栏(this);
		$标题.置标题("崩溃了(ノДＴ)");
		$标题.加入到($底层);

        $标题.左按钮(图标.返回, new 通用方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    错误界面.this.结束界面();
                    return null;
                }
            });

        $标题.右按钮(图标.复制, new 通用方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    设备工具.置剪切板(错误内容);
                    提示工具.普通("已复制 ~");
                    return null;
                }
            });
		/*
		 $标题.右按钮(图标.发送, new 通用方法() {
		 @Override
		 public Object 调用(Object[] $参数) {
		 设备工具.置剪切板(错误内容);
		 提示工具.普通("已复制 请发送 ~");
		 return null;
		 }
		 });
		 */


        错误内容 = getIntent().getStringExtra("错误");

        if (错误内容 == null) 错误内容 = "未知错误";

        线性布局 $布局 = new 线性布局(this);
		$布局.置宽度("最大");
		$布局.置高度("最大");
		$布局.置填充("16dp");
		$布局.加入到($底层);

        滚动文本 $文本 = new 滚动文本(this);
		$文本.置文本(错误内容);
		$文本.加入到($布局);

		if (辅助工具.已启动()) {
			final 基本弹窗 $弹窗 = new 基本弹窗(this);
			$弹窗.置标题("警告");
			$弹窗.置内容("辅助服务已启动...\n出错后在某些设备上\n会出现按键失灵，重启辅助服务即可.");
			$弹窗.置右按钮("重启", new 通用方法() {
					@Override
					public Object 调用(Object[] $参数) {
						$弹窗.隐藏();
						辅助工具.跳转();
						return null;
					}
				});
			$弹窗.显示();
		}
    }

}

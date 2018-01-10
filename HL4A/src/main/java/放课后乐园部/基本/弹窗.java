package 放课后乐园部.基本;

import android.app.*;
import android.content.*;
import android.view.*;
import android.view.WindowManager.*;
import android.widget.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.资源.布局.*;
import 放课后乐园部.视图.事件.*;

public class 弹窗 {

    弹窗() {}

    public static Toast 提示对象;
    public static 文本视图 文本对象;

    public static void 初始化(Context $环境) {
        提示对象 = Toast.makeText($环境, "", Toast.LENGTH_SHORT);
		布局_提示 $视图 = new 布局_提示($环境);
        文本对象 = $视图.文本;
		提示对象.setView($视图);
    }

    public static void 提示(final Object $内容) {
        处理.主线程(new 通用方法(){
                @Override
                public Object 调用(Object[] $参数) {
                    Object $文本 = $内容;
                    if ($文本 == null) $文本 = "null";
                    文本对象.置文本($文本.toString());
                    提示对象.show();
                    return null;
                }
            });
    }

    public static 基本弹窗 加载中(Activity $界面,String $内容) {
        界面_加载中 $视图 = new 界面_加载中($界面);
        $视图.文本对象.置文本($内容);
        return new 基本弹窗($界面).置可关闭(false).置布局($视图);
    }

    public static class 基本弹窗 extends AlertDialog {

        public View 布局;

        public 基本弹窗(Context $界面) {
            super($界面);
            setCanceledOnTouchOutside(true);
            /*
             getWindow().setBackgroundDrawable(绘画.颜色转绘画(0));
             requestWindowFeature(Window.FEATURE_NO_TITLE);
             */
        }

		public 基本弹窗 置内容(String $内容) {
			setMessage($内容);
			return this;
		}

		public 基本弹窗 置内容(View $内容) {
			setView($内容);
			return this;
		}

		public 基本弹窗 置标题(String $标题) {
			setTitle($标题);
			return this;
		}

		public 基本弹窗 置右按钮(String $名称,通用方法 $按下) {
			setButton($名称, new 弹窗按钮单击($按下));
			return this;
		}

		public 基本弹窗 置中按钮(String $名称,通用方法 $按下) {
			setButton2($名称, new 弹窗按钮单击($按下));
			return this;
		}

		public 基本弹窗 置左按钮(String $名称,通用方法 $按下) {
			setButton3($名称, new 弹窗按钮单击($按下));
			return this;
		}

        public 基本弹窗 置布局(View $视图) {
            布局 = $视图;
            return this;
        }

        public View 取布局() {
            return 布局;
        }

        public 基本弹窗 显示() {
            处理.主线程(new 通用方法() {
                    @Override
                    public Object 调用(Object[] $参数) {
                        show();
						if (布局 != null) {
							setContentView(布局);
						}
                        Window window = getWindow();
                        LayoutParams params = window.getAttributes();
                        params.flags = 2;
                        window.setAttributes(params);
                        return null;
                    }
                });

            return this;
        }

        public 基本弹窗 置可关闭(boolean $是否) {
            setCancelable($是否);
            setCanceledOnTouchOutside($是否);
            return this;
        }

        public 基本弹窗 隐藏() {
            处理.主线程(new 通用方法() {
                    @Override
                    public Object 调用(Object[] $参数) {
                        dismiss();
                        return null;
                    }
                });
            return this;
        }

    }

}

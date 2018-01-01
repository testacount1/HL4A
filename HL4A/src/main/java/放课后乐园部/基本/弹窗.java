package 放课后乐园部.基本;

import android.app.*;
import android.content.*;
import android.view.*;
import android.view.WindowManager.*;
import android.widget.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.资源.布局.*;

public class 弹窗 {

    弹窗() {}

    public static Long 上次提示;
    public static Toast 提示对象;
    public static TextView 文本对象;

    public static void 初始化(Context $环境) {
        提示对象 = Toast.makeText($环境, "", Toast.LENGTH_SHORT);
        文本对象 = (TextView)提示对象.getView()
            .findViewById(android.R.id.message);
        上次提示 = 时间.时间戳() - 233;
        文本对象.setTextSize(视图.检查大小(主题.文本大小()));
        文本对象.setTextColor(视图.检查颜色(主题.基本色()));
    }

    public static void 提示(final Object $内容) {
        处理.主线程(new 通用方法(){
                @Override
                public Object 调用(Object[] $参数) {
                    Object $文本 = $内容;
                    if ($文本 == null) $文本 = "null";
                    long $上次 = 上次提示;
                    if ((上次提示 = 时间.时间戳()) - $上次 < 500) {
                        文本对象.setText(文本对象.getText() + "\n" + $文本.toString());
                    } else 文本对象.setText($文本.toString());
                    提示对象.show();
                    return null;
                }
            });
    }

    public static 基本弹窗 普通(Activity $界面,String $标题,Object $内容) {
        界面_基本弹窗 $布局 = new 界面_基本弹窗($界面, $标题, $内容);
        return new 基本弹窗($界面).置布局($布局);
    }

    public static 基本弹窗 普通(Activity $界面,String $标题,Object $内容,String $按钮,通用方法 $单击) {
        界面_基本弹窗 $布局 = new 界面_基本弹窗($界面, $标题, $内容);
        按钮 $按钮对象 = new 按钮($界面)
            .置宽度("自动")
            .置高度("自动")
            .置文本重力("中间")
            .置背景("透明")
            .置文本颜色(主题.基本色())
            .置文本($按钮)
            .置文本大小(主题.文本大小())
            .置单击事件($单击);
        $布局.操作布局.显示().加入子元素($按钮对象);
        return new 基本弹窗($界面).置布局($布局);
    }

    public static 基本弹窗 普通(Activity $界面,String $标题,Object $内容,String $按钮,通用方法 $单击,String $右按钮,通用方法 $右单击) {
        界面_基本弹窗 $布局 = new 界面_基本弹窗($界面, $标题, $内容);
        按钮 $左按钮对象 = new 按钮($界面)
            .置宽度("自动")
            .置高度("自动")
            .置文本重力("中间")
            .置背景("透明")
            .置文本颜色(主题.基本色())
            .置文本($按钮)
            .置文本大小(主题.文本大小())
            .置单击事件($单击);
        按钮 $右按钮对象 = new 按钮($界面)
            .置宽度("自动")
            .置高度("自动")
            .置文本重力("中间")
            .置背景("透明")
            .置文本颜色(主题.基本色())
            .置文本($右按钮)
            .置文本大小(主题.文本大小())
            .置单击事件($右单击);
        $布局.操作布局.显示()
            .加入子元素($左按钮对象)
            .加入子元素($右按钮对象);
        return new 基本弹窗($界面).置布局($布局);
    }

    public static 基本弹窗 普通(Activity $界面,String $标题,Object $内容,String $左按钮,通用方法 $左单击,String $中按钮,通用方法 $中单击,String $右按钮,通用方法 $右单击) {
        界面_基本弹窗 $布局 = new 界面_基本弹窗($界面, $标题, $内容);
        new 按钮($界面)
            .置宽度("自动")
            .置高度("自动")
            .置文本重力("中间")
            .置背景("透明")
            .置文本颜色(主题.基本色())
            .置文本($左按钮)
            .置文本大小(主题.文本大小())
            .置单击事件($左单击)
            .加入到($布局
                 .操作布局
                 .显示()
                 .置重力("左边"));
        线性布局 $右布局 = new 线性布局($界面)
            .置宽度("最大")
            .置高度("最大")
            .置方向("水平")
            .置重力("右边")
            .加入到($布局.操作布局);
        new 按钮($界面)
            .置宽度("自动")
            .置高度("自动")
            .置文本重力("中间")
            .置背景("透明")
            .置文本颜色(主题.基本色())
            .置文本($中按钮)
            .置文本大小(主题.文本大小())
            .置单击事件($中单击)
            .加入到($右布局);
        new 按钮($界面)
            .置宽度("自动")
            .置高度("自动")
            .置文本重力("中间")
            .置背景("透明")
            .置文本颜色(主题.基本色())
            .置文本($右按钮)
            .置文本大小(主题.文本大小())
            .置单击事件($右单击)
            .加入到($右布局);
        return new 基本弹窗($界面).置布局($布局);
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
                        setContentView(布局);
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

package 放课后乐园部.安卓.视图.扩展;

import android.content.*;
import android.view.*;
import 放课后乐园部.安卓.视图.*;
import 放课后乐园部.安卓.视图.实现.*;
import 放课后乐园部.安卓.视图.适配器.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.安卓.图形.*;
import 放课后乐园部.事件.*;

public class 高级滑动 extends 线性布局 {

    public 滑动视图 滑动;
    public 线性布局 指示;
    public 界面适配器 界面;
    public 线性布局 控制;

    private int 数量 = 0;
    private int 宽度 = 0;

    public 高级滑动(Context $上下文) {
        super($上下文);
        线性布局 $控制底层 = new 线性布局(this);
        $控制底层.置高度("50dp");
        $控制底层.置方向("垂直");
        控制 = new 线性布局($控制底层);
        控制.置高度("45dp");
        控制.置方向("水平");
        $控制底层.置背景(主题工具.取主题颜色().取基本色());
        线性布局 $指示底层 = new 线性布局($控制底层);
        线性布局 $指示 = new 线性布局($指示底层);
        $指示.置高度("3dp");
        指示 = new 线性布局($指示);
        指示.置背景(颜色.白色);
        线性布局 $填充 = new 线性布局($指示底层);
        滑动 = new 滑动视图(this);
        界面 = new 界面适配器();
        滑动.置适配器(界面);
        通用方法 $进度 = new 通用方法() {
            @Override
            public Object 调用(Object[] $参数) {
                int $界面 = $参数[0];
                float $进度 = $参数[1];
                调整指示($界面,$进度);
                return null;
            }
        };
        滑动.置滑动事件($进度,null,null);
    }

    public 高级滑动(ViewGroup $父视图) {
        this($父视图.getContext());
        加入到($父视图);
    }

    public void 添加(String $名称,View $视图) {
        final int $当前 = 数量;
        数量 ++;
        界面.添加($视图);
        线性布局 $按钮 = new 线性布局(控制);
        $按钮.置背景("透明");
        $按钮.置重力("中间");
        $按钮.置布局权重(1);
        宽度 = 应用工具.取屏幕宽度() / 数量;
        指示.置宽度(宽度);
        通用方法 $单击 = new 通用方法() {
            @Override
            public Object 调用(Object[] $参数) {
                滑动.置界面($当前);
                return null;
            }
        };
        $按钮.置单击事件($单击);
        文本视图 $文本 = new 文本视图($按钮);
        $文本.置文本颜色(颜色.白色);
        $文本.置文本($名称);
    }

    public void 调整指示(int $界面,float $位置) {
        指示.置左边距((宽度*$界面)+(宽度*$位置));
    }

}

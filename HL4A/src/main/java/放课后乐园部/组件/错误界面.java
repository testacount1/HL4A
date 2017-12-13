package 放课后乐园部.组件;
import android.os.*;
import 放课后乐园部.视图.*;
import 放课后乐园部.视图.扩展.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.事件.*;

public class 错误界面 extends 基本界面 {

    String 错误;
    
    @Override
    public void onCreate(Bundle $数据) {
        super.onCreate($数据);

        按键按下事件 = new 通用方法() {
            @Override
            public Object 调用(Object[] $参数) {
                结束();
                return null;
            }
        };

        线性布局 $底层 = new 线性布局(this)
            .置主题("底层")
            .打开(this);

        new 标题栏(this, "又崩溃了(ノДＴ)")
            .右按钮("复制",new 通用方法() {
                @Override
                public Object 调用(Object[] $参数) {
                    设备.剪切板(错误);
                    弹窗.提示("已复制 ~");
                    return null;
                }
            })
            .加入到($底层);


        错误 = getIntent().getStringExtra("错误");

        if (错误 == null) 错误 = "未知错误";

        线性布局 $布局 = new 线性布局(this)
            .置主题("底层")
            .置填充("16dp")
            .加入到($底层);

        new 滚动文本(this)
            .置文本(错误)
            .加入到($布局);

    }

}

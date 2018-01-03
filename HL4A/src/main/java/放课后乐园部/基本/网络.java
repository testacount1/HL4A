package 放课后乐园部.基本;

import 放课后乐园部.网络.*;
import android.content.*;
import android.net.*;
import java.io.*;

public class 网络 {

    网络() {}

    public static void 打开(String $地址) {
        Intent $意图= new Intent(Intent.ACTION_VIEW, Uri.parse($地址));
        $意图.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        环境.读取().startActivity($意图);
    }

    public static class QQ {

        public static void 聊天(String $号码) {
            打开("mqqwpa://im/chat?chat_type=wpa&uin=" + $号码);
        }

        public static void 加群(String $号码) {
            打开("mqqapi://card/show_pslcard?src_type=internal&version=1&uin=" + $号码 + "&card_type=group&source=qrcode");
        }

        public static void 名片(String $号码) {
            打开("mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + $号码);
        }

        public static void 乐园部() {
            加群("538982726");
        }

        public static void 作者() {
            名片("1069952275");
        }

        public static void 反馈() {
            聊天("1069952275");
        }

    }

    public static String 取源(String $地址) {
        return new 连接($地址).读取字符();
    }

    public static String 缓存(String $地址) {
        String $文件 = 文件.检查地址("$cache/网络缓存/") + 文件.取直接地址($地址);
        请求 $下载 = new 请求($地址);
        资源 $结果 = $下载.同步();
        if ($结果.是否成功()) {
            $结果.保存到($文件);
            return $文件;
        }
        return 文件.创建文件($文件);

    }


}

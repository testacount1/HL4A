package 放课后乐园部.工具;

import java.io.*;
import 放课后乐园部.收集.*;

public class 序列化工具 {

    public static void 保存(String $地址,Object $对象) {
        try {
            OutputStream $文件流 = 流工具.输出.文件($地址);
            ObjectOutputStream $输出流 = new ObjectOutputStream($文件流);
            $输出流.writeObject($对象);
        } catch (IOException $错误) {}
    }

    public static Object 读取(String $地址) {
        try {
            InputStream $文件流 = 流工具.输入.文件($地址);
            ObjectInputStream $输入流 = new ObjectInputStream($文件流);
            return $输入流.readObject();
        } catch (Exception $错误) {}
        return null;
    }
    
    public static 集合 读取集合(String $地址) {
        集合 $对象 = (集合)读取($地址);
        if ($对象 == null)
            return new 集合();
        return $对象;
    }

    public static 哈希表 读取哈希表(String $地址) {
        哈希表 $对象 = (哈希表)读取($地址);
        if ($对象 == null)
            return new 哈希表();
        return $对象;
    }

}

package 放课后乐园部.编译;
import org.mozilla.classfile.*;
import 放课后乐园部.基本.*;

public class CLASS {

    String 类名;
    String 父类;
    String 源文件;

    ClassFileWriter 编译器;

    public CLASS(String $类名,String $父类,String $源文件) {
        类名 = $类名;
        父类 = $父类;
        源文件 = $源文件;
        编译器 = new ClassFileWriter(类名, 父类, 源文件);
    }
    
    public CLASS 初始化() {
        初始化("()V");
        return this;
    }

    public CLASS 初始化(String $方法签名) {
        编译器.startMethod("<init>", $方法签名, 编译器.ACC_PUBLIC);
        编译器.addLoadThis();
        编译器.addInvoke(ByteCode.INVOKESPECIAL, 父类,
                      "<init>", $方法签名);
        编译器.addLoadThis();
        编译器.add(ByteCode.RETURN);
        编译器.stopMethod((short)1);
        return this;
    }
    
    public String 编译(String $地址) {
        字节.保存($地址,编译器.toByteArray());
        return $地址;
    }

}

package 放课后乐园部.安卓.编译;

import com.android.dex.*;
import com.android.dx.cf.direct.*;
import com.android.dx.command.dexer.*;
import com.android.dx.dex.*;
import com.android.dx.dex.cf.*;
import com.android.dx.merge.*;
import java.io.*;
import 放课后乐园部.工具.*;

public class DEX {

    private DEX() {}

    public static void 多个(String $输出,String... $路径) throws IOException {
            Main.Arguments $参数 = new Main.Arguments();
            $参数.strictNameCheck = false;
            $参数.fileNames = 文件工具.检查地址($路径);
            $参数.outName = 文件工具.检查地址($输出);
            Main.run($参数);

    }
    
    public static void 单个(String $文件,String $类名,String $输出) throws IOException {
        byte[] $字节 = 字节工具.读取($文件);
        DexOptions dexOptions = new DexOptions();
        com.android.dx.dex.file.DexFile dexFile = new com.android.dx.dex.file.DexFile(dexOptions);
        DirectClassFile classFile = new DirectClassFile($字节, $类名.replace('.', '/') + ".class", true);
        classFile.setAttributeFactory(StdAttributeFactory.THE_ONE);
        classFile.getMagic();
        dexFile.add(CfTranslator.translate(classFile, null, new CfOptions(), dexOptions, dexFile));
        Dex dex = new Dex(dexFile.toDex(null, false));
        dex.writeTo(文件工具.取文件对象($输出));
    }

    public static void 合成(String... $所有) throws IOException {
      
            DexMerger.main(文件工具.检查地址($所有));
       
    }
}

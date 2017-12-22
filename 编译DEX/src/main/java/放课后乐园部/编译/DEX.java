package 放课后乐园部.编译;

import com.android.dx.command.dexer.*;
import com.android.dx.merge.*;
import 放课后乐园部.基本.*;
import java.io.*;
import com.android.dx.dex.cf.*;

public class DEX {

    private DEX() {}

    public static void dex(String $输出,String... $路径) throws IOException {
     
            Main.Arguments $参数 = new Main.Arguments();
            $参数.strictNameCheck = false;
            $参数.fileNames = 文件.检查地址($路径);
            $参数.outName = 文件.检查地址($输出);
            Main.run($参数);

    }

    public static void 合成(String... $所有) throws IOException {
      
            DexMerger.main(文件.检查地址($所有));
       
    }
}

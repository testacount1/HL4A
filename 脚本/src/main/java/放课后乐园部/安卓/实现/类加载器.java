package 放课后乐园部.安卓.实现;

import com.android.dex.*;
import com.android.dx.cf.direct.*;
import com.android.dx.dex.*;
import com.android.dx.dex.cf.*;
import com.android.dx.merge.*;
import java.io.*;
import org.mozilla.javascript.*;
import 放课后乐园部.工具.*;
import 放课后乐园部.安卓.工具.*;
import dalvik.system.*;

public class 类加载器 extends ClassLoader implements GeneratedClassLoader {

    @Override
    public void linkClass(Class<?> cl) {
    }

    public 类加载器(ClassLoader $父加载器) {
        super($父加载器);
    }

    public Class 取类(String $类名) {
        try {
            return 反射工具.取类($类名, this);
        } catch (Exception $错误) {}
        return null;
    }

    Dex oldDex;

    @Override
    public Class<?> defineClass(String name,byte[] data) {
        try {
            DexOptions dexOptions = new DexOptions();
            com.android.dx.dex.file.DexFile dexFile = new com.android.dx.dex.file.DexFile(dexOptions);
            DirectClassFile classFile = new DirectClassFile(data, name.replace('.', '/') + ".class", true);
            classFile.setAttributeFactory(StdAttributeFactory.THE_ONE);
            classFile.getMagic();
            dexFile.add(CfTranslator.translate(classFile, null, new CfOptions(), dexOptions, dexFile));
            Dex dex = new Dex(dexFile.toDex(null, false));
            if (oldDex != null) {
                dex = new DexMerger(dex, oldDex, CollisionPolicy.KEEP_FIRST).merge();
            }
            return loadClass(dex, name);
        } catch (IOException | ClassNotFoundException e) {
            throw new FatalLoadingException(e);
        }
    }

    public String 保存DEX = 安卓文件.取数据目录("缓存/DX");

    public Class<?> loadClass(Dex dex,String name) throws ClassNotFoundException {
        try {
            oldDex = dex;
            dex.writeTo(new File(保存DEX + "/js.dex"));
            return new DexClassLoader(保存DEX + "js.dex", 保存DEX, "", getClass().getClassLoader()).loadClass(name);
        } catch (IOException e) {}
        return null;
    }

    @Override
    public Class<?> loadClass(String name,boolean resolve)
    throws ClassNotFoundException {
        Class<?> loadedClass = findLoadedClass(name);
        if (loadedClass == null) {
            Dex dex = oldDex;
            if (dex != null) {
                loadedClass = loadClass(dex, name);
            }
            if (loadedClass == null) {
                loadedClass = getParent().loadClass(name);
            }
        }
        return loadedClass;
    }

    /**
     * Might be thrown in any Rhino method that loads bytecode if the loading failed
     */
    public static class FatalLoadingException extends RuntimeException {
        FatalLoadingException(Throwable t) {
            super("Failed to define class", t);
        }
    }
}

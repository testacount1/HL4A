package 放课后乐园部.事件;

import java.io.*;
import java.util.*;

public class 打印处理 extends PrintStream {

    private 通用方法 事件;

    public 打印处理(通用方法 $处理) {
        super(new ByteArrayOutputStream());
        事件 = $处理;
    }

    public void onPrint(Object... $参数) {
        调用方法.事件(事件, $参数);
    }

    @Override
    public void println() {
        onPrint();
    }

    @Override
    public void println(char c) {
        onPrint(c);
    }

    @Override
    public void println(boolean b) {
        onPrint(b);
    }

    @Override
    public void print(boolean b) {
        onPrint(b);
    }

    @Override
    public void print(Object o) {
        onPrint(o);
    }

    @Override
    public void print(float f) {
        onPrint(f);
    }

    @Override
    public void print(long l) {
        onPrint(l);
    }

    @Override
    public void print(int i) {
        onPrint(i);
    }

    @Override
    public void print(double d) {
        onPrint(d);
    }

    @Override
    public void print(String str) {
        onPrint(str);
    }

    @Override
    public void print(char[] chars) {
        onPrint(chars.toString());
    }

    @Override
    public void println(double d) {
        onPrint(d);
    }

    @Override
    public void println(int i) {
        onPrint(i);
    }

    @Override
    public void println(String str) {
        onPrint(str);
    }

    @Override
    public void println(float f) {
        onPrint(f);
    }

    @Override
    public void print(char c) {
        onPrint(c);
    }

    @Override
    public void println(Object o) {
        onPrint(o);
    }

    @Override
    public void println(char[] chars) {
        onPrint(chars.toString());
    }

    @Override
    public void println(long l) {
        onPrint(l);
    }

    @Override
    public PrintStream printf(String format, Object[] args) {
        onPrint(String.format(format, args));
        return this;
    }

    @Override
    public PrintStream printf(Locale l, String format, Object[] args) {
        onPrint(String.format(l, format, args));
        return this;
    }

}

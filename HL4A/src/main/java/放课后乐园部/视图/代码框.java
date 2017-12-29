package 放课后乐园部.视图;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.view.*;
import com.myopicmobile.textwarrior.android.*;
import com.myopicmobile.textwarrior.common.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.基本.*;
import 放课后乐园部.视图.事件.*;
import 放课后乐园部.视图.实现.*;
import 放课后乐园部.收集.*;

public class 代码框 extends FreeScrollingTextField  {

    private boolean _isWordWrap;
    private Context mContext;
    private int _index;

    public 通用方法 选中文本事件;

    public 代码框(Context $上下文) {
        super($上下文);
        视图实现.初始化控件(this);
        mContext = $上下文;
        setTypeface(Typeface.MONOSPACE);
        setTextSize(转换.dp(12).intValue());
        setShowLineNumbers(true);
        setHighlightCurrentRow(true);
        setWordWrap(false);
        setAutoIndentWidth(2);
        Lexer.setLanguage(LanguageLua.getInstance());
        setNavigationMethod(new YoyoNavigationMethod(this));
        int textColor = 视图.检查颜色(主题.基本色()); // 默认文字
        置文本颜色(textColor);

        

    }

    public 代码框 置代码选中事件(通用方法 $方法) {
        setOnSelectionChangedListener(new 代码选中($方法));
        return this;
    }


    public 代码框 加入到(ViewGroup $布局) {
        视图实现.加入到(this, $布局);
        return this;
    }


    public 代码框 打开(Activity $界面) {
        视图实现.打开(this, $界面);
        return this;
    }


    public 代码框 置标签(Object $标签) {
        视图实现.置标签(this, $标签);
        return this;
    }


    public Object 取标签() {
        return 视图实现.取标签(this);
    }

    public 代码框 置单击事件(通用方法 $事件) {
        视图实现.置单击事件(this, $事件);
        return this;
    }


    public 代码框 置长按事件(通用方法 $事件) {
        视图实现.置长按事件(this, $事件);
        return this;
    }


    public 代码框 置触摸事件(通用方法 $事件) {
        视图实现.置触摸事件(this, $事件);
        return this;
    }


    public 代码框 置宽度(Object $宽度) {
        视图实现.置宽度(this, $宽度);
        return this;
    }


    public 代码框 置高度(Object $高度) {
        视图实现.置高度(this, $高度);
        return this;
    }


    public 代码框 置状态(String $状态) {
        视图实现.置状态(this, $状态);
        return this;
    }


    public String 取状态() {
        return 视图实现.取状态(this);
    }


    public 代码框 显示() {
        视图实现.显示(this);
        return this;
    }


    public 代码框 占位() {
        视图实现.占位(this);
        return this;
    }


    public 代码框 隐藏() {
        视图实现.隐藏(this);
        return this;
    }


    public 代码框 置边距(Object $边距) {
        视图实现.置边距(this, $边距);
        return this;
    }


    public 代码框 置边距(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置边距(this, $上, $下, $左, $右);
        return this;
    }


    public 代码框 置上边距(Object $边距) {
        视图实现.置上边距(this, $边距);
        return this;
    }


    public 代码框 置下边距(Object $边距) {
        视图实现.置下边距(this, $边距);
        return this;
    }


    public 代码框 置左边距(Object $边距) {
        视图实现.置左边距(this, $边距);
        return this;
    }


    public 代码框 置右边距(Object $边距) {
        视图实现.置右边距(this, $边距);
        return this;
    }


    public 代码框 置填充(Object $填充) {
        视图实现.置填充(this, $填充);
        return this;
    }


    public 代码框 置填充(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置填充(this, $上, $下, $左, $右);
        return this;
    }


    public 代码框 置上填充(Object $填充) {
        视图实现.置上填充(this, $填充);
        return this;
    }


    public 代码框 置下填充(Object $填充) {
        视图实现.置下填充(this, $填充);
        return this;
    }


    public 代码框 置左填充(Object $填充) {
        视图实现.置左填充(this, $填充);
        return this;
    }


    public 代码框 置右填充(Object $填充) {
        视图实现.置右填充(this, $填充);
        return this;
    }

    protected void onLayout(boolean changed,int left,int top,int right,int bottom) {
        // TODO: Implement this method
        super.onLayout(changed, left, top, right, bottom);
        if (_index != 0 && right > 0) {
            moveCaret(_index);
            _index = 0;
        }
    }

    public 代码框 添加类(String name,String[] names) {
        LanguageLua lang=(LanguageLua) Lexer.getLanguage();
        lang.addBasePackage(name, names);
        Lexer.setLanguage(lang);
        respan();
        invalidate();
        return this;
    }

    public 代码框 置名称(String... name) {
        LanguageLua lang=(LanguageLua) Lexer.getLanguage();
        lang.setNames(name);
        Lexer.setLanguage(lang);
        respan();
        invalidate();
        return this;
    }

    public 代码框 setPanelBackgroundColor(int color) {
        // TODO: Implement this method
        _autoCompletePanel.setBackgroundColor(color);
        return this;
    }

    public 代码框 setPanelTextColor(int color) {
        // TODO: Implement this method
        _autoCompletePanel.setTextColor(color);
        return this;
    }

    public 代码框 置关键词颜色(int color) {
        getColorScheme().setColor(ColorScheme.Colorable.KEYWORD, color);
        return this;
    }

    public 代码框 置函数颜色(int color) {
        getColorScheme().setColor(ColorScheme.Colorable.LITERAL, color);
        return this;
    }

    public 代码框 置名称颜色(int color) {
        getColorScheme().setColor(ColorScheme.Colorable.NAME, color);
        return this;
    }

    public 代码框 置字符串颜色(int color) {
        getColorScheme().setColor(ColorScheme.Colorable.STRING, color);
		return this;
    }

    public 代码框 置符号颜色(int color) {
        getColorScheme().setColor(ColorScheme.Colorable.COMMENT, color);
		return this;
    }


    public 代码框 置背景(Object $背景) {
        置背景颜色($背景);
        return this;
    }


    public 代码框 置背景颜色(Object $颜色) {
        getColorScheme().setColor(ColorScheme.Colorable.BACKGROUND, 视图.检查颜色($颜色));
		return this;
    }

    public 代码框 置文本颜色(int color) {
        getColorScheme().setColor(ColorScheme.Colorable.FOREGROUND, color);
		return this;
    }

    public 代码框 置文本高亮颜色(int color) {
        getColorScheme().setColor(ColorScheme.Colorable.SELECTION_BACKGROUND, color);
		return this;
    }

    public String 取选中文本() {
        // TODO: Implement this method
        return  _hDoc.subSequence(getSelectionStart(), getSelectionEnd() - getSelectionStart()).toString();
    }


    public 代码框 全选() {
        selectAll();
        return this;
    }

    public 代码框 复制() {
        copy();
        return this;
    }

    public 代码框 剪切() {
        cut();
        return this;
    }

    public 代码框 粘贴() {
        paste();
        return this;
    }

    public boolean onKeyShortcut(int keyCode,KeyEvent event) {
        final int filteredMetaState = event.getMetaState() & ~KeyEvent.META_CTRL_MASK;
        if (KeyEvent.metaStateHasNoModifiers(filteredMetaState)) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_A:
                    selectAll();
                    return true;
                case KeyEvent.KEYCODE_X:
                    cut();
                    return true;
                case KeyEvent.KEYCODE_C:
                    copy();
                    return true;
                case KeyEvent.KEYCODE_V:
                    paste();
                    return true;
            }
        }
        return super.onKeyShortcut(keyCode, event);
    }


    public 代码框 置文字包装(boolean enable) {
        _isWordWrap = enable;
        super.setWordWrap(enable);
        return this;
    }

    public String 取文本() {
        return createDocumentProvider().toString();
    }

    public 代码框 插入(String text) {
        selectText(false);
        paste(text);
        return this;
    }

    public 代码框 置文本(CharSequence c,boolean isRep) {
        replaceText(0, getLength() - 1, c.toString());
        return this;
    }

    public 代码框 置文本(CharSequence c) {
        Document doc=new Document(this);
        doc.setWordWrap(_isWordWrap);
        doc.setText(c);
        setDocumentProvider(new DocumentProvider(doc));
        return this;
    }

    public 代码框 setSelection(int index) {
        selectText(false);
        if (!hasLayout())
            moveCaret(index);
        else
            _index = index;
        return this;
    }


    public 代码框 撤销() {
        DocumentProvider doc = createDocumentProvider();
        int newPosition = doc.undo();

        if (newPosition >= 0) {
            //TODO editor.setEdited(false); if reached original condition of file
            setEdited(true);

            respan();
            selectText(false);
            moveCaret(newPosition);
            invalidate();
        }
        return this;
    }

    public 代码框 重做() {
        DocumentProvider doc = createDocumentProvider();
        int newPosition = doc.redo();

        if (newPosition >= 0) {
            setEdited(true);

            respan();
            selectText(false);
            moveCaret(newPosition);
            invalidate();
        }
        return this;

    }

    public 代码框 读入(String $文件) {
        if (文件.是文件($文件))
            置文本(字符.读取($文件));
        return this;
    }

    /**
     * 保存文件
     * * @param file
     */
    public 代码框 保存(String $文件) {
        字符.保存($文件, 取文本());
        return this;
    }



}

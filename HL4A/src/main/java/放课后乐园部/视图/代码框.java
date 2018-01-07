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
        setAutoIndentWidth(0);
        Lexer.setLanguage(LanguageLua.getInstance());
        setNavigationMethod(new YoyoNavigationMethod(this));
        int textColor = 视图.检查颜色(主题.基本色()); // 默认文字
        置文本颜色(textColor);

        

    }

    public void 置代码选中事件(通用方法 $方法) {
        setOnSelectionChangedListener(new 代码选中($方法));
    }


    public void 加入到(ViewGroup $布局) {
        视图实现.加入到(this, $布局);
    }


    public void 打开(Activity $界面) {
        视图实现.打开(this, $界面);
    }


    public void 置标签(Object $标签) {
        视图实现.置标签(this, $标签);
    }


    public Object 取标签() {
        return 视图实现.取标签(this);
    }

    public void 置单击事件(通用方法 $事件) {
        视图实现.置单击事件(this, $事件);
    }


    public void 置长按事件(通用方法 $事件) {
        视图实现.置长按事件(this, $事件);
    }


    public void 置触摸事件(通用方法 $事件) {
        视图实现.置触摸事件(this, $事件);
    }


    public void 置宽度(Object $宽度) {
        视图实现.置宽度(this, $宽度);
    }


    public void 置高度(Object $高度) {
        视图实现.置高度(this, $高度);
    }


    public void 置状态(String $状态) {
        视图实现.置状态(this, $状态);
    }


    public String 取状态() {
        return 视图实现.取状态(this);
    }


    public void 显示() {
        视图实现.显示(this);
    }


    public void 占位() {
        视图实现.占位(this);
    }


    public void 隐藏() {
        视图实现.隐藏(this);
    }


    public void 置边距(Object $边距) {
        视图实现.置边距(this, $边距);
    }


    public void 置边距(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置边距(this, $上, $下, $左, $右);
    }


    public void 置上边距(Object $边距) {
        视图实现.置上边距(this, $边距);
    }


    public void 置下边距(Object $边距) {
        视图实现.置下边距(this, $边距);
    }


    public void 置左边距(Object $边距) {
        视图实现.置左边距(this, $边距);
    }


    public void 置右边距(Object $边距) {
        视图实现.置右边距(this, $边距);
    }


    public void 置填充(Object $填充) {
        视图实现.置填充(this, $填充);
    }


    public void 置填充(Object $上,Object $下,Object $左,Object $右) {
        视图实现.置填充(this, $上, $下, $左, $右);
    }


    public void 置上填充(Object $填充) {
        视图实现.置上填充(this, $填充);
    }


    public void 置下填充(Object $填充) {
        视图实现.置下填充(this, $填充);
    }


    public void 置左填充(Object $填充) {
        视图实现.置左填充(this, $填充);
    }


    public void 置右填充(Object $填充) {
        视图实现.置右填充(this, $填充);
    }

    protected void onLayout(boolean changed,int left,int top,int right,int bottom) {
        // TODO: Implement this method
        super.onLayout(changed, left, top, right, bottom);
        if (_index != 0 && right > 0) {
            moveCaret(_index);
            _index = 0;
        }
    }

    public void 添加类(String name,String[] names) {
        LanguageLua lang=(LanguageLua) Lexer.getLanguage();
        lang.addBasePackage(name, names);
        Lexer.setLanguage(lang);
        respan();
        invalidate();
    }

    public void 置名称(String... name) {
        LanguageLua lang=(LanguageLua) Lexer.getLanguage();
        lang.setNames(name);
        Lexer.setLanguage(lang);
        respan();
        invalidate();
    }

    public void setPanelBackgroundColor(int color) {
        // TODO: Implement this method
        _autoCompletePanel.setBackgroundColor(color);
    }

    public void setPanelTextColor(int color) {
        // TODO: Implement this method
        _autoCompletePanel.setTextColor(color);
    }

    public void 置关键词颜色(int color) {
        getColorScheme().setColor(ColorScheme.Colorable.KEYWORD, color);
    }

    public void 置函数颜色(int color) {
        getColorScheme().setColor(ColorScheme.Colorable.LITERAL, color);
    }

    public void 置名称颜色(int color) {
        getColorScheme().setColor(ColorScheme.Colorable.NAME, color);
    }

    public void 置字符串颜色(int color) {
        getColorScheme().setColor(ColorScheme.Colorable.STRING, color);
    }

    public void 置符号颜色(int color) {
        getColorScheme().setColor(ColorScheme.Colorable.COMMENT, color);
    }


    public void 置背景(Object $背景) {
        置背景颜色($背景);
    }


    public void 置背景颜色(Object $颜色) {
        getColorScheme().setColor(ColorScheme.Colorable.BACKGROUND, 视图.检查颜色($颜色));
    }
	
    public void 置文本颜色(int color) {
        getColorScheme().setColor(ColorScheme.Colorable.FOREGROUND, color);
    }

    public void 置文本高亮颜色(int color) {
        getColorScheme().setColor(ColorScheme.Colorable.SELECTION_BACKGROUND, color);
    }

    public String 取选中文本() {
        // TODO: Implement this method
        return  _hDoc.subSequence(getSelectionStart(), getSelectionEnd() - getSelectionStart()).toString();
    }


    public void 全选() {
        selectAll();
    }

    public void 复制() {
        copy();
    }

    public void 剪切() {
        cut();
    }

    public void 粘贴() {
        paste();
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


    public void 置文字包装(boolean enable) {
        _isWordWrap = enable;
        super.setWordWrap(enable);
    }

    public String 取文本() {
        return createDocumentProvider().toString();
    }

    public void 插入(String text) {
        selectText(false);
        paste(text);
    }

    public void 置文本(CharSequence c,boolean isRep) {
        replaceText(0, getLength() - 1, c.toString());
    }

    public void 置文本(CharSequence c) {
        Document doc=new Document(this);
        doc.setWordWrap(_isWordWrap);
        doc.setText(c);
        setDocumentProvider(new DocumentProvider(doc));
    }

    public void setSelection(int index) {
        selectText(false);
        if (!hasLayout())
            moveCaret(index);
        else
            _index = index;
    }


    public void 撤销() {
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
    }

    public void 重做() {
        DocumentProvider doc = createDocumentProvider();
        int newPosition = doc.redo();

        if (newPosition >= 0) {
            setEdited(true);

            respan();
            selectText(false);
            moveCaret(newPosition);
            invalidate();
        }

    }

    public void 读入(String $文件) {
        if (文件.是文件($文件))
            置文本(字符.读取($文件));
    }

    /**
     * 保存文件
     * * @param file
     */
    public void 保存(String $文件) {
        字符.保存($文件, 取文本());
    }



}

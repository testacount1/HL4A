package 放课后乐园部.安卓.工具;

import android.content.res.*;
import android.graphics.*;
import android.text.*;
import android.view.*;
import 放课后乐园部.工具.*;

public class 视图工具 {

	public static int 计算宽度(String $字符串,Object $大小) {
		Paint pFont = new Paint(); 
		Rect rect = new Rect();
		pFont.setTextSize(视图工具.检查大小($大小));
		pFont.getTextBounds($字符串, 0, 1, rect); 
		return  rect.width();
	}
	
	public static int 计算高度(String $字符串,Object $大小) {
		Paint pFont = new Paint(); 
		Rect rect = new Rect();
		pFont.setTextSize(视图工具.检查大小($大小));
		pFont.getTextBounds($字符串, 0, 1, rect); 
		return  rect.width();
	}
	
	public static ColorStateList 创建颜色列表(Object $普通颜色,Object $按下颜色) {
        int $普通 = 检查颜色($普通颜色);
        int $按下 = 检查颜色($按下颜色);
		int[] $颜色 = new int[] {$按下,$普通};int[][] $状态 = new int[2][];
		$状态[0] = new int[] { android.R.attr.state_pressed};
		$状态[1] = new int[] {}; 
		return new ColorStateList($状态, $颜色);
	}
    
    public static ColorStateList 创建单颜色列表(Object $普通颜色) {
        int $普通 = 检查颜色($普通颜色);
        int[] $颜色 = new int[] {$普通};
        int[][] $状态 = new int[1][];
        $状态[0] = new int[] {}; 
        return new ColorStateList($状态, $颜色);
	}

    public static Integer 检查输入类型(Object $类型) {
        if ($类型 instanceof Integer) return (Integer)$类型;
        if ($类型 instanceof String)
            switch ((String)$类型) {
                case "文本":return InputType.TYPE_CLASS_TEXT;
                case "手机":return InputType.TYPE_CLASS_PHONE;
                case "数字":return InputType.TYPE_CLASS_NUMBER;
                case "日期":return InputType.TYPE_CLASS_DATETIME;
                case "日期-日期":return InputType.TYPE_DATETIME_VARIATION_DATE;
                case "日期-普通":return InputType.TYPE_DATETIME_VARIATION_NORMAL;
                case "日期-时间":return InputType.TYPE_DATETIME_VARIATION_TIME;
                case "数字-十进制":return InputType.TYPE_NUMBER_FLAG_DECIMAL;
                case "数字-带符号":return InputType.TYPE_NUMBER_FLAG_SIGNED;
                case "数字-普通":return InputType.TYPE_NUMBER_VARIATION_NORMAL;
                case "数字-密码":return InputType.TYPE_NUMBER_VARIATION_PASSWORD;
                case "文本-自动完成":return InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
                case "文本-自动矫正":return InputType.TYPE_TEXT_FLAG_AUTO_CORRECT;
                case "文本-大写字符":return InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS;
                case "文本-大写句子":return InputType.TYPE_TEXT_FLAG_CAP_SENTENCES;
                case "文本-大写单词":return InputType.TYPE_TEXT_FLAG_CAP_WORDS;
                case "文本-邮箱":return InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;
                case "文本-邮件":return InputType.TYPE_TEXT_VARIATION_EMAIL_SUBJECT;
                case "文本-长信息":return InputType.TYPE_TEXT_VARIATION_LONG_MESSAGE;
                case "文本-普通":return InputType.TYPE_TEXT_VARIATION_NORMAL;
                case "文本-密码":return InputType.TYPE_TEXT_VARIATION_PASSWORD;
                case "文本-人名":return InputType.TYPE_TEXT_VARIATION_PERSON_NAME;
                case "文本-联系人":return InputType.TYPE_TEXT_VARIATION_POSTAL_ADDRESS;
                case "文本-短信":return InputType.TYPE_TEXT_VARIATION_SHORT_MESSAGE;
                case "文本-链接":return InputType.TYPE_TEXT_VARIATION_URI;
                case "文本-密码-显示":return InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;
                case "文本-网页-编辑框":return InputType.TYPE_TEXT_VARIATION_WEB_EDIT_TEXT;
                case "文本-网页-邮箱":return InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS;
                case "文本-网页-密码":return InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD;
            }
        return InputType.TYPE_NULL;
    }

    public static Integer 检查颜色(Object $颜色) {
        if ($颜色 instanceof Integer)
            return (Integer) $颜色;
        if ($颜色 instanceof String && 字符工具.以开始((String)$颜色, "#"))
            return 颜色工具.转换((String)$颜色);
        return null;
    }

    public static Integer 检查大小(Object $大小) {
        if ($大小 == null) return null;
        if ($大小 instanceof Float) return ((Float)$大小).intValue();
        if ($大小 instanceof Integer) return (Integer) $大小;
        if ($大小 instanceof String) {
            switch ((String)$大小) {
                case "最大":case "填充":case "-1":return -1;
                case "最小":case "自动":case "-2":return -2;
            }
            String $结束 = 字符工具.小写(字符工具.取结束后((String)$大小, 2));
            Integer $数量 = new Integer(字符工具.取结束前((String)$大小, 2));
            switch ($结束) {
                case "px":return 转换工具.px($数量);
                case "dp":return 转换工具.dp($数量);
                case "sp":return 转换工具.sp($数量);
                case "pt":return 转换工具.pt($数量);
                case "mm":return 转换工具.mm($数量);
                case "in":return 转换工具.in($数量);
            }
        }
        return -2;
    }

    public static Integer 检查重力(String $重力) {
        Integer $重力类型 = Gravity.NO_GRAVITY;
        String[] $设置 = $重力.toLowerCase().split("[|]");
        for (String $单个 : $设置) {
            switch ($单个) {
                case "start":case "开始":
                    $重力类型 = $重力类型 | Gravity.START;
                    break;
                case "end":case "结束":
                    $重力类型 = $重力类型 | Gravity.START;
                    break;
                case "center":case "中间":
                    $重力类型 = $重力类型 | Gravity.CENTER;
                    break;
                case "left":case "左边":
                    $重力类型 = $重力类型 | Gravity.LEFT;
                    break;
                case "textStart":case "文本开始":
                    $重力类型 = $重力类型 | Gravity.START;
                    break;
                case "right":case "右边":
                    $重力类型 = $重力类型 | Gravity.RIGHT;
                    break;
                case "textEnd":case "文本结束":
                    $重力类型 = $重力类型 | Gravity.END;
                    break;
                case "top":case "上边":
                    $重力类型 = $重力类型 | Gravity.TOP;
                    break;
                case "bottom":case "下边":
                    $重力类型 = $重力类型 | Gravity.BOTTOM;
                    break;
                case "center_horizontal":case "中左":case "中间水平":
                    $重力类型 = $重力类型 | Gravity.CENTER_HORIZONTAL;
                    break;
                case "center_vertical":case "中上":case "中间垂直":
                    $重力类型 = $重力类型 | Gravity.CENTER_VERTICAL;
                    break;
            }
        }
        return $重力类型;
    }

}

package 放课后乐园部.视图.实现;
import android.widget.*;

public interface 编辑框摘要 extends 文本摘要 {
		
		public 编辑框摘要 置默认文本(String $文本);
		public String 取默认文本();
		public 编辑框摘要 置默认文本颜色(Object $颜色);
		
		public 编辑框摘要 置输入类型(Object $类型);
		public int 取输入类型();
		
		public 编辑框摘要 置输入重力(String $重力);
		
		/*

		@Override
		public 编辑框摘要 置默认文本(String $文本) {
				编辑框实现.置默认文本(this ,$文本);
				return this;
		}

		@Override
		public String 取默认文本() {
				return 编辑框实现.取默认文本(this);
		}

		@Override
		public 编辑框摘要 置默认文本颜色(Object $颜色) {
				编辑框实现.置默认文本颜色(this,$颜色);
				return this;
		}

		@Override
		public 编辑框摘要 置输入类型(Object $类型) {
				编辑框实现.置输入类型(this,$类型);
				return this;
		}

		@Override
		public int 取输入类型() {
				return 编辑框实现.取输入类型(this);
		}

		@Override
		public 编辑框摘要 置输入重力(String $重力) {
				编辑框实现.置输入重力(this,$重力);
				return this;
		}
		
		*/
		
}

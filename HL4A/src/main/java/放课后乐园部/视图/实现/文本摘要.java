package 放课后乐园部.视图.实现;

import android.graphics.*;
import 放课后乐园部.事件.*;

public interface 文本摘要 extends 视图摘要 {

		public 文本摘要 置文本(String $文本);
		public 文本摘要 置HTML文本(String $HTML);
		public String 取文本();

		public 文本摘要 置文本大小(Object $大小);
		public 文本摘要 置文本颜色(Object $颜色);
		public 文本摘要 置文本字体(String $地址);
		public 文本摘要 置文本字体(Typeface $字体);
		public 文本摘要 置文本重力(String $重力);

		public 文本摘要 置文本显示在同一行();
		public 文本摘要 置文本显示在同一行(Boolean $是否);

		public 文本摘要 置行数(int $行数);
		public 文本摘要 置最小行数(int $行数);
		public 文本摘要 置最大行数(int $行数);

		public 文本摘要 置链接可点击();
		public 文本摘要 置链接可点击(Boolean $是否);
		public 文本摘要 置链接颜色(Object $颜色);

		public 文本摘要 置文本改变事件(通用方法 $事件);
		public 文本摘要 置文本改变事件(通用方法 $改变前,通用方法 $已改变,通用方法 $改变后);


		/*
		@Override
		public 文本摘要 置文本(String $文本) {
				文本实现.置文本(this, $文本);
				return this;
		}

		@Override
		public 文本摘要 置HTML文本(String $HTML) {
				文本实现.置HTML文本(this, $HTML);
				return this;
		}

		@Override
		public String 取文本() {
				return 文本实现.取文本(this);
		}

		@Override
		public 文本摘要 置文本大小(Object $大小) {
				文本实现.置文本大小(this, $大小);
				return this;
		}

		@Override
		public 文本摘要 置文本颜色(Object $颜色) {
				文本实现.置文本颜色(this, $颜色);
				return this;
		}

		@Override
		public 文本摘要 置文本字体(String $地址) {
				文本实现.置文本字体(this, $地址);
				return this;
		}

		@Override
		public 文本摘要 置文本字体(Typeface $字体) {
				文本实现.置文本字体(this, $字体);
				return this;
		}

		@Override
		public 文本摘要 置文本重力(String $重力) {
				文本实现.置文本重力(this, $重力);
				return this;
		}

		@Override
		public 文本摘要 置文本显示在同一行() {
				文本实现.置文本显示在同一行(this);
				return this;
				
		}

		@Override
		public 文本摘要 置文本显示在同一行(Boolean $是否) {
				文本实现.置文本显示在同一行(this, $是否);
				return this;
		}

		@Override
		public 文本摘要 置行数(int $行数) {
				文本实现.置行数(this, $行数);
				return this;
		}

		@Override
		public 文本摘要 置最小行数(int $行数) {
				文本实现.置最小行数(this, $行数);
				return this;
		}

		@Override
		public 文本摘要 置最大行数(int $行数) {
				文本实现.置最大行数(this, $行数);
				return this;
		}

		@Override
		public 文本摘要 置链接可点击() {
				文本实现.置链接可点击(this);
				return this;
		}

		@Override
		public 文本摘要 置链接可点击(Boolean $是否) {
				文本实现.置链接可点击(this, $是否);
				return this;
		}

		@Override
		public 文本摘要 置链接颜色(Object $颜色) {
				文本实现.置链接颜色(this, $颜色);
				return this;
		}

		@Override
		public 文本摘要 置文本改变事件(通用事件 $事件) {
				文本实现.置文本改变事件(this, $事件);
				return this;
		}

		@Override
		public 文本摘要 置文本改变事件(通用事件 $改变前,通用事件 $已改变,通用事件 $改变后) {
				文本实现.置文本改变事件(this, $改变前, $已改变, $改变后);
				return this;
		}
		
		*/

}

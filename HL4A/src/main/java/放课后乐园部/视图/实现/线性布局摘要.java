package 放课后乐园部.视图.实现;

import android.view.*;

public interface 线性布局摘要 extends 视图摘要 {

		public 线性布局摘要 置方向(String $方向);
		public 线性布局摘要 置重力(String $重力);

		public 线性布局摘要 加入子元素(View $子元素)
		public View 取子元素从标签(Object $标签);
		public View 取子元素从键值(int $键值);
		public View[] 取所有子元素();

		/*
		
		@Override
		public 线性布局摘要 置重力(String $重力) {
				线性布局实现.置重力(this, $重力);
				return this;
		}
		

		@Override
		public 线性布局摘要 置方向(String $方向) {
				线性布局实现.置方向(this, $方向);
				return this;
		}
		
		@Override
		public 线性布局摘要 加入子元素(View $子元素) {
				线性布局实现.加入子元素(this, $子元素);
				return this;
		}

		@Override
		public View 取子元素从标签(Object $标签) {
				return 线性布局实现.取子元素从标签(this, $标签);
		}
		
		@Override
		public View 取子元素从键值(int $键值) {
				return 线性布局实现.取子元素从键值(this, $键值);
		}

		@Override
		public View[] 取所有子元素() {
				return 线性布局实现.取所有子元素(this);
		}
		
		*/

}

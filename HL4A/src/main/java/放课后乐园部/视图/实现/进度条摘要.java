package 放课后乐园部.视图.实现;

public interface 进度条摘要 extends 视图摘要 {

		public 进度条摘要 置进度(int $进度);
		public 进度条摘要 置二级进度(int $进度);
		public 进度条摘要 置进度颜色(Object $颜色);

		public int 取进度();
		public int 取二级进度();

		/*
		
		@Override
		public 进度条 置进度(int $进度) {
				进度条实现.置进度(this, $进度);
				return this;
		}

		@Override
		public 进度条 置二级进度(int $进度) {
				进度条实现.置二级进度(this, $进度);
				return this;
		}

		@Override
		public 进度条 置进度颜色(Object $颜色) {
				进度条实现.置进度颜色(this, $颜色);
				return this;
		}

		@Override
		public int 取进度() {
				return 进度条实现.取进度(this);
		}

		@Override
		public int 取二级进度() {
				return 进度条实现.取二级进度(this);
		}
		
		*/

}

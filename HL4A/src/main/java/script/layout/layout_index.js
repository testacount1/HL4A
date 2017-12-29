var layout_index = layout_index || function(_界面) {

this.__proto__ = new Layout(_界面);
//super(Context);

this.刷新 = new 下拉刷新布局(_界面)
.置填充("16dp")
.加入到(this.布局);

this.列表 = new 基本列表(_界面)
.加入到(this.刷新);

this.打开();

return this;

}

var layout_index_edit = function(_界面) {

this.布局 = new 线性布局(_界面);

this.编辑 = new 编辑框(_界面)
.加入到(this.布局);

return this;

}
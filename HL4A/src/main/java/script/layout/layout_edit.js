var layout_edit = layout_edit || function(_界面) {

this.__proto__ = new Layout(_界面);

this.符号 = new 符号栏(_界面);

this.操作栏 = 线性布局(_界面)
.置高度("自动")
.加入到(this.符号.底层);

this.辅助 = 线性布局(_界面)
.置宽度("自动")
.置方向("水平")
.加入到(this.符号.底层);

function addB(_vg,_n,_d) {
return new 线性布局(_界面)
.置宽度("自动")
.置高度("自动")
.置背景("透明")
.置重力("中间")
.置填充("6dp","8dp","16dp","8dp")
.置单击事件(_d)
.加入子元素(new 文本控件(_界面)
.置标签("文本")
.置文本颜色(颜色.白色)
.置文本(_n))
.加入到(_vg);
}

导入("@lib/unicode.js");

addB(this.辅助,"编码",function(){
_代码框.置文本(unicode编码(_代码框.取文本()));
});

addB(this.辅助,"解码",function(){
_代码框.置文本(unicode解码(_代码框.取文本()));
});

this.符号.符号单击事件 = function(_参数) {
_代码框.插入(_参数[0].取文本());
}

this.符号.更新().加入到(this.布局);

this.代码框 = new 代码框(_界面).加入到(this.布局);

let _代码框 = this.代码框;

this.打开();

return this;

}
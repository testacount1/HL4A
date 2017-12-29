var Layout = Layout || function(_界面) {

this.底层 = new 线性布局(_界面).置背景("白色");

this.标题 = new 标题栏(_界面,应用.取应用名()).加入到(this.底层)

this.布局 = new 线性布局(_界面).加入到(this.底层);

this.打开 = () => {
_界面.打开布局(this.底层);
return this;
}

this.创建菜单 = (_菜单) => {

if (_菜单 == null) _菜单 = Menu;

let _按钮 = this.标题.右按钮(function() {
_菜单.显示();
});

_菜单 = new _菜单(_按钮);

return _菜单;

}

return this;

}
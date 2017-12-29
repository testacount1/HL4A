var Menu = Menu || function(_按钮) {

this.菜单 = new 菜单(_按钮);

this.添加 = (_项目,_单击,_长按) => {
if (_长按 != null) {
this.菜单.添加(_项目,_单击,_长按);
} else {
this.菜单.添加(_项目,_单击);
}
}

this.显示 = (_位置) => {
if (_位置 == null) {
_位置 = "左下";
}
this.菜单.显示(_位置);
}

this.隐藏 = () => {
this.菜单.隐藏();
}

this.加载菜单 = (_参数) => {
for (let _键值 in _参数) {
let _方法 = _参数[_键值];
this.添加(_键值,function() {
_方法();
});
}
return this;
}

return this;

}


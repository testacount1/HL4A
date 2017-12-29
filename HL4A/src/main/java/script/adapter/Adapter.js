var Adapter = Adapter || function() {

let 列表 = null;
let 适配器 = null;

this.设置 = (_列表,_适配器) => {
列表 = _列表;
适配器 = _适配器;
}

this.添加 = (_参数) => {
列表.添加视图(适配器(_参数));
return this;
}

this.清空 = () => {
列表.清空();
return this;
}

return this;

}
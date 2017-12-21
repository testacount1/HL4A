// JS的依赖文件，请不要手动运行
// By MikaGuraN 2017

var h = Packages.放课后乐园部;

var 导入文件 = 当前环境.运行文件;
var 导入包 = importPackage;
var 导入类 = importClass;

导入包(h.基本);
导入包(h.网络);
导入包(h.事件);
导入包(h.反射);
导入包(h.收集);
导入包(h.视图);
导入包(h.视图.扩展);
导入包(h.视图.列表);

var 导入 = function (_内容) {
if (文件.是文件(_内容))
return 导入文件(_内容);
} else if (反射.取类(_内容)) {
return 导入类(_内容);
} else {
导入包(_内容);
}
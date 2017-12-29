// JS的依赖文件，请不要手动运行
// By MikaGuraN 2017

var h = Packages.放课后乐园部;

var 导入包 = importPackage;
var 导入类 = importClass;
var 扩类 = JavaImporter;

导入包(
java.lang,
java.io,
java.util,
android.os,
android.content
);

导入包(
h.基本,
h.网络,
h.事件,
h.反射,
h.收集,
h.视图,
h.视图.扩展,
h.视图.列表);

var 导入文件 = function(_文件) {
if (文件.是文件(_文件))
return 当前环境.运行文件(_文件);
}

var 导入 = function (_内容) {
if (文件.是文件(_内容)) {
导入文件(_内容);
} else if (反射.取类(_内容)) {
导入类(_内容);
} else {
导入包(_内容);
}
}
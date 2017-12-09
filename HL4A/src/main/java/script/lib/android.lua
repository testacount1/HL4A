-- 这是Lua的依赖文件，请不要手动运行
-- By MikaGuraN 2017

local 反射 = luajava.bindClass "放课后乐园部.基本.反射";

local 泛导入表 = {
"java.lang";
"java.util";
"java.io";
"android.content";
"android.os";
"android.widget";
"android.view";
"放课后乐园部.基本";
"放课后乐园部.网络";
"放课后乐园部.事件";
"放课后乐园部.反射";
"放课后乐园部.视图";
"放课后乐园部.收集";
"放课后乐园部.视图";
"放课后乐园部.视图.扩展";
};

导入 = 当前环境.运行文件;

function 导入泛类(_类)
table.insert(泛导入表,_类);
end

function 导入类(_类)
if _类 then
local _类名 = _类:match('([%w_]+)$');
local _类对象 = 反射.取类(String(_类));
if _类对象 then
_G[_类名] = _类对象;
return _类对象;
end
error("没有这个类 : ".._类);
end
end

local function 过滤类名(_类名)
if _类名:find('_') then
_类名 = _类名:gsub("__","(分隔)");
_类名 = _类名:gsub("_","$");
_类名 = _类名:gsub("(分隔)","_");
end
return _类名
end

local function 全局读取(_表,_键值)

-- 导入并返回泛类

_键值 = 过滤类名(_键值);
for _k,_v in ipairs(泛导入表) do
local _类 = 反射.取类(_v .. "." .. _键值);
if _类 then
_表[_键值] = _类;
return _类;
end
end
end

setmetatable(_G, {
__index = 全局读取;
});

function 方法(_函数)
return 通用方法 {
调用 = _函数;
}
end;

function 选择(_对象)
return function(_表)
if _表[_对象] then
if type(_表[_对象]) == "function" then
return _表[_对象]();
else
return _表[_对象];
end
end
end
end
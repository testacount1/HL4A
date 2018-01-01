return function(_文件)
local str,st = loadfile(_文件);
local _,str = pcall(string.dump,str,true)
if _ == true then
io.open(_文件,'w+b'):write(str):close();
end
end;
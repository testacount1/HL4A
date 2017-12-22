导入包 "放课后乐园部.编译";

导入包 "java.lang";
导入包 "com.android.dx.command.dexer";

function 编译项目(_工程目录,_文件名,_设置)

  local _源码 = _工程目录.."/".._文件名.."/源码";
  local _输出 = _工程目录.."/".._文件名.."/编译";

  local _文件 = JSC(_源码.."/test.js")
  .置包名(_设置.包名)
  .置输出(_输出.."/classes")
  .编译();

  线程(function()
    local _参数 = Main_Arguments();
    _参数.strictNameCheck = false;
    _参数.fileNames = _文件
    --{_输出.."/bsh.jar"};
    _参数.outName = _输出.."/classes.dex";
    _参数.jarOutput = false;
    弹窗.提示(_参数)
    Main.run(_参数);
    弹窗.提示(666)
  end,{}).启动()
end
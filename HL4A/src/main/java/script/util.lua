function 更新(_函数,...)
  local _参数 = {...};
  处理.主线程(function(args);
    _函数(table.unpack(_参数));
  end,{});
end
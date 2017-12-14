function unicode编码(str){ 
str = String(str);
return str.replace(/[^\u0000-\u00FF]/g,function($0){return escape($0).replace(/(%u)(\w{4})/gi,"\\u$2")}); 
}

function unicode解码(str){ 
str = String(str);
str = str.replace(/(\\u)(\w{1,4})/gi,function($0){ 
return (String.fromCharCode(parseInt((escape($0).replace(/(%5Cu)(\w{1,4})/g,"$2")),16))); 
}); 
str = str.replace(/(&#x)(\w{1,4});/gi,function($0){ 
return String.fromCharCode(parseInt(escape($0).replace(/(%26%23x)(\w{1,4})(%3B)/g,"$2"),16)); 
}); 
str = str.replace(/(&#)(\d{1,6});/gi,function($0){ 
return String.fromCharCode(parseInt(escape($0).replace(/(%26%23)(\d{1,6})(%3B)/g,"$2"))); 
}); 
return str; 
}
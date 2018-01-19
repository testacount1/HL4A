package 放课后乐园部.安卓.脚本;

public interface 基本脚本 {
    
    public String 取脚本类型();
    
    public void 压入变量(String $名称,Object $对象);
    
    public Object 读取对象(String $名称);
    
    public Object 执行代码(String $代码);
    
    public Object 运行文件(String $文件)
    
    public Object 调用函数(String $方法,Object... $参数);
    
}

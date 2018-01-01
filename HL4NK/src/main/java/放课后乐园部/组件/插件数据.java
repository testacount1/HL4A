package 放课后乐园部.组件;

public class 插件数据 {
    
    static 基本插件 插件;
    
    public static void 初始化(基本插件 $插件) {
        插件 = $插件;
    }
    
    public static Object 读取(String $键值) {
        return 插件.getConfig().get($键值);
    }
    
    public static void 保存(String $键值,Object $内容) {
        插件.getConfig().set($键值,$内容);
        插件.getConfig().save();
    }

    
}

package 放课后乐园部.基本;

import java.io.*;

public class 文本 {
		
		文本() {}
		
		public static String 读取(String $文件) {
				
				FileInputStream $输入流 = IO流.输入.文件($文件);
				
				String $文本 = 读取($输入流);
				
				IO流.关闭($输入流);
				
				return $文本;
				
		}
		
		public static String 读取(InputStream $输入流) {
				
				if ($输入流 == null) return null;

				return 字符.转换(IO流.读取($输入流));
				
		}
		
		public static void 保存(String $地址,String $文本) {
				
				字节.保存($地址,字节.转换($文本));
				
		}
		
		public static void 保存(OutputStream $输出流,String $内容) {
				
				字节.保存($输出流,字节.转换($内容));
				
		}
		
		public static String 转换(byte[] $字节) {
				
				return 字符.转换($字节);
				
		}
		
}

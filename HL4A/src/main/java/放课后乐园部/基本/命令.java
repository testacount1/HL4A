package 放课后乐园部.基本;
import java.io.*;

public class 命令 {

		Process 进程 = null;

		public 命令(String $命令) {
				try {
						if ($命令 == null) $命令 = "";
						进程 =  Runtime.getRuntime().exec($命令);
				} catch (Exception $错误) {}
		}

		public void 等待() {
				try {
						进程.waitFor();
				} catch (Exception $错误) {}
		}
		
		public String 读取() {
				
				InputStream $输入流 = 进程.getInputStream();
				
				String $文本 = 文本.读取($输入流);
				
				IO流.关闭($输入流);
				
				return $文本;
				
		}

}

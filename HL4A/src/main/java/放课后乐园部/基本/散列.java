package 放课后乐园部.基本;

import java.io.*;
import java.math.*;
import java.security.*;

public class 散列 {

		散列() {}
		
		public static String 摘要(String $算法,byte[] $文本) {
				
				InputStream $输入流 = IO流.输入.字节($文本);
				
				String $结果 = new BigInteger(1, 摘要($算法,$输入流)).toString(16);
				
				IO流.关闭($输入流);
				
				return $结果;
				
		}

		public static byte[] 摘要(String $算法,InputStream $输入流) {
				try {
						byte $大小[] = new byte[$输入流.available()];
						MessageDigest $摘要 = MessageDigest.getInstance($算法);
						int $长度;
						while (($长度 = $输入流.read($大小)) != -1) {
								$摘要.update($大小, 0, $长度);
						}
						return $摘要.digest();
				} catch (Exception $错误) {}
				return null;
		}

		public static String 文件(String $算法,String $文件) {
				try {
						InputStream $输入流 = IO流.输入.文件($文件);
						byte $大小[] = new byte[$输入流.available()];
						MessageDigest $摘要 = MessageDigest.getInstance($算法);
						int $长度;
						while (($长度 = $输入流.read($大小)) != -1) {
								$摘要.update($大小, 0, $长度);
						}
						IO流.关闭($输入流);
						return new BigInteger(1, $摘要.digest()).toString(16);
				} catch (Exception $错误) {}
				return null;
		}
		

}

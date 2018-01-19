package 放课后乐园部.工具;

import java.math.*;

public class 进制工具 {
	
	public static String 编码(int $进制,byte[] $字节) {
		return new BigInteger(1,$字节).toString($进制);
	}

	public static byte[] 解码(int $进制,String $字符) {
		return new BigInteger($字符,$进制).toByteArray();
	}
	
}

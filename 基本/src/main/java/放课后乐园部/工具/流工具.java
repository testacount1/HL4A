package 放课后乐园部.工具;

import java.io.*;
import java.nio.channels.*;

public class 流工具 {

	public static void 关闭(InputStream $流) {
		if ($流 == null) return;
		try {
			$流.close();
		} catch (IOException $错误) {}
	}

	public static void 关闭(OutputStream $流) {
		if ($流 == null) return;
		try {
			$流.close();
		} catch (IOException $错误) {}
	}

	public static FileLock 锁定(FileInputStream $流) {
		if ($流 == null) return null;
		try {
			return $流.getChannel().tryLock();
		} catch (IOException $错误) {}
		return null;
	}

	public static FileLock 锁定(FileOutputStream $流) {
		if ($流 == null) return null;
		try {
			return $流.getChannel().tryLock();
		} catch (IOException $错误) {}
		return null;
	}

	public static void 解锁(FileLock $锁) {
		if ($锁 == null) return;
		try {
			$锁.release();
		} catch (IOException $错误) {}
	}

	public static byte[] 读取(InputStream $流) {
		if ($流 == null) return null;
		try {
			int $长度 = $流.available();
			byte[] $字节 = new byte[$长度];
			$流.read($字节);
			return $字节;
		} catch (IOException $错误) {}
		return null;
	}

	public static void 保存(OutputStream $流,byte[] $内容) {
        if ($流 == null) return;
		if ($内容 == null) return;
		try {
			$流.write($内容);
			$流.flush();
		} catch (IOException $错误) {}
    }

	public static class 输入 {

		private 输入() {};
		
		public static ByteArrayInputStream 字节(byte[] $字节) {
			return new ByteArrayInputStream($字节);
		}
		
		public static FileInputStream 文件(String $地址) {
			File $对象 = 文件工具.取文件对象($地址);
			if (!$对象.isFile()) return null;
			try {
				return new FileInputStream($对象);
			} catch (FileNotFoundException $错误) {}
			return null;
		}

	}
	
	public static class 输出 {
		
		private 输出() {};
		
		public static ByteArrayOutputStream 字节() {
			return new ByteArrayOutputStream();
		}
		
		public static FileOutputStream 文件(String $地址) {
			return 文件($地址,false);
		}
		
		public static FileOutputStream 文件(String $地址,boolean $追加) {
			File $对象 = 文件工具.取文件对象($地址);
			if (!$对象.getParentFile().exists()) {
				$对象.getParentFile().mkdirs();
			}
			if (!$对象.isFile()) {
				try {
					$对象.createNewFile();
				} catch (IOException $错误) {}
			}
			try {
				return new FileOutputStream($对象,$追加);
			} catch (FileNotFoundException $错误) {}
			return null;
		}
		
		
	}

}

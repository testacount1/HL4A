package 放课后乐园部.基本;

import java.io.*;
import java.net.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.注解.注释.*;
import 放课后乐园部.注解.状态.*;

@未测试
public class 套接字 {

		private 套接字() {}

		public static class 套接字客户端 {

				private Socket 对象;

				private 套接字客户端(Socket $对象) {

						检查.空指针("套接字对象为空", $对象);

						对象 = $对象;

				}


				public void 发送(byte[] $内容) {
						try {
								OutputStream $输出 = 对象.getOutputStream();
								IO流.保存($输出, $内容);
								$输出.flush();
								对象.shutdownOutput();
						} catch (Exception $错误) {}

				}

				public byte[] 读取() {
						try {
								InputStream $输入流 = 对象.getInputStream();
								byte[] $字节 = IO流.读取($输入流);
								IO流.关闭($输入流);
								return $字节;
						} catch (Exception $错误) {}
						return null;
				}

				public void 关闭() {
						try {
								对象.close();
						} catch (Exception $错误) {}
				}
		}

		public static class 套接字服务器 {

				private ServerSocket 对象;
				private boolean 监听中 = false;
				private 通用方法 处理;
				private 监听线程 线程;

				public 套接字服务器(ServerSocket $对象,通用方法 $处理) {

						检查.空指针("套接字对象为空", $对象, $处理);

						对象 = $对象;
						
						处理 = $处理;

				}

				public void 监听() {
						if (监听中) return;
						线程 = new 监听线程(对象,处理);
				}

		}

		public static class 监听线程 extends Thread {

				private ServerSocket 服务器;
				private 通用方法 处理;

				public 监听线程(ServerSocket $服务器,通用方法 $处理) {
						服务器 = $服务器;
						处理 = $处理;
				}

				@Override
				public void run() {
						try {
								while (true) {
										套接字客户端 $套接字 = new 套接字客户端(服务器.accept());
										byte[] $字节 = $套接字.读取();
										处理.调用($字节,$套接字);
								}
						} catch (Exception $错误) {}
				}

		}

		public static 套接字客户端 连接(String $地址,int $端口) {
				try {
						return new 套接字客户端(new Socket($地址, $端口));
				} catch (Exception $错误) {}
				return null;
		}

		public static 套接字服务器 创建(int $端口,通用方法 $处理) {
				try {
						return new 套接字服务器(new ServerSocket($端口),$处理);
				} catch (Exception $错误) {}
				return null;
		}

}

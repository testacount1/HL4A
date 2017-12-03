package 放课后乐园部.基本;

import java.util.regex.*;

public class 字符 {

		private 字符() {}

		public static String 转换(byte[] $字节) {
				if ($字节 == null) return null;
				return new String($字节);
		}
		
		public static String 取开始前(String $文本,Integer $开始) {
				if ($文本 == null || $开始 == null)
						return null;
				return $文本.substring(0, $开始);
		}

		public static String 取开始后(String $文本,Integer $开始) {
				if ($文本 == null || $开始 == null)
						return null;
				return $文本.substring($开始);
		}

		public static String 取结束前(String $文本,Integer $结束) {
				if ($文本 == null || $结束 == null)
						return null;
				return $文本.substring(0, $文本.length() - $结束);
		}

		public static String 取结束后(String $文本,Integer $结束) {
				if ($文本 == null || $结束 == null)
						return null;
				return $文本.substring($文本.length() - $结束, $文本.length());
		}

		public static String 取中间(String $文本,Integer $开始,Integer $结束) {
				if ($文本 == null || $开始 == null || $结束 == null)
						return null;
				return $文本.substring($开始, $结束);
		}

		public static Boolean 是否出现(String $文本,String $内容) {
				if ($文本 == null || $内容 == null)
						return false;
				return $文本.indexOf($内容) != -1;
		}

		public static Boolean 是否出现(String $文本,String $内容,Integer $开始位置) {
				if ($文本 == null || $内容 == null)
						return false;
				if ($开始位置 == null) return 是否出现($文本, $内容);
				return $文本.indexOf($内容, $开始位置) != -1;
		}

		public static Boolean 以开始(String $文本,String $开始) {
				if ($文本 == null || $开始 == null)
						return false;
				return $文本.startsWith($开始);
		}

		public static Boolean 以开始(String $文本,String $开始,Integer $开始位置) {
				if ($文本 == null || $开始 == null)
						return false;
				if ($开始位置 == null) return 以开始($文本, $开始);
				return $文本.startsWith($开始, $开始位置);
		}

		public static Boolean 以结束(String $文本,String $结束) {
				if ($文本 == null || $结束 == null)
						return false;
				return $文本.endsWith($结束);
		}

		public static String[] 合成数组(String[] $数组,String[] $数组2) {
				String[] $新数组 = new String[$数组.length + $数组2.length];
				int $键值 = 0;
				for (String $单个 : $数组) {
						$新数组[$键值] = $单个;
						$键值 ++;
				}
				for (String $单个 : $数组2) {
						$新数组[$键值] = $单个;
						$键值 ++;
				}
				return $新数组;
		}

		public static String[] 到数组(String $文本,String $分隔) {
				if ($文本 == null) return null;
				if ($分隔 == null)
						return new String[] {
								$文本
						};
				return $文本.split($分隔);
		}

		public static String[] 到数组(String $文本,String $分隔,Integer $最大位数) {
				if ($最大位数 == null)
						return 到数组($文本, $分隔);
				if ($文本 == null) return null;
				if ($分隔 == null)
						return new String[] {
								$文本
						};
				return $文本.split($分隔, $最大位数);
		}

		public static String 分解(Object $数组[]) {
				return 分解($数组, "");
		}

		public static String 分解(Object $数组[],String $分隔) {

				if ($数组 == null)return null;
				if ($分隔 == null)$分隔 = "";

				int $数组长度 = $数组.length;

				if ($数组长度 == 0) return null;

				if ($数组长度 == 1) return $数组[0].toString();

				String $分解 = $数组[0].toString();

				for (int $键值 = 1;$键值 != $数组长度;$键值 ++) {

						$分解 += $分隔 + $数组[$键值];

				}

				return $分解;

		}

		public static String 替换(String $文本,String $旧文本,String $新文本) {
				if (是否为空($文本, $旧文本, $新文本)) return null;
				return $文本.replace($旧文本, $新文本);
		}

		public static String 正则匹配(String $文本,String $正则表达式) {
				if (是否为空($文本, $正则表达式)) return null;
				return Pattern.compile($正则表达式).matcher($文本).group();
		}

		public static String 正则匹配(String $文本,String $正则表达式,Integer $次数) {
				if (是否为空($次数)) return 正则匹配($文本, $正则表达式);
				if (是否为空($文本, $正则表达式)) return null;
				return Pattern.compile($正则表达式).matcher($文本).group($次数);
		}

		public static String 正则替换(String $文本,String $表达式,String $新文本) {
				if (是否为空($文本, $表达式, $新文本)) return null;
				return $文本.replaceAll($表达式, $新文本);
		}


		public static String 截取开始(String $文本,String $开始,String $结束) {

				Integer start = null;
				Integer end = null;

				if ($开始 == null && $结束 == null) return $文本;

				if ($开始 == null) start = 0;
				else start = $文本.indexOf($开始) + $开始.length();

				if (start == -1) return null;

				if ($结束 == null) return $文本.substring(start);
				else end = $文本.indexOf($结束);

				if (end == -1) return null;

				return $文本.substring(start, end);

		}

		public static String 截取中间(String $文本,String $开始,String $结束) {

				Integer start = null;
				Integer end = null;

				if ($开始 == null && $结束 == null) return $文本;

				if ($开始 == null) start = 0;
				else start = $文本.indexOf($开始) + $开始.length();

				if (start == -1) return null;

				if ($结束 == null) return $文本.substring(start);
				else end = $文本.lastIndexOf($结束);

				if (end == -1) return null;

				return $文本.substring(start, end);

		}

		public static String 截取结束(String $文本,String $开始,String $结束) {
				Integer start = null;
				Integer end = null;

				if ($开始 == null && $结束 == null) return $文本;

				if ($开始 == null) start = 0;
				else start = $文本.lastIndexOf($开始) + $开始.length();

				if (start == -1) return null;

				if ($结束 == null) return $文本.substring(start);
				else end = $文本.lastIndexOf($结束);

				if (end == -1) return null;

				return $文本.substring(start, end);
		}

		public static String 截取(String $文本,String $开始,String $结束,Integer $开始数量,Integer $结束数量) {
				if ($文本 == null) return null;
				if ($开始 == null) return null;
				if ($开始数量 == null) $开始数量 = 1;
				if ($结束数量 == null) $结束数量 = 1;
				Integer $出现数量 = 字符.取出现次数($文本, $开始);
				if ($开始数量 < 0) {
						$开始数量 = $出现数量 + 1 - $开始数量;
						if ($开始数量 < 0)
								$开始数量 = $出现数量;
				}
				if ($开始数量 > $出现数量) $开始数量 = $出现数量;
				if ($结束 != null) {
						$出现数量 = 字符.取出现次数($文本, $结束);
						if ($结束数量 < 0) {
								$结束数量 = $出现数量 + 1 - $结束数量;
								if ($结束数量 < 0)
										$结束数量 = $出现数量;
						}
						if ($结束数量 > $出现数量) $结束数量 = $出现数量;
				}
				Integer $当前位置;
				$当前位置 = 取出现位置下标($文本, $开始);
				while ($开始数量 > 0) {
						$当前位置 = 取出现位置下标($文本, $开始, $当前位置);
						$开始数量 --;
				}
				$文本 = 字符.取开始后($文本, $当前位置);
				if ($结束 == null) return $文本;
				$当前位置 = 取出现位置下标($文本, $结束);
				while ($结束数量 > 0) {
						$当前位置 = 取出现位置下标($文本, $结束, $当前位置);
						$结束数量 --;
				}
				return 字符.取开始后($文本, $当前位置);
		}

		public static Integer 取出现位置(String $文本,String $内容) {
				if ($文本 == null) return null;
				if ($内容 == null) return null;
				int $位置 = $文本.indexOf($内容);
				if ($位置 == -1) return null;
				return $位置;
		}

		public static Integer 取出现位置(String $文本,String $内容,Integer $开始位置) {
				if ($文本 == null) return null;
				if ($内容 == null) return null;
				if ($开始位置 != null) {
						int $位置 = $文本.indexOf($内容, $开始位置);
						if ($位置 == -1) return null;
						return $位置;
				}
				else return 取出现位置($文本, $内容);
		}

		public static Integer 取出现位置下标(String $文本,String $内容) {
				if ($文本 == null) return null;
				if ($内容 == null) return null;
				int $位置 = $文本.indexOf($内容);
				if ($位置 == -1) return null;
				return $位置 + $内容.length();
		}

		public static Integer 取出现位置下标(String $文本,String $内容,Integer $开始位置) {
				if ($文本 == null) return null;
				if ($内容 == null) return null;
				if ($开始位置 != null) {
						int $位置 = $文本.indexOf($内容, $开始位置);
						if ($位置 == -1) return null;
						return $位置 + $内容.length();
				}
				else return 取出现位置下标($文本, $内容);
		}

		public static String 正则截取(String $文本,String $开始,String $结束) {
				return 字符.正则匹配($文本, $开始 + "(.*)" + $结束);
		}

		public static String 正则截取(String $文本,String $开始,String $结束,Integer $次数) {
				return 字符.正则匹配($文本, $开始 + "(.*)" + $结束, $次数);
		}

		public static Boolean 是否为空(Object... $内容) {
				if ($内容 == null) return true;
				for (Object $单个内容 :$内容) {
						if ($单个内容 == null || $单个内容.equals(""))
								return true;
				}
				return false;
		}

		public static Integer 取出现次数(String $文本,String $内容) {

				Integer $次数 = 0;
				Integer $位置 = -1;

				while (($位置 = $文本.indexOf($内容)) != -1) {
						$文本 = $文本.substring($位置 + $内容.length());
						$次数 ++;
				}
				return $次数;
		}

		public static String 大写(String $文本) {
				return $文本.toUpperCase();
		}

		public static String 小写(String $文本) {
				return $文本.toLowerCase();
		}

}

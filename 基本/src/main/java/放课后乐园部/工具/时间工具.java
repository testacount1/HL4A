package 放课后乐园部.工具;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class 时间工具 {

				public static String 格式() {
				return 格式(new Date(), null);
		}

		public static String 格式(String $格式) {
				return 格式(new Date(), $格式);
		}

		public static String 格式(long $时间戳,String $格式) {
				return 格式(new Date($时间戳), $格式);
		}

		public static String 格式(Date $时间,String $格式) {
				if ($格式 == null) $格式 = "默认";
				switch ($格式) {
						case "默认":return 格式($时间,"yyyy-MM-dd HH:mm:ss");
						case "中文":return 格式($时间,"yyyy年-MM月-dd日 HH时:mm分:ss秒");
						default:return new SimpleDateFormat($格式, Locale.getDefault()).format(new Date());
				}
		}

		public static long 时间戳() {
				return System.currentTimeMillis();
		}

		public static Integer 年份() {
				return 年份(new Date());
		}

		public static Integer 年份(long $时间戳) {
				return 年份(new Date($时间戳));
		}

		public static Integer 年份(Date $时间) {
				return $时间.getYear();
		}

		public static Integer 月份() {
				return 月份(new Date());
		}

		public static Integer 月份(long $时间戳) {
				return 月份(new Date($时间戳));
		}

		public static Integer 月份(Date $时间) {
				return $时间.getMonth();
		}

		public static Integer 天数() {
				return 天数(new Date());
		}

		public static Integer 天数(long $时间戳) {
				return 天数(new Date($时间戳));
		}

		public static Integer 天数(Date $时间) {
				return $时间.getDate();
		}

		public static Integer 星期() {
				return 星期(new Date());
		}

		public static Integer 星期(long $时间戳) {
				return 星期(new Date($时间戳));
		}

		public static Integer 星期(Date $时间) {
				return $时间.getDay();
		}

		public static Integer 小时() {
				return 小时(new Date());
		}

		public static Integer 小时(long $时间戳) {
				return 小时(new Date($时间戳));
		}

		public static Integer 小时(Date $时间) {
				return $时间.getHours();
		}

		public static Integer 分钟() {
				return 分钟(new Date());
		}

		public static Integer 分钟(long $时间戳) {
				return 分钟(new Date($时间戳));
		}

		public static Integer 分钟(Date $时间) {
				return $时间.getMinutes();
		}

		public static Integer 秒钟() {
				return 秒钟(new Date());
		}

		public static Integer 秒钟(long $时间戳) {
				return 秒钟(new Date($时间戳));
		}

		public static Integer 秒钟(Date $时间) {
				return $时间.getSeconds();
		}

		public static String 比较(long $时间戳) {

				String $比较 = "";

				long $当前 = 时间戳();

				Integer $年份 = 年份($当前);
				Integer $月份 = 月份($当前);
				Integer $天数 = 天数($当前);
				Integer $小时 = 小时($当前);
				Integer $分钟 = 分钟($当前);

				Integer $旧年 = 年份($时间戳);
				Integer $旧月 = 月份($时间戳);
				Integer $旧天 = 天数($时间戳);
				Integer $旧时 = 小时($时间戳);
				Integer $旧分 = 分钟($时间戳);

				Integer $权重 = 1;

				if ($年份 != $旧年) $比较 += (($年份 - $旧年) + "年");else $权重 ++;
				if ($月份 != $旧月) $比较 += (($月份 - $旧月) + "月");else $权重 ++;
				if ($天数 != $旧天) $比较 += (($天数 - $旧天) + "日");else $权重 ++;
				if ($小时 != $旧时) $比较 += (($小时 - $旧时) + "时");else $权重 ++;
				if ($分钟 != $旧分) $比较 += (($分钟 - $旧分) + "分");

				if ($当前 < $时间戳) $比较 += "后";else $比较 += "前";

				if ($权重 == 1) $比较 = "刚刚";

				return $比较;

		}
		
		public static String 相对(long $时间戳) {

				String $相对 = "";

				long $当前 = 时间戳();
				
				if ($当前 < $时间戳) return "未来 或 本地时间错误";

				Integer $年份 = 年份($当前);
				Integer $月份 = 月份($当前);
				Integer $天数 = 天数($当前);
				Integer $小时 = 小时($当前);
				Integer $分钟 = 分钟($当前);

				Integer $旧年 = 年份($时间戳);
				Integer $旧月 = 月份($时间戳);
				Integer $旧天 = 天数($时间戳);
				Integer $旧时 = 小时($时间戳);
				Integer $旧分 = 分钟($时间戳);

				if ($年份 > $旧年) return 格式($时间戳,"yyyy年-MM月-dd日");
				if ($月份 > $旧月) return 格式($时间戳,"MM月-dd日");
				if ($天数 > $旧天) return 格式($时间戳,"dd日 HH时");
				if ($小时 > $旧时) return 格式($时间戳,"HH时:mm分");
				if ($分钟 > $旧分 && ($分钟 - $旧分) > 2) return ($分钟 - $旧分) + "前";
				return "刚刚";
				
		}

}

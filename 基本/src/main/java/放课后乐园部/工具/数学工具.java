package 放课后乐园部.工具;

import java.util.*;

public class 数学工具 {

	public static int 伪随机数(int $最小,int $最大,int $种子) {
		Random $随机数 = new Random($种子);
		return $随机数.nextInt($最大) % ($最大 - $最小 + 1) + $最小;
	}
	
	public static int 随机数(int $最小,int $最大) {
		return new Double(Math.random() * ($最大 - $最小 +1) + $最小).intValue();
	}
	
	public static int 绝对值(int $值) {
		return Math.abs($值);
	}
	
	public static double 绝对值(double $值) {
		return Math.abs($值);
	}
	public static float 绝对值(float $值) {
		return Math.abs($值);
	}
	
	public static long 绝对值(long $值) {
		return Math.abs($值);
	}
	
	public static double 整数大(double $值) {
		return Math.ceil($值);
	}
	
	public static double 整数小(double $值) {
		return Math.floor($值);
	}
	
	public static double 大(double $值,double $值二) {
		return Math.max($值,$值二);
	}
	
	public static int 大(int $值,int $值二) {
		return Math.max($值,$值二);
	}
	
	public static float 大(float $值,float $值二) {
		return Math.max($值,$值二);
	}
	
	public static long 大(long $值,long $值二) {
		return Math.max($值,$值二);
	}
	
	public static double 小(double $值,double $值二) {
		return Math.min($值,$值二);
	}

	public static int 小(int $值,int $值二) {
		return Math.min($值,$值二);
	}

	public static float 小(float $值,float $值二) {
		return Math.min($值,$值二);
	}

	public static long 小(long $值,long $值二) {
		return Math.min($值,$值二);
	}
	
	
}

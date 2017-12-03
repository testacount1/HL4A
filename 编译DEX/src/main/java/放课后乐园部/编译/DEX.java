package 放课后乐园部.编译;

import com.android.dx.command.dexer.Main;
import com.android.dx.merge.DexMerger;
import java.io.*;

public class DEX {

		private DEX() {}

		public static void jar到dex(String $路径,String $输出) {
				try {
						final Main.Arguments $参数 = new Main.Arguments();
						$参数.fileNames = new String[]{$路径};
						$参数.outName = $输出;
						$参数.jarOutput = true;
						Main.run($参数);
				} catch (Exception $错误) {}
		}

		public static void dex合成(String $输出,String... $单个) {
				try {
						String[] $参数 = new String[]{$输出};
						$参数 = 字符.合成数组($参数,$单个);
						DexMerger.main($参数);
				} catch (Exception $错误) {}
		}
}

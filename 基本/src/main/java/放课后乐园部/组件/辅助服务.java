package 放课后乐园部.组件;

import android.accessibilityservice.*;
import android.view.accessibility.*;

public class 辅助服务 extends AccessibilityService {
		
		public static 辅助服务 服务 = null;
		public static AccessibilityEvent 意图 = null;
		public static AccessibilityNodeInfo 节点 = null;
		
		
		@Override
		public void onCreate() {
				super.onCreate();
		}
		
		@Override
		public void onServiceConnected() {
				super.onServiceConnected();
				服务 = this;
		}

		@Override
		public void onAccessibilityEvent(AccessibilityEvent $意图) {
				意图 = $意图;
				节点 = getRootInActiveWindow();
		}

		@Override
		public void onInterrupt() {
		}
		

}

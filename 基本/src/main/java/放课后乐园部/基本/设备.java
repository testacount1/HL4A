package 放课后乐园部.基本;

import android.content.*;
import android.telephony.*;
import java.util.*;

public class 设备 {

		private 设备() {}

		public static void 剪切板(String $内容) {
				ClipboardManager clipboard = (ClipboardManager) 环境.读取().getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(ClipData.newPlainText(null, $内容));
    }
		public static String 剪切板() {
        ClipboardManager clipboard = (ClipboardManager) 环境.读取().getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboard.hasPrimaryClip() && clipboard.getPrimaryClipDescription().hasMimeType(
                ClipDescription.MIMETYPE_TEXT_PLAIN)) {
            ClipData clip = clipboard.getPrimaryClip();
            if (clip != null && clip.getItemCount() > 0) {
                return String.valueOf(clip.getItemAt(0).coerceToText(环境.读取()));
            }
        }
        return null;
    }
		public static String UUID() {
        final TelephonyManager tm = (TelephonyManager) 环境.读取().getSystemService(Context.TELEPHONY_SERVICE);
				
        final String tmDevice, tmSerial, tmPhone, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(环境.读取().getContentResolver(), android.provider
																																		.Settings.Secure.ANDROID_ID);
        UUID deviceUuid = new UUID(androidId.hashCode(), ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
        String uniqueId = deviceUuid.toString();

        return uniqueId;
    }

		public static String IMEI() {
				TelephonyManager tm = (TelephonyManager) 环境.读取().getSystemService(Context.TELEPHONY_SERVICE);
				return tm.getDeviceId();
		}

		public static String IMSI() {
				TelephonyManager tm = (TelephonyManager) 环境.读取().getSystemService(Context.TELEPHONY_SERVICE);
				return tm.getSubscriberId();
		}

}

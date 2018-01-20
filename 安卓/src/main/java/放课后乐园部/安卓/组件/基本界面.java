package 放课后乐园部.安卓.组件;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import 放课后乐园部.事件.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.收集.*;
import 放课后乐园部.工具.*;
import 放课后乐园部.安卓.弹窗.*;
import java.io.*;

public class 基本界面 extends Activity {

	public Object[] 传入参数;
	public 哈希表<String,通用方法> 所有事件 = new 哈希表<String,通用方法>();

	public void 注册事件(String $事件,通用方法 $方法) {
		所有事件.设置($事件, $方法);
	}

	public boolean 检查事件(String $名称) {
		return 所有事件.检查($名称);
	}

	public Object 调用事件(String $名称,Object... $参数) {
		通用方法 $方法 = 所有事件.读取($名称);
		return 调用方法.事件($方法, $参数);
	}

	@Override
	public void onCreate(Bundle $恢复) {
		super.onCreate($恢复);
		应用工具.初始化界面(this);
		Intent $意图 = getIntent();
		if ($意图.hasExtra("参数")) {
			传入参数 = (Object[])$意图.getSerializableExtra("参数");
		}
		if (检查事件("界面创建事件")) {
			调用事件("界面创建事件", $恢复);
		} else {
			界面创建事件($恢复);
		}
	}

	public String 读取字符串(String $内容) {
		return getIntent().getStringExtra($内容);
	}

	@Override
	public void onStart() {
		super.onStart();
		if (检查事件("界面启动事件")) {
			调用事件("界面启动事件");
		} else {
			界面启动事件();
		}
	}

	@Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
			if (检查事件("取得焦点事件")) {
				调用事件("取得焦点事件");
			} else {
				取得焦点事件();
			}
		} else {
			if (检查事件("失去焦点事件")) {
				调用事件("失去焦点事件");
			} else {
				失去焦点事件();
			}
		}
    }

	@Override
    public void onNewIntent(Intent $意图) {
        super.onNewIntent($意图);
		if (检查事件("收到意图事件")) {
			调用事件("收到意图事件", $意图);
		} else
			收到意图事件($意图);
    }

	@Override
	protected void onSaveInstanceState(Bundle $输出) {
		super.onSaveInstanceState($输出);
		if (检查事件("保存状态事件")) {
			调用事件("保存状态事件", $输出);
		} else
			保存状态事件($输出);
	}

	@Override
    public void onResume() {
        super.onResume();
		if (检查事件("界面刷新事件")) {
			调用事件("界面刷新事件");
		} else
			界面刷新事件();
    }

    @Override
    public void onPause() {
        super.onPause();
		if (检查事件("界面遮挡事件")) {
			调用事件("界面遮挡事件");
		} else
			界面遮挡事件();
    }

	private long 返回时间 = 时间工具.时间戳() - 23333;

    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event) {
		if (检查事件("按键按下事件")) {
			return 调用事件("按键按下事件", keyCode, event) == true;
		} else {
			Boolean $返回 = 按键按下事件(keyCode, event);
			if ($返回 != null) {
				return $返回;
			}
		}
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (检查事件("返回按下事件")) {
				return 调用事件("返回按下事件") == true;
			} else {
				Boolean $返回 = 返回按下事件();
				if ($返回 != null) {
					return $返回;
				}
				long 上次 = 返回时间;
				if ((返回时间 = 时间工具.时间戳()) - 上次 < 2333) {
					finish();
					return true;
				} else {
					提示工具.普通("再按一次返回键退出 ~");
					return false;
				}
			}
		}
		return super.onKeyDown(keyCode, event);
	}


    @Override
    public void onActivityResult(int $请求码,int $结果码,Intent $意图) {
        super.onActivityResult($请求码, $请求码, $意图);
		if (检查事件("界面回调事件")) {
			调用事件("界面回调事件", $请求码, $结果码, $意图);
		} else
			界面回调事件($请求码, $结果码, $意图);
    }

    @Override
    public void onStop() {
		if (检查事件("离开界面事件")) {
			调用事件("离开界面事件");
		} else
			离开界面事件();
        super.onStop();
    }

	@Override
	public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (检查事件("权限回调事件")) {
			调用事件("权限回调事件", requestCode, permissions, grantResults);
		} else
			权限回调事件();
	}

    @Override
    public void onDestroy() {
		if (检查事件("界面销毁事件")) {
			调用事件("界面销毁事件");
		} else
			界面销毁事件();
		super.onDestroy();
    }

	public void 置返回值(int $请求码) {
        setResult($请求码);
    }

    public void 置返回值(int $结果码,Intent $意图) {
        setResult($结果码, $意图);
    }


	public void 结束界面() {
		finish();
	}

	public void 结束界面(Exception $错误) {
		finish();
	}

	public View 当前视图;

    public void 打开布局(View $视图) {
		当前视图 = $视图;
        布局工具.打开(this, $视图);
    }

	public View 取视图(Object $标签) {
		return 当前视图.findViewWithTag($标签);
	}

    public void 跳转界面(Class<?> $类) {
        跳转界面(null, $类, null);
    }

    public void 跳转界面(Class<?> $类,Object... $数据) {
        跳转界面(null, $类 , $数据);
    }

    public void 跳转界面(Integer $请求码,Class<?> $类,Object... $数据) {

        Intent $意图 = new Intent(this, $类);
        if ($数据 != null)
            $意图.putExtra("参数", (Serializable)$数据);
        if ($请求码 == null)
            startActivity($意图);
        else
            startActivityForResult($意图, $请求码);

    }

	public void 跳转界面(String $类) {
        跳转界面(null, $类, null);
    }

    public void 跳转界面(String $类,Object... $数据) {
        跳转界面(null, $类 , $数据);
    }

    public void 跳转界面(Integer $请求码,String $类,Object... $数据) {

        Intent $意图 = new Intent(this, 反射工具.取类($类));
        if ($数据 != null)
            $意图.putExtra("参数", (Serializable)$数据);
        if ($请求码 == null)
            startActivity($意图);
        else
            startActivityForResult($意图, $请求码);

    }


	public void 跳转脚本(String $类) {
        跳转脚本(null, $类, null);
    }

    public void 跳转脚本(String $类,Object... $数据) {
        跳转脚本(null, $类 , $数据);
    }

    public void 跳转脚本(Integer $请求码,String $类,Object... $数据) {
		Class<?> $组件 = 反射工具.取类("放课后乐园部.安卓.脚本.组件.脚本界面");
		Class<?> $界面 = 反射工具.取类(应用工具.取包名() + ".ScriptActivity");
		if ($组件 == null) {
			错误工具.内容("没有引入脚本支持包 ~");
		} else if ($界面 == null) {
			错误工具.内容("没有创建SctiptAvtivity！");
		}
        Intent $意图 = new Intent(this, $界面);
		$意图.putExtra("脚本", $类);
        if ($数据 != null)
            $意图.putExtra("参数", (Serializable)$数据);
        if ($请求码 == null)
            startActivity($意图);
        else
            startActivityForResult($意图, $请求码);

    }

	public void 请求权限() {
		权限工具.请求所有(this, 233);
	}


	public void 界面创建事件(Bundle $恢复) {}
	public void 界面启动事件() {}
	public void 界面刷新事件() {}
	public void 界面遮挡事件() {}
	public void 界面回调事件(int $请求码,int $返回码,Intent $意图) {}
	public void 离开界面事件() {}
	public void 界面销毁事件() {}
	public void 取得焦点事件() {}
	public void 失去焦点事件() {}
	public Boolean 按键按下事件(int $按键码,KeyEvent $事件) {return null;}
	public Boolean 返回按下事件() {return null;}
	public void 收到意图事件(Intent $意图) {}
	public void 保存状态事件(Bundle $输出) {}

	public void 权限回调事件() {}

}

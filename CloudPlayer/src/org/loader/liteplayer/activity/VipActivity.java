package org.loader.liteplayer.activity;
import org.loader.liteplayer.R;
import org.loader.liteplayer.com.web.CWebService;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VipActivity extends Activity implements OnClickListener {

	// 登陆按钮
	private Button regbtn;
	// 调试文本，注册文本
	private TextView infotv, regtv;
	// 显示用户名和密码
	EditText c_name, c_password;
	// 创建等待框
	private ProgressDialog dialog;
	// 返回的数据
	private String info;
	// 返回主线程更新数据
	private static Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viplayout);

		// 获取控件
		//username = (EditText) findViewById(R.id.user);
		c_name = (EditText) findViewById(R.id.user);
		c_password = (EditText) findViewById(R.id.pass);
		regbtn = (Button) findViewById(R.id.register);
		//regtv = (TextView) findViewById(R.id.register);
		infotv = (TextView) findViewById(R.id.info);

		// 设置按钮监听器
		regbtn.setOnClickListener(this);
		//regtv.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.register:
				// 检测网络 这里我用的Wlan测试，但此方法只允许网络流量，只能先禁掉。
//			if (!checkNetwork()) {
//				Toast toast = Toast.makeText(Login.this,"网络未连接", Toast.LENGTH_SHORT);
//				toast.setGravity(Gravity.CENTER, 0, 0);
//				toast.show();
//				break;
//			}
				// 提示框
				dialog = new ProgressDialog(this);
				dialog.setTitle("提示");
				dialog.setMessage("正在注册，请稍后...");
				dialog.setCancelable(false);
				dialog.show();
				// 创建子线程，分别进行Get和Post传输
				new Thread(new MyThread()).start();
				break;
	/*		case R.id.register:
				Intent regItn = new Intent(Login.this, Register.class);
				// overridePendingTransition(anim_enter);
				startActivity(regItn);
				break;
				*/
		}
		;
	}

	// 子线程接收数据，主线程修改数据
	public class MyThread implements Runnable {
		@Override
		public void run() {
			info = CWebService.executeHttpGet(c_name.getText().toString(), c_password.getText().toString());
			// info =
			// WebServicePost.executeHttpPost(username.getText().toString(),
			// password.getText().toString());
			handler.post(new Runnable() {
				@Override
				public void run() {
					// 最好返回一个固定键值，根据键值判断是否登陆成功，有键值就保存该info跳转，没键值就是错误信息直接toast
					int a ;
					a = Integer.parseInt(info);
					if(a == 0)
					{
						SharedPreferences mySharedPreferences= getSharedPreferences("test", 
						Activity.MODE_PRIVATE); 
						//实例化SharedPreferences.Editor对象（第二步） 
						SharedPreferences.Editor editor = mySharedPreferences.edit(); 
						//用putString的方法保存数据 
						editor.putString("flag","loged"); 
						//提交当前数据 
						editor.commit();
		                Intent intent = new Intent(VipActivity.this,MainActivity.class);
		                startActivity(intent);  
						//Register.this.finish();
						String b = "注册并登录成功";
						infotv.setText(b);
						dialog.dismiss();
						Toast toast = Toast.makeText(VipActivity.this, b, Toast.LENGTH_SHORT);
						toast.setGravity(Gravity.CENTER, 0, 0);
						toast.show();
					}
					if(a == 1) {
						String b = "注册数据库失败";
						infotv.setText(b);
						dialog.dismiss();
						Toast toast = Toast.makeText(VipActivity.this, b, Toast.LENGTH_SHORT);
						toast.setGravity(Gravity.CENTER, 0, 0);
						toast.show();
					}
					if(a == 2){
					String b = "注册失败，请检查网络连接";
					infotv.setText(b);
					dialog.dismiss();
					Toast toast = Toast.makeText(VipActivity.this, b, Toast.LENGTH_SHORT);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();
					}
				}
			});
		}
	}

	// 检测网络
	private boolean checkNetwork() {
		ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connManager.getActiveNetworkInfo() != null) {
			return connManager.getActiveNetworkInfo().isAvailable();
		}
		return false;
	}

}

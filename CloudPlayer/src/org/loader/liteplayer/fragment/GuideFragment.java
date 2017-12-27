package org.loader.liteplayer.fragment;

import org.loader.liteplayer.R;
import org.loader.liteplayer.activity.MainActivity;
import org.loader.liteplayer.activity.PlayActivity;
import org.loader.liteplayer.activity.RecordMusicView;
import org.loader.liteplayer.activity.Login;
import org.loader.liteplayer.activity.Login.MyThread;
import org.loader.liteplayer.activity.VipActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class GuideFragment extends Fragment implements OnClickListener {

	private ImageButton bt1,bt2,bt3,bt4,bt5;
	private MainActivity mActivity;
	private ProgressDialog dialog;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);

	}
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = (MainActivity) activity;
	}

	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		View layout = inflater.inflate(R.layout.main_guide, null);
		setupViews(layout);

		return layout;
	}
	
	private void setupViews(View layout) {
		// TODO Auto-generated method stub
		
	
	bt1 = (ImageButton) layout.findViewById(R.id.imagebtn);
	bt2 = (ImageButton) layout.findViewById(R.id.btn1);
	bt3 = (ImageButton) layout.findViewById(R.id.btn2);
	bt4 = (ImageButton) layout.findViewById(R.id.btn3);
	bt5 = (ImageButton) layout.findViewById(R.id.btn4);
	
	bt1.setOnClickListener(this);
	bt2.setOnClickListener(this);
	bt3.setOnClickListener(this);
	bt4.setOnClickListener(this);
	bt5.setOnClickListener(this);
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.imagebtn:
			SharedPreferences sharedPreferences= getActivity().getSharedPreferences("test", 
					Activity.MODE_PRIVATE); 
					// 使用getString方法获得value，注意第2个参数是value的默认值 
			final String flag =sharedPreferences.getString("flag", "");
            if(flag == "loged") {
            	Toast.makeText(getActivity(), "您已登录", Toast.LENGTH_LONG).show();
            	startActivity(new Intent(mActivity, MainActivity.class));
            	//getActivity().finish();
            }
            else{
            	startActivity(new Intent(mActivity, Login.class));
            }
			break;
		case R.id.btn1:
			startActivity(new Intent(mActivity, RecordMusicView.class));
			break;
		case R.id.btn2:
			startActivity(new Intent(mActivity, VipActivity.class));
			break;
		case R.id.btn3:
            SharedPreferences sp1 = getActivity().getSharedPreferences("test", Context.MODE_PRIVATE);
            Editor editor1 = sp1.edit();  
            editor1.clear();  
            editor1.commit();
            Toast.makeText(getActivity(), "已注销登录信息", Toast.LENGTH_LONG).show();
			startActivity(new Intent(mActivity, MainActivity.class));
           // getActivity().finish();
			break;
		case R.id.btn4:
			//startActivity(new Intent(mActivity, MainActivity.class));
			android.os.Process.killProcess(android.os.Process.myPid());
			break;
	}
	;
	}

}

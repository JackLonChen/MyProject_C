package org.loader.liteplayer.application;

import org.loader.liteplayer.service.DownloadService;
import org.loader.liteplayer.service.PlayService;
//import org.loader.liteplayer.utils.Constant;
import org.loader.liteplayer.utils.Constants;

import com.lidroid.xutils.DbUtils;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * 2017年8月23日于四川
 * 参考网络开源播放器开发
 */
public class App extends Application {
	public static Context sContext;
	public static int sScreenWidth;
	public static int sScreenHeight;
    //SharedPreferences是Android平台上一个轻量级的存储类，用来保存应用的一些常用配置
    public static SharedPreferences sp;//SharedPreferences 直译为 共享偏好
    //xutils 用于音乐收藏数据库 https://github.com/wyouflf/xUtils
    public static DbUtils dbUtils;
    //context 上下文 提供给AppUtils获取上下文
    public static Context context;
	@Override
	public void onCreate() {
		super.onCreate();
		sContext = getApplicationContext();
		
		startService(new Intent(this, PlayService.class));
		startService(new Intent(this, DownloadService.class));
		
		WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics dm = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(dm);
		sScreenWidth = dm.widthPixels;
		sScreenHeight = dm.heightPixels;
	      //实例化,存储名称为SP_NAME,存储模式为私有
        sp = getSharedPreferences(Constants.SP_NAME, Context.MODE_PRIVATE);
        //目的,比如在退出Activity时,保存循环模式,歌曲位置(第几首歌曲)
        //这里,我在MainActivity的onDestroy时,调用SharedPreferences,保存进度值

        //实例化,存储名称为DB_NAME
        dbUtils = DbUtils.create(getApplicationContext(),Constants.DB_NAME);

        //context 上下文 提供给AppUtils获取上下文
        context = getApplicationContext();
	}
	
}

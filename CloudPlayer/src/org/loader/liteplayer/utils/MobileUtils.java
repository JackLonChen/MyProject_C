package org.loader.liteplayer.utils;

import org.loader.liteplayer.application.App;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * 2017年8月23日于四川
 * 参考网络开源播放器开发
 */
public class MobileUtils {
	/**
	 * 隐藏输入法软键盘
	 * @param view attachview
	 * @see {@link InputMethodManager.hideSoftInputFromWindow}
	 */
	public static void hideInputMethod(View view) {
		InputMethodManager imm = (InputMethodManager) App.sContext
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		if(imm.isActive()) {
			imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}
}

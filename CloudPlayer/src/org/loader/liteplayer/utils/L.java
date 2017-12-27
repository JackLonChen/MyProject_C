package org.loader.liteplayer.utils;

/**
 * 2017年8月23日于四川
 * 参考网络开源播放器开发
 */
public class L {
	private static final boolean debug = true;
	
	public static void l(String tag, Object msg) {
		l(tag + "-->" + msg);
	}
	
	public static void l(Object msg) {
		if(!debug) return;
		System.out.println(msg);
	}
}

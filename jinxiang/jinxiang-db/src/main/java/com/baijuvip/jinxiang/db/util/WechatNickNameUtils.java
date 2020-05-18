package com.baijuvip.jinxiang.db.util;

import java.io.UnsupportedEncodingException;

public class WechatNickNameUtils {
	// 编码字符串
	public static String encode(String str) {
		try {
			return java.net.URLEncoder.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	// 解码字符串
	public static String decode(String str) {
		try {
			return java.net.URLDecoder.decode(java.net.URLDecoder.decode(str, "utf-8"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
}

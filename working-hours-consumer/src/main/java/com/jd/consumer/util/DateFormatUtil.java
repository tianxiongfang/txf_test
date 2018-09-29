package com.jd.consumer.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String format(long timestamp) {
		return simpleDateFormat.format(new Date(timestamp));
	}
}

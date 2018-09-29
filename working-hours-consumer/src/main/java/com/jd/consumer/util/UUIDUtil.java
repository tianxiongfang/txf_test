package com.jd.consumer.util;

import java.util.UUID;

public class UUIDUtil {
	public static String getCode() {
		String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
		return uuid.substring(0, 6);
	}
}

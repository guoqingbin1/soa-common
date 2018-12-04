package com.dubbo.common.utils;

import java.util.UUID;

public class UUIDUtils {

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static void main(String[] args) {
		System.out.println("格式化后的UUID ：" + getUUID());
	}

}

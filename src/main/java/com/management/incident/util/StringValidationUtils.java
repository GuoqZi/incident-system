package com.management.incident.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class StringValidationUtils {
	
	/**
	 * 将字符串参数转换为有效数字的方法
	 * 版面设计。在转换错误的情况下，默认返回0。
	 * * @param page要转换为数字的字符串。
	 * @返回转换为整数的字符串，如果转换出错则返回0。
	 */
	public static Integer stringToPageNumber(String page) {
		Integer pageInt = 0;
		try {
			pageInt = Integer.valueOf(page);
			if (pageInt == null || pageInt.compareTo(0) < 0) pageInt = 0;
		} catch (NumberFormatException e) {
			//如果报告无效页面，则保持为0(第一页)
		}
		
		return pageInt;
	}

}

package org.wyk.main.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * @author wyk
 * @time  2016年6月5日
 */
public class DateTimeUtils {
	public static final Log log = LogFactory.getLog(DateTimeUtils.class);

	public final static String FORMAT_yyyy_MM_dd = "yyyy-MM-dd";

	public final static String FORMAT_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

	public final static String FORMAT_yyyy_nian_MM_yue_mm_ri = "yyyy年MM月dd日";

	public final static String FORMAT_yyyy_nian_M_yue_m_ri = "yyyy年M月d日";

	private final static char[][] CHINESE_CHAR = { { '0', '〇' }, { '1', '一' },
			{ '2', '二' }, { '3', '三' }, { '4', '四' }, { '5', '五' },
			{ '6', '六' }, { '7', '七' }, { '8', '八' }, { '9', '九' } };

	public static int nowYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	public static int nowMonth() {
		return Calendar.getInstance().get(Calendar.MONTH) + 1;
	}

	public static int nowDayOfMonth() {
		return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	}

	public static String convertChar2ChineseChar(String dateTimeStr) {
		if (StringUtils.isEmpty(dateTimeStr)) {
			return "";
		}
		StringBuffer buf = new StringBuffer(dateTimeStr.length());
		for (int i = 0; i < dateTimeStr.length(); i++) {
			buf.append(convertChar2ChineseChar(dateTimeStr.charAt(i)));
		}
		return buf.toString();
	}

	public static char convertChar2ChineseChar(char dateTimeChar) {
		for (int i = 0; i < CHINESE_CHAR.length; i++) {
			if (CHINESE_CHAR[i][0] == dateTimeChar) {
				return CHINESE_CHAR[i][1];
			}
		}
		return dateTimeChar;
	}

	/**
	 * Date转换到Calendar
	 * 
	 * @param date
	 *            要转换的Date
	 * @return Calendar
	 */
	public static Calendar date2Calendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	/**
	 * 设置指定的Calendar“时、分、妙”为零
	 * 
	 * @param calendar
	 *            Calendar
	 */
	public static void setTimeZero(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
	}

	/**
	 * 得到当前时间的字符串yyyy-MM-dd
	 * 
	 * @return String
	 */
	public static String now2StrDate() {
		return now2Str(FORMAT_yyyy_MM_dd);
	}

	/**
	 * 得到当前时间的字符串yyyy-MM-dd HH:mm:ss
	 * 
	 * @return String
	 */
	public static String now2StrDateTime() {
		return now2Str(FORMAT_yyyy_MM_dd_HH_mm_ss);
	}

	/**
	 * 得到当前时间的字符串
	 * 
	 * @param format
	 *            字符串格式
	 * @return String
	 * @see org.apache.commons.lang.time.DateFormatUtils.DateFormatUtils#format(Date,
	 *      String)
	 */
	public static String now2Str(String format) {
		return DateFormatUtils.format(new Date(), format);
	}

	/**
	 * Date转换到字符串yyyy-MM-dd
	 * 
	 * @param date
	 *            Date
	 * @return String yyyy-MM-dd
	 * @see org.apache.commons.lang.time.DateFormatUtils.DateFormatUtils#format(Date,
	 *      String)
	 */
	public static String date2StrDate(Date date) {
		return DateFormatUtils.format(date, FORMAT_yyyy_MM_dd);
	}

	/**
	 * Date转换到字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2StrDate(Date date, String format) {
		return DateFormatUtils.format(date, format);
	}

	/**
	 * Date转换到字符串yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 *            Date
	 * @return String yyyy-MM-dd HH:mm:ss
	 * @see org.apache.commons.lang.time.DateFormatUtils.DateFormatUtils#format(Date,
	 *      String)
	 */
	public static String date2StrDateTime(Date date) {
		return DateFormatUtils.format(date, FORMAT_yyyy_MM_dd_HH_mm_ss);
	}

	/**
	 * Calendar转换到字符串yyyy-MM-dd
	 * 
	 * @param calendar
	 *            Calendar
	 * @return String yyyy-MM-dd
	 * @see org.apache.commons.lang.time.DateFormatUtils.DateFormatUtils#format(Date,
	 *      String)
	 */
	public static String calendar2StrDate(Calendar calendar) {
		return date2StrDate(calendar.getTime());
	}

	/**
	 * Calendar转换到字符串yyyy-MM-dd HH:mm:ss
	 * 
	 * @param calendar
	 *            Calendar
	 * @return String yyyy-MM-dd HH:mm:ss
	 * @see org.apache.commons.lang.time.DateFormatUtils.DateFormatUtils#format(Date,
	 *      String)
	 */
	public static String calendar2StrDateTime(Calendar calendar) {
		return date2StrDateTime(calendar.getTime());
	}

	/**
	 * 字符串yyyy-MM-dd转换到Calendar类型
	 * 
	 * @param dateStr
	 *            yyyy-MM-dd
	 * @return Calendar
	 */
	public static Calendar strDate2Calendar(String dateStr) {
		return str2Calendar(dateStr, FORMAT_yyyy_MM_dd);
	}

	/**
	 * 字符串yyyy-MM-dd转换到Date类型
	 * 
	 * @param dateStr
	 *            yyyy-MM-dd
	 * @return Date
	 */
	public static Date strDate2Date(String dateStr) {
		return str2Date(dateStr, FORMAT_yyyy_MM_dd);
	}

	/**
	 * 字符串yyyy-MM-dd HH:mm:ss转换到Calendar类型
	 * 
	 * @param dateStr
	 *            yyyy-MM-dd HH:mm:ss
	 * @return Calendar
	 */
	public static Calendar strDateTime2Calendar(String dateStr) {
		return str2Calendar(dateStr, FORMAT_yyyy_MM_dd_HH_mm_ss);
	}

	/**
	 * 字符串yyyy-MM-dd HH:mm:ss转换到Date类型
	 * 
	 * @param dateStr
	 *            yyyy-MM-dd HH:mm:ss
	 * @return Date
	 */
	public static Date strDateTime2Date(String dateStr) {
		return str2Date(dateStr, FORMAT_yyyy_MM_dd_HH_mm_ss);
	}

	/**
	 * 字符串转换到Date类型
	 * 
	 * @param dateStr
	 *            需要转换的字符串
	 * @param format
	 *            转换格式
	 * @return Date
	 */
	public static Date str2Date(String dateStr, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		Date date = dateFormat.parse(dateStr, new ParsePosition(0));
		return date;
	}

	/**
	 * 字符串转换到Calendar类型
	 * 
	 * @param dateStr
	 *            需要转换的字符串
	 * @param format
	 *            转换格式
	 * @return Calendar
	 */
	public static Calendar str2Calendar(String dateStr, String format) {
		Calendar calendar = Calendar.getInstance();
		// log.info(calendar);
		calendar.setTime(str2Date(dateStr, format));
		// log.info(calendar);
		return calendar;
	}

	/**
	 * 得到当前日期的Calendar类型
	 * 
	 * @return Calendar;
	 */
	public static Calendar now2Calendar() {
		return Calendar.getInstance();
	}

	/**
	 * 得到当前日期的FORMAT_yyyy_nian_M_yue_m_ri类型
	 */
	public static String calendar2DateStr(Calendar calendar) {
		String str = calendar2StrDate(calendar);
		Date date = str2Date(str, DateTimeUtils.FORMAT_yyyy_MM_dd);
		String dateStr = date2StrDate(date,
				DateTimeUtils.FORMAT_yyyy_nian_M_yue_m_ri);

		return dateStr;
	}

	/**
	 * 字符串yyyy-MM-dd HH:mm:ss 转换到 当天的开始Calendar类型
	 * 
	 * @param dateStr
	 *            yyyy-MM-dd HH:mm:ss
	 * @return Calendar
	 */
	public static Calendar strDateTime2CalendarDayBegin(String dateStr) {
		return str2Calendar(dateStr.substring(0, 10) + " 00:00:00",
				FORMAT_yyyy_MM_dd_HH_mm_ss);
	}

	/**
	 * 字符串yyyy-MM-dd HH:mm:ss 转换到 当天的结束Calendar类型
	 * 
	 * @param dateStr
	 *            yyyy-MM-dd HH:mm:ss
	 * @return Calendar
	 */
	public static Calendar strDateTime2CalendarDayEnd(String dateStr) {
		return str2Calendar(dateStr.substring(0, 10) + " 23:59:59",
				FORMAT_yyyy_MM_dd_HH_mm_ss);
	}

	public static Calendar dateAndTimeDatte2Calendar(Date date, Date time) {
		String dateStr = date2StrDate(date);

		String dateTimeStr = date2StrDateTime(date);
		int emptyIndex = dateStr.indexOf(" ");
		String timeStr = dateTimeStr
				.substring(emptyIndex, dateTimeStr.length());

		String dateTimeAllStr = dateStr + timeStr;

		return strDateTime2Calendar(dateTimeAllStr);
	}

	public static String intTime2StrTime(int time) {
		String timeStr = String.valueOf(time);
		if (timeStr.length() == 5) {
			return "0" + timeStr.substring(0, 1) + ":"
					+ timeStr.substring(1, 3) + ":" + timeStr.substring(3, 5);
		}

		if (timeStr.length() == 6) {
			return timeStr.substring(0, 2) + ":" + timeStr.substring(2, 4)
					+ ":" + timeStr.substring(4, 6);
		}

		return "";
	}

	public static final int getIntCurrYear() {
		return Integer.parseInt(getStrCurrYear());
	}

	public static final int getIntCurrMonth() {
		return Integer.parseInt(getStrCurrMonth());
	}

	public static final int getIntCurrDay() {
		return Integer.parseInt(getStrCurrDay());
	}

	public static final String getStrCurrYear() {
		return formatDatetime("yyyy", new Date());
	}

	public static final String getStrCurrMonth() {
		return formatDatetime("MM", new Date());
	}

	public static final String getStrCurrDay() {
		return formatDatetime("dd", new Date());
	}

	public static final String formatDatetime(String format, Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}

	public static final Date dateStr2DateTime(String dateStr, String ext) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				FORMAT_yyyy_MM_dd_HH_mm_ss);
		dateFormat.setLenient(false);
		Date date = dateFormat.parse(dateStr + " " + ext, new ParsePosition(0));
		return date;
	}

	public static final long getStartDateTimeInMillis(String date) {
		return getTimeInMillis(dateStr2DateTime(date, "00:00:00"));
	}

	public static String timeLine() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		return simpleDateFormat.format(new Date());
	}

	public static final long getEndDateTimeInMillis(String date) {
		return getTimeInMillis(dateStr2DateTime(date, "23:59:59"));
	}

	public static final long getTimeInMillis(Date dateTime) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateTime);
		return calendar.getTimeInMillis();
	}

	public static final Date dateStr2DateTime(String dateStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				FORMAT_yyyy_MM_dd_HH_mm_ss);
		dateFormat.setLenient(false);
		Date date = dateFormat.parse(dateStr, new ParsePosition(0));
		return date;
	}

	/**
	 * 
	 * @param date
	 * @return yyyy-MM-dd
	 */
	public static final String date2Str(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(date);
	}

	/*
	 * public static void main(String args[]) { // Calendar now =
	 * Calendar.getInstance(); // int year = now.get(Calendar.YEAR); // String
	 * month = String.valueOf(now.get(Calendar.MONTH)+1); // String date =
	 * String.valueOf(now.get(Calendar.DATE)); // // if (month.length() == 1) {
	 * // month = "0" + month; // } // // if (date.length() == 1) { // date =
	 * "0" + date; // } // System.out.println(year + month + date); //
	 * System.out.println(DateTimeUtils.intTime2StrTime(104937)); // for (int i
	 * = 0; i <100; i++) { //
	 * System.out.println(DateTimeUtils.getCurNoFormatDateTime()); // }
	 * 
	 * // Calendar calendar =
	 * DateTimeUtils.strDateTime2Calendar("2008-10-01 13:26:35"); //
	 * System.out.println(DateTimeUtils.calendar2StrDateTime(calendar));
	 * 
	 * // System.out.println(DateTimeUtils.calendar2StrDateTime(calendar)); //
	 * String d=todayAdd(90); // System.out.println(d); //
	 * System.out.println(getEndDateTimeInMillis(d));
	 * 
	 * Calendar c=DateTimeUtils.getCalendar_TodayAdd(90);
	 * 
	 * String d=DateTimeUtils.calendar2StrDate(c);
	 * 
	 * c.set(Calendar.HOUR_OF_DAY, 23); c.set(Calendar.MINUTE, 59);
	 * c.set(Calendar.SECOND, 59);
	 * 
	 * String de=DateTimeUtils.calendar2StrDateTime(c);
	 * 
	 * System.out.println(d);
	 * 
	 * System.out.println(de); long l=DateTimeUtils.getEndDateTimeInMillis(d);
	 * System.out.println(l);
	 * 
	 * }
	 */

	/**
	 * 日期相减-今日起时间往后减
	 * 
	 * @param subDay
	 * @return yyyy-mm-dd
	 */
	public static String todaySub(int subDay) {
		GregorianCalendar calendar = new GregorianCalendar();

		int day = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, day - subDay);
		Date yearDay = calendar.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preYearDay = df.format(yearDay);

		return preYearDay;
	}

	/**
	 * 日期相减-今日起时间往后减后的千分秒时间
	 * 
	 * @param subDay
	 * @return calendar.getTimeInMillis()
	 */
	public static long getTodaySubLong(int subDay) {
		GregorianCalendar calendar = new GregorianCalendar();

		int day = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, day - subDay);
		// Date yearDay = calendar.getTime();
		// DateFormat df = DateFormat.getDateInstance();
		// String preYearDay = df.format(yearDay);

		return calendar.getTimeInMillis();
	}

	/**
	 * 日期相加-今日起时间往后加
	 * 
	 * @param addDay
	 * @return yyyy-mm-dd
	 */
	public static Calendar getCalendar_TodayAdd(int addDay) {
		GregorianCalendar calendar = new GregorianCalendar();

		int day = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, day + addDay);
		// Date yearDay = calendar.getTime();
		// DateFormat df = DateFormat.getDateInstance();
		// String preYearDay = df.format(yearDay);
		//
		// return preYearDay;
		return calendar;

	}

	/**
	 * 日期相加-今日起时间往后加
	 * 
	 * @param addDay
	 * @return yyyy-mm-dd
	 */
	public static String todayAdd(int addDay) {
		GregorianCalendar calendar = new GregorianCalendar();

		int day = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, day + addDay);
		Date yearDay = calendar.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preYearDay = df.format(yearDay);

		return preYearDay;

	}

	/**
	 * 日期相加-今日起时间往后加后的千分秒时间
	 * 
	 * @param addDay
	 * @return calendar.getTimeInMillis()
	 */
	public static long getTodayAddLong(int addDay) {
		GregorianCalendar calendar = new GregorianCalendar();

		int day = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, day + addDay);
		// Date yearDay = calendar.getTime();
		// DateFormat df = DateFormat.getDateInstance();
		// String preYearDay = df.format(yearDay);

		return calendar.getTimeInMillis();
	}

	/**
	 * 判定有效结束日期date是否在本日之后
	 * 
	 * @param date
	 *            yyyy-MM-dd
	 * @return
	 */
	public static boolean afterToday(String date) {
		boolean after = false;
		long end = getEndDateTimeInMillis(date);
		long now = getTimeInMillis(new Date());
		if (end > now) {
			after = true;
		}
		return after;
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static final String date2Str2(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(date);
	}

	/**
	 * 
	 * @return yyyyMMdd
	 */
	public static String ymd() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		return simpleDateFormat.format(new Date());
	}

	/**
	 * 
	 * @return yyyyMMdd
	 */
	public static String ymd(String date) {
		System.out.println(" date ");
		Date d = dateStr2DateTime(date);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		return simpleDateFormat.format(d);
	}

	/**
	 * 讲日期时间转换成Long类型
	 * 
	 * @author <a href='mailto:dennisit@163.com'>Cn.pudp(En.dennisit)</a> Copy
	 *         Right since 2013-12-12 上午11:52:40
	 * @param dateStr
	 *            格式 yyyy-MM-dd hh:mm:ss
	 * @return 格式正确转换成对应的Long值,失败返回-1
	 */
	public static Long yyyyMMddToLong(String dateStr) {
		String st = new String(dateStr);
		SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = a.parse(st);
			return date.getTime();
		} catch (ParseException e) {

		}
		return -1L;
	}
	
	/**
	 * 取上一个月第一日
	 * @return
	 * @throws Exception
	 */
	public static String getLastMonth()throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_yyyy_MM_dd);
		Calendar calendar = Calendar.getInstance();// 获取当前日期
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String firstDay = sdf.format(calendar.getTime());
		return firstDay;
	}

	public static void main(String[] args) {
		System.out.println(yyyyMMddToLong("2013-12-23 12:24:34"));
	}
}

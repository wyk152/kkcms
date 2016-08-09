package org.wyk.main.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringUtil{
	private final static Log log = LogFactory.getLog(StringUtil.class);
    /**
     * 将target中的sign替换成value
     * @param target
     * @param sign
     * @param value
     * @return
     */
    public static final String replaceString(String target, String sign, String value) {
        if ((target == null) || (target.length() == 0))
            return target;
        StringBuffer sb = new StringBuffer();
        int i;
        while ((i = target.indexOf(sign)) >= 0) {
            sb.append(target.substring(0, i));
            sb.append(value);
            target = target.substring(i + sign.length());
        }
        if (target.length() > 0)
            sb.append(target);
        return sb.toString();
    }

    public static final String replaceEnter(String target) {
        if ((target == null) || (target.length() == 0))
            return target;
        target = replaceString(target, "\r\n", "<br>");
        target = replaceString(target, "\n", "<br>");
        return target;
    }
    /**
     * ascii2Html
     * @param target
     * @return
     */
    public static final String ascii2Html(String target) {
    	log.info("begin StringUtil.ascii2Html() read target is : " + target) ;
        if ((target == null) || (target.length() == 0))
            return target;
        target = replaceString(target, "&", "&amp;");
        target = replaceString(target, "\"", "&quot;");
        target = replaceString(target, "<", "&lt;");
        target = replaceString(target, ">", "&gt;");
      //  target = replaceString(target, " ", "&nbsp;");
        target = replaceString(target, "'", "&#39");
        target = replaceString(target, "\n", "<br >");
        target = replaceString(target, "\n", "<br>");
        target = replaceString(target, "\r\n", "<br >");
        target = replaceString(target, "\r\n", "<br>");
        log.info("end StringUtil.ascii2Html() read target is : " + target) ;
        return target;
    }
	/**
	 * html2Ascii
	 * @param target
	 * @return
	 */
    public static final String html2Ascii(String target) {
        if ((target == null) || (target.length() == 0))
            return target;
        target = replaceString(target, "&amp;", "&");
        target = replaceString(target, "&quot;", "\"");
        target = replaceString(target, "&lt;", "<");
        target = replaceString(target, "&gt;", ">");
     //   target = replaceString(target, "&nbsp;", " ");
        target = replaceString(target, "&#39", "'");
       // target = replaceString(target, "<br>", "\r\n");
        target = replaceString(target, "<br >", "\r\n");
        target = replaceString(target, "<br />", "\r\n");
        return target;
    }
    /**
     * 字符转换
     * @author ljf@800pahrm.com
     * @param target
     * @return
     */
    public static final String html2Ascii_2(String target) {
    	
    	if ((target == null) || (target.length() == 0))
    		return target;
    	
    	if(target.indexOf("&quot;")!=-1){
    		target = replaceString(target, "&quot;", "\"");
    	}
    	
    	if(target.indexOf("&lt;")!=-1){
    		target = replaceString(target, "&lt;", "<");
    	}
    	
    	if(target.indexOf("&gt;")!=-1){
    		target = replaceString(target, "&gt;", ">");
    	}
    	
    	if(target.indexOf("&amp;")!=-1){
    		target = replaceString(target, "&amp;", "&");
    	}
    	

    	return target;
    }

    public static final String GBK2UTF(String target) {
    	try {
    		return new String(target.getBytes("GBK"), "UTF-8");
    	} catch (Exception localException) {
    		System.err.println("GBK2UTF8编码转换发生错误!");
    	}
    	return null;
    }
    public static final String GBK2ISO(String target) {
        try {
            return new String(target.getBytes("GBK"), "ISO8859_1");
        } catch (Exception localException) {
            System.err.println("GBK2ISO编码转换发生错误!");
        }
        return null;
    }

    public static final String GB23122UTF8(String target) {
        try {
            return new String(target.getBytes("GB2312"), "UTF-8");
        } catch (Exception localException) {
            System.err.println("GBK2ISO编码转换发生错误!");
        }
        return null;
    }

    public static final String ISO2UTF8(String target) {
        try {
            return new String(target.getBytes("ISO8859-1"), "UTF-8");
        } catch (Exception localException) {
            System.out.println("ISO2UTF8");
        }
        return null;
    }

    public static final String Windows1252UTF8(String target) {
        try {
            return new String(target.getBytes("Windows-1252"), "UTF-8");
        } catch (Exception localException) {
            System.out.println("Windows1252UTF8");
        }
        return null;
    }

    public static final String UTF82ISO(String target) {
        try {
            return new String(target.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception localException) {
            System.err.println("GBK2ISO编码转换发生错误!");
        }
        return null;
    }

    public static final String UTF82GBK(String target) {
        try {
            return new String(target.getBytes("UTF-8"), "GBK");
        } catch (Exception localException) {
        }
        return null;
    }

    public static final String UTF82GB2312(String target) {
        try {
            return new String(target.getBytes("UTF-8"), "gb2312");
        } catch (Exception localException) {
        }
        return null;
    }

    public static String ISO2GBK(String target) {
        try {
            return new String(target.getBytes("ISO8859_1"), "GBK");
        } catch (Exception localException) {
            System.err.println("ISO2GBK编码转换发生错误!");
        }
        return null;
    }

    public static final String dealNull(String target) {
        if (target == null)
            return "";
        return target;
    }

    public static final String dealSql(String target) {
        if ((target == null) || (target.trim().length() == 0))
            return target;
        String str = replaceString(target.trim().replaceAll("\r", ""), "'", "''");
        str = replaceString(str, "\\", "\\\\");
        if (str.charAt(0) != '\'')
            str = "'" + str;
        if (!(str.endsWith("'")))
            str = str + "'";
        return str;
    }

    public static final String getMultiString(String[] paramArrayOfString) {
        return getMultiString(paramArrayOfString, ",");
    }

    public static final String getMultiString(String[] paramArrayOfString, String target) {
        if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
            return "";
        StringBuffer localStringBuffer = new StringBuffer();
        String str = target;
        String[] arrayOfString = paramArrayOfString;
        int i = 0;
        for (i = 0; i < arrayOfString.length - 1; ++i)
            localStringBuffer.append(arrayOfString[i] + str);
        localStringBuffer.append(arrayOfString[i]);
        return localStringBuffer.toString();
    }

    public static final boolean isBlank(String target) {
        return ((target == null) || (target.trim().length() == 0) || "".equals(target));
    }
    
    public static final boolean isNotBlank(String target) {
		return isBlank(target) == false ? true : false;
	}

    public static final String getString(String target) {
        return getString(target, null);
    }

    public static final String getString(String target, String replace) {
        if (target == null)
            return replace;
        return target;
    }

    public static final int getInt(String paramString) {
        return getInt(paramString, 0);
    }

    public static final int getInt(String paramString, int paramInt) {
        if (paramString == null)
            return paramInt;
        try {
            return Integer.parseInt(paramString.trim());
        } catch (Exception localException) {
        }
        return paramInt;
    }

    public static final long getLong(String input) throws Exception, NumberFormatException {
        if (StringUtils.isEmpty(input) == true)
            input = "0";
        try {
            return Long.parseLong(input.trim());
        } catch (NumberFormatException localNumberFormatException) {
            localNumberFormatException.printStackTrace();
        }
        return 0L;
    }

    public static final double getDouble(String input,double detVaL) throws Exception, NumberFormatException {
    	if (StringUtils.isEmpty(input) == true)
    		input = "0";
    	
    	try {
    		return Double.parseDouble(input);
    	} catch (NumberFormatException localNumberFormatException) {
    	}
    	return 0D;
    }
    
    public static final double getDouble(HttpServletRequest httpServletRequest, String paramsName,double detVaL) throws Exception,
    NumberFormatException {
    	String str = getString(httpServletRequest, paramsName);
    	try {
    		return Double.parseDouble(str);
    	} catch (NumberFormatException localNumberFormatException) {
    	}
    	return 0D;
    }
    public static final double getDouble(String input) throws Exception, NumberFormatException {
    	
        return getDouble(input,0D);
    }

    public static final double getDouble(HttpServletRequest httpServletRequest, String paramsName) throws Exception,
            NumberFormatException {
    	return getDouble(httpServletRequest,paramsName,0D);
    }

    public static final float getFloat(String paramString) throws Exception, NumberFormatException {
        if (paramString == null)
            throw new Exception("Input value is NULL!");
        try {
            return Float.parseFloat(paramString.trim());
        } catch (NumberFormatException localNumberFormatException) {
            throw new NumberFormatException("getFloat(String) NumberFormatException for input string:" + paramString);
        }
    }

    public static final float getFloat(HttpServletRequest httpServletRequest, String paramsName) throws Exception,
            NumberFormatException {
        String str = httpServletRequest.getParameter(paramsName);
        if (str == null)
            return 0F;
        try {
            return Float.parseFloat(str.trim());
        } catch (NumberFormatException localNumberFormatException) {
        }
        return 0F;
    }

    public static final float getFloat(HttpServletRequest httpServletRequest, String paramString, float paramFloat)
            throws Exception, NumberFormatException {
        String str = httpServletRequest.getParameter(paramString);
        if (str == null) {
            System.out.println("val is null,so return default!");
            return paramFloat;
        }
        try {
            return Float.parseFloat(str.trim());
        } catch (NumberFormatException localNumberFormatException) {
            System.out
                    .println("getFloat(HttpServletRequest request,String strName,float def) NumberFormatException for input string:"
                            + str + ",so return default!");
        }
        return paramFloat;
    }

    public static final long getLong(String paramString, long paramLong) {
        if (paramString == null)
            return paramLong;
        try {
            return Long.parseLong(paramString);
        } catch (Exception localException) {
        }
        return paramLong;
    }

    public static final String getString(String paramString, int paramInt) {
        if (paramString == null)
            return null;
        if (_$1(paramString) <= paramInt)
            return paramString;
        byte[] arrayOfByte1 = paramString.getBytes();
        byte[] arrayOfByte2 = new byte[paramInt];
        for (int i = 0; i < paramInt; ++i)
            arrayOfByte2[i] = arrayOfByte1[i];
        return _$1(arrayOfByte2);
    }

    private static int _$1(String paramString) {
        if (paramString == null)
            return 0;
        return paramString.getBytes().length;
    }

    private static final String _$1(byte[] paramArrayOfByte) {
        String str = new String(paramArrayOfByte);
        if (str.length() == 0) {
            int i = paramArrayOfByte.length;
            if (i > 1) {
                byte[] arrayOfByte = new byte[i - 1];
                for (int j = 0; j < i - 1; ++j)
                    arrayOfByte[j] = paramArrayOfByte[j];
                return _$1(arrayOfByte);
            }
            return "";
        }
        return str;
    }

    public static final int getInt(HttpServletRequest httpServletRequest, String paramString) {
        return getInt(httpServletRequest, paramString, 0);
    }

    public static final int getInt(HttpServletRequest httpServletRequest, String paramString, int paramInt) {
        if (httpServletRequest.getParameter(paramString) != null)
            try {
                int i = Integer.parseInt(httpServletRequest.getParameter(paramString));
                return i;
            } catch (NumberFormatException localNumberFormatException) {
                return 0;
            }
        return paramInt;
    }

    public static final long getLong(HttpServletRequest httpServletRequest, String paramString) {
        if (httpServletRequest.getParameter(paramString) != null)
            try {
                long l = Long.parseLong(httpServletRequest.getParameter(paramString).trim());
                return l;
            } catch (NumberFormatException localNumberFormatException) {
                return 0L;
            }
        return 0L;
    }

    public static final long getLong(HttpServletRequest httpServletRequest, String paramString, long paramLong) {
        if (isNotBlank(httpServletRequest.getParameter(paramString)))
            try {
                long l = Long.parseLong(httpServletRequest.getParameter(paramString).trim());
                return l;
            } catch (NumberFormatException e) {
            	e.printStackTrace();
                return 0L;
            }
        return paramLong;
    }

    public static final String getString(HttpServletRequest httpServletRequest, String paramString) {
        if (paramString == null)
            return null;
        String str = httpServletRequest.getParameter(paramString);
        if ((str != null) && (!(str.equals(""))))
            return str.trim();
        return "";
    }

    public static final String getString(HttpServletRequest httpServletRequest, String paramString1, String paramString2) {
        String str = httpServletRequest.getParameter(paramString1);
        if ((str != null) && (!(str.equals(""))))
            return str.trim();
        return paramString2;
    }

    public static final HttpSession getSession(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getSession(true);
    }

    public static final String cutString(String paramString1, int paramInt, String paramString2) {
        int i = paramString1.length();
        if (i > paramInt)
            paramString1 = paramString1.substring(0, paramInt) + paramString2;
        return paramString1;
    }

    public static String formatNumber(String paramString, double paramDouble) {
        DecimalFormat localDecimalFormat = new DecimalFormat(paramString);
        return localDecimalFormat.format(paramDouble);
    }

    public static String formatNumber(String paramString, long paramLong) {
        DecimalFormat localDecimalFormat = new DecimalFormat(paramString);
        return localDecimalFormat.format(paramLong);
    }

    public static final String getBackURL(HttpServletRequest httpServletRequest) {
        String backUrl = getString(httpServletRequest, "backurl");
        backUrl = replaceString(backUrl, "@", "");
        if (backUrl.equals("")) {
            String referer = httpServletRequest.getHeader("referer");
            if (referer == null) {
                referer = "";
            }

            return referer;
        }
        return backUrl;
    }
    public static String getRefer(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader("referer");
    }

    public static String getCurrentURL(HttpServletRequest httpServletRequest) {
        String str = httpServletRequest.getQueryString();
        if (str == null)
            return httpServletRequest.getRequestURI();
        return httpServletRequest.getRequestURI() + "?" + str;
    }

    public static String enCodeBackURL(String paramString) {
        return paramString.replace('&', '!');
    }

    public static String deCodeBackURL(String paramString) {
        return paramString.replace('!', '&');
    }

    public static long bin2Dec(String paramString) {
        int i = paramString.length();
        long l = 0L;
        for (int k = 0; k < i; ++k) {
            int j = getInt(paramString.substring(i - k - 1, i - k));
            l = (long) (l + j * Math.pow(2.0D, k));
        }
        return l;
    }

    public static String getStatusForCheckBoxAndRadio(int paramInt) {
        if (paramInt == 0)
            return "";
        return "checked";
    }

    public static void setCookie(HttpServletResponse httpServletResponse, String paramString1,
            String paramString2, int paramInt) throws UnsupportedEncodingException {
        Cookie localCookie = new Cookie(paramString1, URLEncoder.encode(paramString2, "utf-8"));
        localCookie.setMaxAge(paramInt);
        localCookie.setPath("/");
        httpServletResponse.addCookie(localCookie);
    }

    public static void setSessionCookie(HttpServletResponse httpServletResponse, String paramString1,
            String paramString2) throws UnsupportedEncodingException {
        Cookie localCookie = new Cookie(paramString1, URLEncoder.encode(paramString2, "utf-8"));
        localCookie.setPath("/");
        httpServletResponse.addCookie(localCookie);
    }

    public static void setCookie(HttpServletResponse httpServletResponse, String paramString1,
            String paramString2, int paramInt, String[] paramArrayOfString) throws UnsupportedEncodingException {
        for (int i = 0; i < paramArrayOfString.length; ++i) {
            Cookie localCookie = new Cookie(paramString1, URLEncoder.encode(paramString2, "utf-8"));
            localCookie.setMaxAge(paramInt);
            localCookie.setPath("/");
            localCookie.setDomain(paramArrayOfString[i]);
            httpServletResponse.addCookie(localCookie);
        }
    }

    public static void setSessionCookie(HttpServletResponse httpServletResponse, String paramString1,
            String paramString2, String[] paramArrayOfString) throws UnsupportedEncodingException {
        for (int i = 0; i < paramArrayOfString.length; ++i) {
            Cookie localCookie = new Cookie(paramString1, URLEncoder.encode(paramString2, "utf-8"));
            localCookie.setPath("/");
            localCookie.setDomain(paramArrayOfString[i]);
            httpServletResponse.addCookie(localCookie);
        }
    }

    public static String getCookie(HttpServletRequest httpServletRequest, String paramString)
            throws UnsupportedEncodingException {
        Cookie[] arrayOfCookie = httpServletRequest.getCookies();
        if (arrayOfCookie == null)
            return null;
        for (int i = 0; i < arrayOfCookie.length; ++i)
            if ((arrayOfCookie[i] != null) && (arrayOfCookie[i].getName().equals(paramString)))
                return URLDecoder.decode(arrayOfCookie[i].getValue(), "utf-8");
        return null;
    }

    public static String[] getCookie(HttpServletRequest httpServletRequest) throws UnsupportedEncodingException {
        Cookie[] arrayOfCookie = httpServletRequest.getCookies();
        ArrayList localArrayList = new ArrayList();
        if (arrayOfCookie == null)
            return null;
        for (int i = 0; i < arrayOfCookie.length; ++i)
            localArrayList.add(arrayOfCookie[i].getName() + " = "
                    + URLDecoder.decode(arrayOfCookie[i].getValue(), "utf-8"));
        return ((String[]) (String[]) localArrayList.toArray(new String[0]));
    }

    public static void delCookie(HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest,
            String paramString) throws UnsupportedEncodingException {
        Cookie[] arrayOfCookie = httpServletRequest.getCookies();
        if (arrayOfCookie != null)
            for (int i = 0; i < arrayOfCookie.length; ++i) {
                String str = arrayOfCookie[i].getName();
                if (str.equals(paramString)) {
                    arrayOfCookie[i].setMaxAge(0);
                    httpServletResponse.addCookie(arrayOfCookie[i]);
                }
            }
    }

    public static void delCookie(HttpServletResponse httpServletResponse, String paramString,
            String[] paramArrayOfString) throws UnsupportedEncodingException {
        for (int i = 0; i < paramArrayOfString.length; ++i) {
            Cookie localCookie = new Cookie(paramString, null);
            localCookie.setMaxAge(0);
            localCookie.setPath("/");
            localCookie.setDomain(paramArrayOfString[i]);
            httpServletResponse.addCookie(localCookie);
        }
    }

    public static String removeHH(String paramString) {
        return replaceString(replaceString(paramString, "\n", ""), "\r", "");
    }

    public static String readURL(String paramString) throws Exception {
        String str1 = "";
        String str2 = "";
        try {
            URL localURL = new URL(paramString);
            HttpURLConnection localHttpURLConnection = (HttpURLConnection) localURL.openConnection();
            localHttpURLConnection.connect();
            InputStream localInputStream = localHttpURLConnection.getInputStream();
            BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
            while ((str1 = localBufferedReader.readLine()) != null)
                str2 = str2 + str1 + "\n";
            localBufferedReader.close();
        } catch (MalformedURLException localMalformedURLException) {
            localMalformedURLException.printStackTrace();
        } catch (IOException localIOException) {
            localIOException.printStackTrace();
        }
        return str2;
    }

    public static String withColor(String paramString1, String paramString2, boolean paramBoolean) {
        if (paramBoolean)
            return "<font color='".concat(paramString2).concat("'>").concat(paramString1).concat("</font>");
        return paramString1;
    }

    public static String getStringFromSession(HttpSession paramHttpSession, String paramString) {
        if (paramHttpSession.getAttribute(paramString) != null)
            return paramHttpSession.getAttribute(paramString).toString();
        return null;
    }

    public static int getIntFromSession(HttpSession paramHttpSession, String paramString) {
        if (getStringFromSession(paramHttpSession, paramString) != null)
            return getInt(getStringFromSession(paramHttpSession, paramString));
        return 0;
    }

    public static float getFloatFromSession(HttpSession paramHttpSession, String paramString) {
        if (getStringFromSession(paramHttpSession, paramString) != null)
            try {
                return getFloat(getStringFromSession(paramHttpSession, paramString));
            } catch (NumberFormatException localNumberFormatException) {
                return 0F;
            } catch (Exception localException) {
                return 0F;
            }
        return 0F;
    }

    public static String getAllParameters(HttpServletRequest httpServletRequest) {
        Enumeration localEnumeration = httpServletRequest.getParameterNames();
        StringBuffer localStringBuffer = new StringBuffer("");
        while (localEnumeration.hasMoreElements()) {
            String str1 = (String) localEnumeration.nextElement();
            String str2 = httpServletRequest.getParameter(str1);
            localStringBuffer.append(str1);
            localStringBuffer.append("=");
            localStringBuffer.append(str2);
            localStringBuffer.append("&");
        }
        return localStringBuffer.toString();
    }


    public static final String loginWebSite(String paramString) throws Exception {
        StringBuffer localStringBuffer = new StringBuffer("");
        URL localURL = new URL(paramString);
        HttpURLConnection localHttpURLConnection = (HttpURLConnection) localURL.openConnection();
        localHttpURLConnection = (HttpURLConnection) localURL.openConnection();
        localHttpURLConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows 2000)");
        localHttpURLConnection.connect();
        InputStream localInputStream = localHttpURLConnection.getInputStream();
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream, "UTF-8"));
        String str;
        while ((str = localBufferedReader.readLine()) != null) {
            localStringBuffer.append(str);
            localStringBuffer.append("\n");
        }
        return localStringBuffer.toString();
    }

    public static String regReplace(String paramString1, String paramString2, String paramString3) {
        String str = new String();
        str = paramString1;
        if ((paramString1 != null) && (!(paramString1.equals("")))) {
            str = paramString1;
            Pattern localPattern = Pattern.compile(paramString2, 2);
            Matcher localMatcher = localPattern.matcher(str);
            StringBuffer localStringBuffer = new StringBuffer();
            int i = 0;
            for (boolean bool = localMatcher.find(); bool; bool = localMatcher.find()) {
                ++i;
                localMatcher.appendReplacement(localStringBuffer, paramString3);
            }
            localMatcher.appendTail(localStringBuffer);
            str = localStringBuffer.toString();
        } else {
            str = "";
        }
        return str;
    }


    public static final String cuteNR(String paramString) {
        paramString = replaceString(paramString, "\n", "");
        paramString = replaceString(paramString, "\r", "");
        return paramString;
    }


    public static final double getDoubleType() {
        return 0D;
    }

    public static final float getFloatType() {
        return 0F;
    }

    public static final long getLongType() {
        return 0L;
    }

    public static final long getLongType(String paramString) {
        return Long.parseLong(paramString);
    }

    public static final boolean getTrueType() {
        return true;
    }

    public static final boolean getFalseType() {
        return false;
    }

    public static final Object getObjectType() {
        return new Object();
    }

    public static final boolean getBooleanType(int paramInt) {
        return (paramInt == 1);
    }

    public static final Object getNullType() {
        return null;
    }
    
    public static int getFindCount(String sqlItemValue, String srcBreakChar) {
        sqlItemValue = StringUtils.trimToEmpty(sqlItemValue);
        srcBreakChar = StringUtils.trimToEmpty(srcBreakChar);
        int intStart = 0;
        int intEnd = 0;
        int i = 0;
        for (intEnd = sqlItemValue.indexOf(srcBreakChar, intStart); intEnd > -1; intEnd = sqlItemValue.indexOf(srcBreakChar, intStart)) {
            i++;
            if (srcBreakChar.length() == 0) {
                intStart = intEnd + 1;
            } else {
                intStart = intEnd + srcBreakChar.length();
            }
        }

        return i;
    }
    
    public static String[] split(String sqlItemValue, String srcBreakChar) {
        sqlItemValue = StringUtils.trimToEmpty(sqlItemValue);
        srcBreakChar = StringUtils.trimToEmpty(srcBreakChar);
        
        int intCount = getFindCount(sqlItemValue, srcBreakChar) + 1;
        String astrItem[] = new String[intCount];
        int intStart = 0;
        int intEnd = 0;
        int i = 0;
        for (intEnd = sqlItemValue.indexOf(srcBreakChar, intStart); intEnd > -1; intEnd = sqlItemValue
                .indexOf(srcBreakChar, intStart)) {
            astrItem[i] = sqlItemValue.substring(intStart, intEnd);
            i++;
            if (srcBreakChar.length() == 0)
                intStart = intEnd + 1;
            else
                intStart = intEnd + srcBreakChar.length();
        }

        astrItem[astrItem.length - 1] = sqlItemValue.substring(intStart, sqlItemValue.length());
        return astrItem;
    }
    
    public static String replace(String sqlItemValue, String srcBreakChar, String destChar) {
        sqlItemValue = StringUtils.trimToEmpty(sqlItemValue);
        srcBreakChar = StringUtils.trimToEmpty(srcBreakChar);
        destChar = StringUtils.trimToEmpty(destChar);
        
        String astrItem[] = split(sqlItemValue, srcBreakChar);
        String strResult = "";
        for (int i = 0; i < astrItem.length - 1; i++)
            strResult = (new StringBuilder(String.valueOf(strResult))).append(astrItem[i]).append(destChar).toString();

        return (new StringBuilder(String.valueOf(strResult))).append(astrItem[astrItem.length - 1]).toString();
    }

    public static String getSafeScriptString(String strValue) {
        strValue = replace(strValue, "\n", "");
        strValue = replace(strValue, "\r", "");
        strValue = replace(strValue, "\\", "\\\\");
        strValue = replace(strValue, "\"", "\\\"");
        return strValue;
    }

    public static String getSafeSql(String strValue) {
        return replace(strValue, "'", "''");
    }


    public static final String selectIt(long paramLong1, long paramLong2) {
        return ((paramLong1 == paramLong2) ? "selected" : "");
    }

    public static final String checkedIt(long paramLong1, long paramLong2) {
        return ((paramLong1 == paramLong2) ? "checked" : "");
    }

    public static final String checkedIt(String paramString1, String paramString2) {
        return ((paramString1.equals(paramString2)) ? "checked" : "");
    }

    public float getPayCostPercent(float paramFloat) {
        return (paramFloat * 100.0F);
    }

    public static final int isNull(Object paramObject) {
        if (paramObject == null)
            return 1;
        return 0;
    }
    public static final boolean ObjectIsNull(Object paramObject) {
    	if (paramObject == null)
    		return true;
    	return false;
    }
	
    /**
     * 把四位IP地址转换成相应的长整型和
     * @param ipAddr IP地址
     * @return 整数
     * @throws Exception
     */
    public static long getIPAddrConvertLong(String ipAddr) throws Exception {
        long ip = 16777216L * StringUtil.getLong(ipAddr.split("\\.")[0]) + 65536L
                * StringUtil.getLong(ipAddr.split("\\.")[1]) + 256L * StringUtil.getLong(ipAddr.split("\\.")[2])
                + StringUtil.getLong(ipAddr.split("\\.")[3]);
        return ip;
    }
    

    /**
     * 浏览器相关信息
     * @param userAgent
     * @return
     */
    public static String getBrowser(String userAgent) {
        String otherBrowser = getOtherBrowser(userAgent);
        String ieBrowser = getMSIE(userAgent);
        if (!(otherBrowser.equals("")))
            return otherBrowser + " " + ieBrowser;
        if (!(ieBrowser.equals(""))) {
            ieBrowser = ieBrowser.substring(2);
            return ieBrowser;
        }
        return "";
    }
    /**
     * 其他浏览器
     * @param userAgent
     * @return
     */
    private static String getOtherBrowser(String userAgent) {
        String browsers = "((Firefox|Netscape|TencentTraveler|Maxthon|Opera|NetCaptor|MSN|Lynx)(/([0-9]\\.)*[0-9]+)*)";
        Pattern pattern = Pattern.compile(browsers, 2);
        Matcher matcher = pattern.matcher(userAgent);
        if (matcher.find()) {
            String result = matcher.group(1);
            if (result != null) {
                return result;
            }
        }
        return "";
    }
    /**
     * IE浏览器
     * @param useAgent
     * @return
     */
    private static String getMSIE(String useAgent) {
        String ie = "(MSIE (([0-9]\\.)*[0-9]+))";
        Pattern pattern = Pattern.compile(ie, 2);
        Matcher matcher = pattern.matcher(useAgent);
        if (matcher.find()) {
            String result = matcher.group(1);
            if (result != null) {
                return result;
            }
        }
        return "";
    }
    
    private static String getOSGroupOne(String userAgent) {
        String os = "; (Windows NT|Windows|Linux|SunOS|BSD|Mac|unix)( ([0-9]\\.)*[0-9]+)*";
        Pattern pattern = Pattern.compile(os, 2);
        Matcher matcher = pattern.matcher(userAgent);
        if (matcher.find()) {
            String result = matcher.group(1);
            if (result != null) {
                return result;
            }
        }
        return "";
    }

    private static String getOSGroupTwo(String userAgent) {
        String os = "; (Windows NT|Windows|Linux|SunOS|BSD|Mac|unix)( ([0-9]\\.)*[0-9]+)*";
        Pattern pattern = Pattern.compile(os, 2);
        Matcher matcher = pattern.matcher(userAgent);
        if (matcher.find()) {
            String result = matcher.group(2);
            if (result != null) {
                return result;
            }
        }
        return "";
    }

    public static String getSystemOS(String userAgent) {
        return getOSGroupOne(userAgent) + " " + getOSGroupTwo(userAgent);
    }


    public static String getRemortIP(HttpServletRequest request) {
    	
	     String ip = request.getHeader("x-forwarded-for");     
	      if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {            
	         ip = request.getHeader("Proxy-Client-IP"); 
	     }            
	      if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {            
	         ip = request.getHeader("WL-Proxy-Client-IP");  
	      }            
	     if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {            
	          ip = request.getRemoteAddr(); 
	     }  
	    if(ip.indexOf(",")!=-1){
	    	ip=ip.split(",")[0];
	    }
		if(ip!=null && !"".equals(ip) && ip.length()>15 ){
		    ip = ip.substring(0,15);
		}
		
		return ip;
   }
    
    public static final String getTurnPage(PageCtrl pageCtrl, int paramInt) {
        TurnStep localTurnStep = new TurnStep();
        localTurnStep.setP(pageCtrl.getPageNo());
        localTurnStep.setStepRange(10);
        localTurnStep.setRight(4);
        localTurnStep.setTotal(pageCtrl.getPageCount());
        localTurnStep.init();
        int i = pageCtrl.getPageNo() - 1;
        int j = pageCtrl.getPageNo() + 1;
        StringBuffer localStringBuffer = new StringBuffer();
        if (pageCtrl.isFirst())
            localStringBuffer.append("<a onfocus='this.blur()' href=javascript:go(1)>"
                    + ConsVar.turnpage_first
                    + "</a>");
        else
            localStringBuffer.append("<SPAN class=nextprev>"
                    + ConsVar.turnpage_first
                    + "</span>");
        if (pageCtrl.isFornt())
            localStringBuffer.append("<a onfocus='this.blur()'  href=javascript:go(" + i + ")>"
                    + ConsVar.turnpage_back
                    + "</a>");
        else
            localStringBuffer.append("<SPAN class=nextprev>"
                    + ConsVar.turnpage_back
                    + "</span>");
        for (int k = localTurnStep.getST(); k <= localTurnStep.getEN(); ++k)
            if ((k == paramInt) || ((paramInt == 0) && (k == 1)))
                localStringBuffer.append(" <span class=current>" + k + "</span> ");
            else
                localStringBuffer.append(" <a  onfocus='this.blur()' href=javascript:go(" + k + ")>" + k + "</a> ");
        if (pageCtrl.isNext())
            localStringBuffer.append("<a  onfocus='this.blur()' href=javascript:go(" + j + ")>"
                    + ConsVar.turnpage_next
                    + "</a>");
        else
            localStringBuffer.append("<SPAN class=nextprev>"
                    + ConsVar.turnpage_next
                    + "</span>");
        if (pageCtrl.isLast())
            localStringBuffer.append("<a  onfocus='this.blur()' href=javascript:go(" + pageCtrl.getPageCount() + ")>"
                    + ConsVar.turnpage_last
                    + "</a>");
        else
            localStringBuffer.append("<SPAN class=nextprev>"
                    + ConsVar.turnpage_last
                    + "</span>");
        return localStringBuffer.toString();
    }
    /**
     * 按字节长度截取字符串(支持截取带HTML代码样式的字符串)
     * @param param 将要截取的字符串参数
     * @param length 截取的字节长度
     * @param end 字符串末尾补上的字符串
     * @return 返回截取后的字符串
     */
    public static String subStringHTML(String param,int length,String end) {
        StringBuffer result = new StringBuffer();
        int n = 0;
        char temp;
        boolean isCode = false; //是不是HTML代码
        boolean isHTML = false; //是不是HTML特殊字符,如&nbsp;
        boolean append=false;
        for (int i = 0; i < param.length(); i++) {
          temp = param.charAt(i);
          if (temp == '<') {
            isCode = true;
          }
          else if (temp == '&') {
            isHTML = true;
          }
          else if (temp == '>' && isCode) {
            n = n - 1;
            isCode = false;
          }
          else if (temp == ';' && isHTML) {
            isHTML = false;
          }

          if (!isCode && !isHTML) {
            n = n + 1;
            //UNICODE码字符占两个字节
            if ( (temp + "").getBytes().length > 1) {
              n = n + 1;
            }
          }

          result.append(temp);
          if (n >= length) {
        	  append=true;
            break;
          }
        }
      //  result.append(end);
        //取出截取字符串中的HTML标记
        String temp_result = result.toString().replaceAll("(>)[^<>]*(<?)", "$1$2");
        //去掉不需要结素标记的HTML标记
        temp_result = temp_result.replaceAll("</?(AREA|BASE|BASEFONT|BODY|BR|COL|COLGROUP|DD|DT|FRAME|HEAD|HR|HTML|IMG|INPUT|ISINDEX|LI|LINK|META|OPTION|P|PARAM|TBODY|TD|TFOOT|TH|THEAD|TR|area|base|basefont|body|br|col|colgroup|dd|dt|frame|head|hr|html|img|input|isindex|li|link|meta|option|p|param|tbody|td|tfoot|th|thead|tr)[^<>]*/?>",
                                             "");
        //去掉成对的HTML标记
        temp_result=temp_result.replaceAll("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>","$2");
        //用正则表达式取出标记
        Pattern p = Pattern.compile("<([a-zA-Z]+)[^<>]*>");
        Matcher m = p.matcher(temp_result);

        List endHTML = new ArrayList();

        while (m.find()) {
          endHTML.add(m.group(1));
        }
        //补全不成对的HTML标记
        for (int i = endHTML.size() - 1; i >= 0; i--) {
          result.append("</");
          result.append(endHTML.get(i));
          result.append(">");
        }
        if(append){
        	result.append(end); 
        }
        return result.toString();
      }
	/**
	 * 生成充值申请单号
	 * @return
	 */
    public static String getAddNo() {
		//8位
        String ono=DateTimeUtils.ymd();
        
        StringBuffer orderNo=new StringBuffer();
        
        Random r = new Random(); 
        int sj=r.nextInt(99);
        int sj2=RandomUtils.nextInt(99);
        
        orderNo.append("cz").append(ono).append(sj+sj2).append(sj2).append(sj);
        return orderNo.toString();
    }
    public static String getBatchOid() {
    	ShopUUIDUtil uuid = new ShopUUIDUtil();
        return uuid.generate().toString();
    }
    
    public static void main(String[] paramArrayOfString) throws Exception {
    	System.out.println(subStringHTML("百度一下,<a href='http://www.baidu.com'>百度</a>古古怪怪广告稿反反复复",20,"...")); 
    }
    
	public static String buildGetter(String property){
		String proHead = property.substring(0, 1);
		proHead = proHead.toUpperCase();
		return "get" + proHead + property.substring(1, property.length());
	}
	
	public static String buildSetter(String property){
		String proHead = property.substring(0, 1);
		proHead = proHead.toUpperCase();
		return "set" + proHead + property.substring(1, property.length());
	}
	
	public static String replaceHtmlImgSrc(String img) throws Exception {
		String site_url=PropertiesUtil.getStringProperty(("shop_url"), "");
		img = StringUtil.regReplace(img, "src=\\s*[\"']((/{1}.+-*)+[.]{1}(gif|jpg|jpeg|jpe|png|bmp|swf))[\"']", "src=\"" + site_url + "$1\"");
		img = StringUtil.replaceString(img, "../../upl_imags", site_url + "upl_imags");
		return img;
	}
	
}
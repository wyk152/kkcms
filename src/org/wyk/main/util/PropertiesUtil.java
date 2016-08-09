package org.wyk.main.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author wyk
 * @time  2016年6月5日
 */
public class PropertiesUtil {
    private static Log log = LogFactory.getLog(PropertiesUtil.class);

    private static Properties props = new Properties();

    static {
        try {
            if (props.size() == 0) {
                log.info("Start read the constv.properties file.");
                InputStream input = PropertiesUtil.class.getResourceAsStream("/constv.properties");
                props.load(input);
                input.close();
            }
        } catch (IOException ioe) {
            log.error(ioe.getMessage());
            log.debug(ioe);
        }
    }

    public static String getStringProperty(String propertyName, String defaultValue) {
        if (props.containsKey(propertyName) == true) {
            return (String) props.get(propertyName);
        }

        return defaultValue;
    }
    public static String getStringProperty(String propertyName, String defaultValue,String encoding) {
        if (props.containsKey(propertyName) == true) {
        	//编码转换，从ISO8859-1转向指定编码
        	String value=(String) props.get(propertyName);
        	try {
				value = new String(value.getBytes("ISO8859-1"), encoding);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
            return value;
        }

        return defaultValue;
    }
    public static long getLong(String propertyName) {
    	return getLong(propertyName, -1);
    }
    public static String getString(String propertyName) {
    	return getStringProperty(propertyName, "");
    }
    public static long getLong(String propertyName, long defaultValue) {
        if (props.containsKey(propertyName) == true) {
        	
            try {
				return StringUtil.getLong((String) props.get(propertyName));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        return defaultValue;
    }
}

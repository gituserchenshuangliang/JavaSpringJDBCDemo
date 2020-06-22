package com.spring.util;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @description:日志工具
 * @author: Cherry
 * @time: 2020/6/5 8:55
 */
public class LoggerUtil {
    public static Logger getLog(Class clazz){
        return LogManager.getLogger(clazz.getName());
    }

    public static void jsonToLog(Class clazz,Object obj){
        LogManager.getLogger(clazz.getName()).info(JSON.toJSONString(obj));
    }
}

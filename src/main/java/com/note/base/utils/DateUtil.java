package com.note.base.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * <p>TODO </p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lvxz5
 * @version 1.0
 * @date 2017/3/21
 * @since 1.0
 */
public class DateUtil {

    private static ZoneId zone = ZoneId.systemDefault();

    public static Date nowDate(){
        return Date.from(LocalDateTime.now().atZone(zone).toInstant());
    }

    public static Date nowDate(ZoneId zone){
        return Date.from(LocalDateTime.now().atZone(zone).toInstant());
    }
}

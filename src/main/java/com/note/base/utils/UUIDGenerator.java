package com.note.base.utils;

import java.util.UUID;

/**
 * <p>UUID </p>
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
public class UUIDGenerator {

    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}

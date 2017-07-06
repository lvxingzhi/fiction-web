package com.note.base.utils;

import com.google.common.base.Objects;

import java.util.Collection;

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
 * @date 2017/2/28
 * @since 1.0
 */
public class ObjectUtil {

    /**
     * null,"",空集合,返回false
     * @param obj
     * @return
     */
    public static boolean notNull(Object obj){
        if(Objects.equal(obj,null)){
            return false;
        }
        if(obj instanceof String){
            if(Objects.equal(((String) obj).trim(),"")){
                return false;
            }
        }
        if(obj instanceof Collection){
            if(((Collection) obj).size()==0){
                return false;
            }
        }
        return true;
    }

    /**
     * null,"",空集合,返回true
     * @param obj
     * @return
     */
    public static boolean isNull(Object obj){
        if(Objects.equal(obj,null)){
            return true;
        }
        if(obj instanceof String){
            if(Objects.equal(((String) obj).trim(),"")){
                return true;
            }
        }
        if(obj instanceof Collection){
            if(((Collection) obj).size()==0){
                return true;
            }
        }
        return false;
    }

    /**
     * 字符串null转成""
     * @param data
     * @return
     */
    public static String dualStringNull(String data){
        return isNull(data)?"":data;
    }


}

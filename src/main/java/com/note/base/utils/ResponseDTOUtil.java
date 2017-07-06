package com.note.base.utils;

import com.note.base.dto.ResponseDTO;
import com.note.base.exception.SystemException;

import java.text.MessageFormat;

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
 * @date 2017/5/9
 * @since 1.0
 */
public class ResponseDTOUtil {

    public static <T> T getData(String json,Class<T> c){
        ResponseDTO responseDTO = JsonUtil.fromJson(json,ResponseDTO.class);
        if(!responseDTO.isSuccess()){
            new SystemException(MessageFormat.format("系统RPC调用失败,错误信息:{0}",responseDTO.getMessage()));
        }
        return JsonUtil.fromJson(responseDTO.getData(ResponseDTO.DATA),c);
    }

}

package com.note.fictionweb.interceptor;


import com.note.fiction.entity.AccessLogEntity;
import com.note.fiction.service.AccessLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lvxz5
 * @version 1.0
 * @date 2017/7/6
 * @since 1.0
 */
public class AccessLogInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private AccessLogService accessLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            AccessLogEntity accessLogEntity = new AccessLogEntity();
            accessLogEntity.setAccessUrl(request.getRequestURI());
            accessLogEntity.setAccessIp(request.getRemoteAddr());
            accessLogEntity.setAccessTime(new Date());
            accessLogEntity.setUserCode("");
            accessLogService.insert(accessLogEntity);
        }catch (Exception e){
            logger.error("记录access log 失败,error{}",e);
        }
        return true;
    }



}

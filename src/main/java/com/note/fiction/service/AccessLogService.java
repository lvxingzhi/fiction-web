package com.note.fiction.service;

import com.note.fiction.dao.AccessLogDao;
import com.note.fiction.entity.AccessLogEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
@Service("fiction.service.accessLogService")
public class AccessLogService {

    @Resource(name = "fiction.service.accessLogDao")
    private AccessLogDao accessLogDao;

    public int insert(AccessLogEntity accessLogEntity){
       return accessLogDao.insert(accessLogEntity);
    }

}

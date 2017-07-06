package com.note.base.dao;

import javax.annotation.Resource;

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
 * @date 2017/3/13
 * @since 1.0
 */
public abstract class BaseDao {

    @Resource(name ="sessionContext")
    private SessionContext sessionContext;

    public SessionContext getSessionContext() {
        return sessionContext;
    }

}

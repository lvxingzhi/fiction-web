package com.note.fiction.dao;

import com.note.base.dao.BaseDao;
import com.note.base.dao.SessionContext;
import com.note.fiction.entity.AccessLogEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("fiction.service.accessLogDao")
public class AccessLogDao extends BaseDao {

    @Resource(name ="sessionContext")
    private SessionContext sessionContext;

    public int insert(AccessLogEntity record){
        return getSessionContext().insert(getClass().getName()+".insert",record);
    }

    @Override
    public SessionContext getSessionContext() {
        return sessionContext;
    }
}
package com.note.fiction.dao;

import com.note.base.dao.BaseDao;
import com.note.base.dao.SessionContext;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("fiction.service.systemBaseConstDao")
public class SystemBaseConstDao  extends BaseDao {

    @Resource(name ="sessionContext")
    private SessionContext sessionContext;

    @Override
    public SessionContext getSessionContext() {
        return sessionContext;
    }

}
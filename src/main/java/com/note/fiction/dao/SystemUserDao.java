package com.note.fiction.dao;

import com.note.base.dao.BaseDao;
import com.note.base.dao.SessionContext;
import com.note.fiction.entity.SystemUserEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

@Repository("fiction.service.systemUserDao")
public class SystemUserDao  extends BaseDao {

    @Resource(name ="sessionContext")
    private SessionContext sessionContext;

    @Override
    public SessionContext getSessionContext() {
        return sessionContext;
    }

    public int add(SystemUserEntity systemUserEntity){
        return sessionContext.insert(this.getClass().getName()+".insert",systemUserEntity);
    }

    public int update(SystemUserEntity systemUserEntity){
        return sessionContext.update(this.getClass().getName()+".update",systemUserEntity);
    }

    public int updateExt(SystemUserEntity systemUserEntity){
        return sessionContext.update(this.getClass().getName()+".updateExt",systemUserEntity);
    }

    public SystemUserEntity selectOneByCondition(Map map){
        return sessionContext.selectOne(this.getClass().getName()+".selectByCondition",map);
    }


}
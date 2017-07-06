package com.note.fiction.dao;

import com.note.base.dao.BaseDao;
import com.note.base.dao.SessionContext;
import com.note.fiction.entity.FictionExtentionEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("fiction.service.fictionExtentionDao")
public class FictionExtentionDao extends BaseDao {

    @Resource(name ="sessionContext")
    private SessionContext sessionContext;

    @Override
    public SessionContext getSessionContext() {
        return sessionContext;
    }

    public int add(FictionExtentionEntity fictionExtentionEntity){
        return sessionContext.insert(this.getClass().getName()+".insert",fictionExtentionEntity);
    }

    public int updateStatistics(FictionExtentionEntity fictionExtentionEntity){
        return sessionContext.update(this.getClass().getName()+".updateStatistics",fictionExtentionEntity);
    }

    public FictionExtentionEntity findByFictionCode(String fictionCode){
        return sessionContext.selectOne(this.getClass().getName()+".selectByFictionCode",fictionCode);
    }

}
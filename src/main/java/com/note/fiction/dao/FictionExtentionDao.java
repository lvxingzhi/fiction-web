package com.note.fiction.dao;

import com.note.base.dao.BaseDao;
import com.note.fiction.entity.FictionExtentionEntity;
import org.springframework.stereotype.Repository;

@Repository("fiction.service.fictionExtentionDao")
public class FictionExtentionDao extends BaseDao {

    public int add(FictionExtentionEntity fictionExtentionEntity){
        return getSessionContext().insert(this.getClass().getName()+".insert",fictionExtentionEntity);
    }

    public int updateStatistics(FictionExtentionEntity fictionExtentionEntity){
        return getSessionContext().update(this.getClass().getName()+".updateStatistics",fictionExtentionEntity);
    }

    public FictionExtentionEntity findByFictionCode(String fictionCode){
        return getSessionContext().selectOne(this.getClass().getName()+".selectByFictionCode",fictionCode);
    }

    public int deleteByFictionCode(String fictionCode){
        return getSessionContext().delete(this.getClass().getName()+".deleteByFictionCode",fictionCode);
    }

}
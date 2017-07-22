package com.note.fiction.dao;

import com.note.base.dao.BaseDao;
import com.note.fiction.entity.FictionChapterExtentionEntity;
import org.springframework.stereotype.Repository;

@Repository("fiction.service.fictionChapterExtentionDao")
public class FictionChapterExtentionDao extends BaseDao {

    public int add(FictionChapterExtentionEntity fictionChapterExtentionEntity){
        return getSessionContext().insert(this.getClass().getName()+".insert",fictionChapterExtentionEntity);
    }

    public int updatePreAndNext(FictionChapterExtentionEntity fictionChapterExtentionEntity){
        return getSessionContext().update(this.getClass().getName()+".updatePreAndNext",fictionChapterExtentionEntity);
    }

    public int deleteByFictionCode(String fictionCode){
        return getSessionContext().delete(this.getClass().getName()+".deleteByFictionCode",fictionCode);
    }

}
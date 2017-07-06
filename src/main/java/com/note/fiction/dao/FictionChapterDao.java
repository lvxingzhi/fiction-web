package com.note.fiction.dao;

import com.note.base.dao.BaseDao;
import com.note.base.dao.SessionContext;
import com.note.base.dto.PageDto;
import com.note.fiction.dto.response.FictionChapterInfoResp;
import com.note.fiction.dto.response.FictionChapterResp;
import com.note.fiction.entity.FictionChapterEntity;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("fiction.service.fictionChapterDao")
public class FictionChapterDao extends BaseDao {

    @Resource(name ="sessionContext")
    private SessionContext sessionContext;

    @Override
    public SessionContext getSessionContext() {
        return sessionContext;
    }

    public int add(FictionChapterEntity fictionChapterEntity){
        return sessionContext.insert(this.getClass().getName()+".insert",fictionChapterEntity);
    }

    public List<FictionChapterResp> selectByCondition(Map map, RowBounds rowBounds){
        List<FictionChapterResp> list = sessionContext.selectList(this.getClass().getName()+".selectByCondition",map,rowBounds);
        return list;
    }

    public FictionChapterInfoResp findOneByLogicCode(Map map){
        FictionChapterInfoResp result = sessionContext.selectOne(this.getClass().getName()+".findByLogicCode",map);
        return result;
    }

    public List<FictionChapterEntity> findByCondition(FictionChapterEntity fictionChapterEntity){
        PageDto pageDto = new PageDto();
        RowBounds rowBounds = new RowBounds(pageDto.getOffset(),pageDto.getLimit());
        return sessionContext.selectList(this.getClass().getName()+".findByCondition",fictionChapterEntity,rowBounds);
    }

}
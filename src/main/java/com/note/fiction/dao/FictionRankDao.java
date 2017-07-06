package com.note.fiction.dao;

import com.note.base.dao.BaseDao;
import com.note.base.dao.SessionContext;
import com.note.fiction.dto.response.FictionRankSearchResp;
import com.note.fiction.entity.FictionRankEntity;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("fiction.service.fictionRankDao")
public class FictionRankDao  extends BaseDao {

    @Resource(name ="sessionContext")
    private SessionContext sessionContext;

    @Override
    public SessionContext getSessionContext() {
        return sessionContext;
    }

    public List<FictionRankSearchResp> selectByCondition(Map map, RowBounds rowBounds){
        List<FictionRankSearchResp> list = sessionContext.selectList(this.getClass().getName()+".selectByCondition",map,rowBounds);
        return list;
    }

    public int add(FictionRankEntity fictionRankEntity){
        return sessionContext.insert(this.getClass().getName()+".insert",fictionRankEntity);
    }

}
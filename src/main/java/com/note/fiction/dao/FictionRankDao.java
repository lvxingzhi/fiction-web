package com.note.fiction.dao;

import com.note.base.dao.BaseDao;
import com.note.fiction.dto.response.FictionRankSearchResp;
import com.note.fiction.entity.FictionRankEntity;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("fiction.service.fictionRankDao")
public class FictionRankDao  extends BaseDao {


    public List<FictionRankSearchResp> selectByCondition(Map map, RowBounds rowBounds){
        List<FictionRankSearchResp> list = getSessionContext().selectList(this.getClass().getName()+".selectByCondition",map,rowBounds);
        return list;
    }

    public int add(FictionRankEntity fictionRankEntity){
        return getSessionContext().insert(this.getClass().getName()+".insert",fictionRankEntity);
    }

}
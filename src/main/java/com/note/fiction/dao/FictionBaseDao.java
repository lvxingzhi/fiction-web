package com.note.fiction.dao;

import com.note.base.dao.BaseDao;
import com.note.base.dao.SessionContext;
import com.note.fiction.dto.response.FictionFindOneResp;
import com.note.fiction.dto.response.FictionSearchResp;
import com.note.fiction.entity.FictionBaseEntity;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/12.
 */
@Repository("fiction.service.fictionBaseDao")
public class FictionBaseDao extends BaseDao {

    @Resource(name ="sessionContext")
    private SessionContext sessionContext;

    @Override
    public SessionContext getSessionContext() {
        return sessionContext;
    }

    public List<FictionBaseEntity> selectByCondition(Map map, RowBounds rowBounds){
        List<FictionBaseEntity> list = sessionContext.selectList(this.getClass().getName()+".selectByCondition",map,rowBounds);
        return list;
    }

    public List<FictionSearchResp> selectFullByCondition(Map map, RowBounds rowBounds){
        List<FictionSearchResp> list = sessionContext.selectList(this.getClass().getName()+".selectFullByCondition",map,rowBounds);
        return list;
    }

    public int selectFullCountByCondition(Map map){
        int count = sessionContext.selectOne(this.getClass().getName()+".selectFullCountByCondition",map);
        return count;
    }

    public FictionFindOneResp findOneByCondition(Map map){
        FictionFindOneResp result = sessionContext.selectOne(this.getClass().getName()+".selectOneByCondition",map);
        return result;
    }

    public int add(FictionBaseEntity entity){
        return sessionContext.insert(this.getClass().getName()+".insert",entity);
    }

}

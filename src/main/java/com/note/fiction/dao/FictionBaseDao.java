package com.note.fiction.dao;

import com.note.base.dao.BaseDao;
import com.note.fiction.dto.response.FictionFindOneResp;
import com.note.fiction.dto.response.FictionSearchResp;
import com.note.fiction.entity.FictionBaseEntity;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/12.
 */
@Repository("fiction.service.fictionBaseDao")
public class FictionBaseDao extends BaseDao {

    public List<FictionBaseEntity> selectByCondition(Map map, RowBounds rowBounds){
        List<FictionBaseEntity> list = getSessionContext().selectList(this.getClass().getName()+".selectByCondition",map,rowBounds);
        return list;
    }

    public List<FictionSearchResp> selectFullByCondition(Map map, RowBounds rowBounds){
        List<FictionSearchResp> list = getSessionContext().selectList(this.getClass().getName()+".selectFullByCondition",map,rowBounds);
        return list;
    }

    public int selectFullCountByCondition(Map map){
        int count = getSessionContext().selectOne(this.getClass().getName()+".selectFullCountByCondition",map);
        return count;
    }

    public FictionFindOneResp findOneByCondition(Map map){
        FictionFindOneResp result = getSessionContext().selectOne(this.getClass().getName()+".selectOneByCondition",map);
        return result;
    }

    public int add(FictionBaseEntity entity){
        return getSessionContext().insert(this.getClass().getName()+".insert",entity);
    }

}

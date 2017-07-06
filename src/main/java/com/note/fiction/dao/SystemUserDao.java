package com.note.fiction.dao;

import com.note.base.dao.BaseDao;
import com.note.fiction.entity.SystemUserEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("fiction.service.systemUserDao")
public class SystemUserDao  extends BaseDao {

    public int add(SystemUserEntity systemUserEntity){
        return getSessionContext().insert(this.getClass().getName()+".insert",systemUserEntity);
    }

    public int update(SystemUserEntity systemUserEntity){
        return getSessionContext().update(this.getClass().getName()+".update",systemUserEntity);
    }

    public int updateExt(SystemUserEntity systemUserEntity){
        return getSessionContext().update(this.getClass().getName()+".updateExt",systemUserEntity);
    }

    public SystemUserEntity selectOneByCondition(Map map){
        return getSessionContext().selectOne(this.getClass().getName()+".selectByCondition",map);
    }


}
package com.note.fiction.service;

import com.note.base.enums.DeleteEnum;
import com.note.base.enums.UserLevelEnum;
import com.note.base.enums.UserTypeEnum;
import com.note.base.utils.UUIDGenerator;
import com.note.fiction.dao.SystemUserDao;
import com.note.fiction.dto.request.SystemUserLoginReq;
import com.note.fiction.dto.request.SystemUserReq;
import com.note.fiction.entity.SystemUserEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

@Repository("fiction.service.systemUserService")
public class SystemUserService  {

    @Resource(name ="fiction.service.systemUserDao")
    private SystemUserDao systemUserDao;

    public int add(SystemUserReq systemUserReq) {
        SystemUserEntity systemUserEntity = new SystemUserEntity();
        systemUserEntity.setLogicCode(UUIDGenerator.uuid());
        systemUserEntity.setLoginName(systemUserReq.getLoginName());
        systemUserEntity.setLoginPassword(systemUserReq.getPassword());
        systemUserEntity.setEmail(systemUserReq.getEmail());
        systemUserEntity.setLevel(UserLevelEnum.NORMAL.getType());
        systemUserEntity.setType(UserTypeEnum.NORMAL.getType());
        systemUserEntity.setScore(0);
        systemUserEntity.setName(systemUserReq.getName());
        systemUserEntity.setCreateTime(new Date());
        systemUserEntity.setModifyTime(systemUserEntity.getCreateTime());
        systemUserEntity.setCreateUserCode("admin");
        systemUserEntity.setModifyUserCode("admin");
        systemUserEntity.setIsDelete(DeleteEnum.NOT_DELETE.getType());
        return systemUserDao.add(systemUserEntity);
    }

    public int update(SystemUserEntity systemUserEntity) {
        return systemUserDao.update(systemUserEntity);
    }

    public int updateExt(SystemUserEntity systemUserEntity) {
        return systemUserDao.updateExt(systemUserEntity);
    }

    public SystemUserEntity find(SystemUserLoginReq systemUserLoginReq) {
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("searchContent",systemUserLoginReq);
        return systemUserDao.selectOneByCondition(map);
    }

}
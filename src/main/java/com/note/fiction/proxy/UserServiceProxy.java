package com.note.fiction.proxy;

import com.note.base.dto.ResponseDTO;
import com.note.base.utils.JsonUtil;
import com.note.base.utils.ObjectUtil;
import com.note.fiction.dto.request.SystemUserLoginReq;
import com.note.fiction.dto.request.SystemUserReq;
import com.note.fiction.dto.request.SystemUserUpdateExtReq;
import com.note.fiction.dto.request.SystemUserUpdateReq;
import com.note.fiction.entity.SystemUserEntity;
import com.note.fiction.service.SystemUserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/3/18.
 */
@Component("fiction.service.userServiceProxy")
public class UserServiceProxy {

    @Resource(name = "fiction.service.systemUserService")
    private SystemUserService systemUserService;

    public String add(String json) throws SQLException, IOException {
        SystemUserReq systemUserReq = JsonUtil.fromJson(json, SystemUserReq.class);
        systemUserService.add(systemUserReq);
        return "0";
    }

    public String find(String json) throws SQLException, IOException {
        SystemUserLoginReq systemUserLoginReq = JsonUtil.fromJson(json, SystemUserLoginReq.class);
        SystemUserEntity systemUserEntity = systemUserService.find(systemUserLoginReq);
        if(ObjectUtil.isNull(systemUserEntity)){
            return null;
        }
        return JsonUtil.toJson(systemUserEntity);
    }

    public String updateBaseInfo(String json) throws SQLException, IOException {
        SystemUserUpdateReq systemUserUpdateReq = JsonUtil.fromJson(json, SystemUserUpdateReq.class);
        SystemUserLoginReq systemUserLoginReq = new SystemUserLoginReq();
        systemUserLoginReq.setUserName(systemUserUpdateReq.getLoginName());
        systemUserLoginReq.setPassword(systemUserUpdateReq.getOldPassword());
        SystemUserEntity systemUserEntity = systemUserService.find(systemUserLoginReq);
        if(ObjectUtil.isNull(systemUserEntity)){
            return ResponseDTO.getErrorInstance("原账号或密码错误").toString();
        }
        systemUserEntity.setEmail(systemUserUpdateReq.getEmail());
        systemUserEntity.setName(systemUserUpdateReq.getName());
        systemUserEntity.setLoginPassword(systemUserUpdateReq.getNewPassword());
        systemUserService.update(systemUserEntity);
        return ResponseDTO.getSuccessInstance().toString();
    }

    public String updateExtensionInfo(String json){
        SystemUserUpdateExtReq systemUserUpdateExtReq = JsonUtil.fromJson(json, SystemUserUpdateExtReq.class);
        SystemUserLoginReq systemUserLoginReq = new SystemUserLoginReq();
        systemUserLoginReq.setUserName(systemUserUpdateExtReq.getLoginName());
        SystemUserEntity systemUserEntity = systemUserService.find(systemUserLoginReq);
        if(ObjectUtil.isNull(systemUserEntity)){
            return ResponseDTO.getErrorInstance("账号不存在").toString();
        }
        // TODO 记录表(积分变更,等级变更,信息变更,登录记录)
        systemUserEntity.setLevel(systemUserEntity.getLevel()+systemUserUpdateExtReq.getChangeLevel());
        systemUserEntity.setScore(systemUserEntity.getScore()+systemUserUpdateExtReq.getChangeScore());
        systemUserService.updateExt(systemUserEntity);
        return ResponseDTO.getSuccessInstance().toString();
    }


}

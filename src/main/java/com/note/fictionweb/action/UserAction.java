package com.note.fictionweb.action;

import com.note.base.utils.JsonUtil;
import com.note.base.utils.ObjectUtil;
import com.note.entity.fiction.entity.SystemUserEntity;
import com.note.provider.fiction.api.UserApiService;
import com.note.provider.fiction.dto.request.SystemUserLoginReq;
import com.note.provider.fiction.dto.request.SystemUserReq;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 用户操作
 */
@Controller
@RequestMapping("user")
public class UserAction {

    @Resource(name="userApiService")
    private UserApiService userApiService;

    /**
     * 注册
     * @param model
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping("/regist")
    @ResponseBody
    public String regist(String userName,String password,String email,String name,Model model) throws IOException, SQLException {
        SystemUserReq systemUserReq = new SystemUserReq();
        systemUserReq.setName(name);
        systemUserReq.setEmail(email);
        systemUserReq.setUserName(userName);
        systemUserReq.setPassword(password);
        String result = userApiService.add(JsonUtil.toJson(systemUserReq));
        if("1".equals(result)){
            return "1";
        }
        return "0";
    }

    /**
     * 登录
     * @param model
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(String loginUserName,String loginPassword,Model model) throws IOException, SQLException {
        SystemUserLoginReq systemUserLoginReq = new SystemUserLoginReq();
        systemUserLoginReq.setUserName(loginUserName);
        systemUserLoginReq.setPassword(loginPassword);
        String result =  userApiService.find(JsonUtil.toJson(systemUserLoginReq));
        if(ObjectUtil.isNull(result)){
            return "1";
        }
        SystemUserEntity systemUserEntity = JsonUtil.fromJson(result,SystemUserEntity.class);
        return "0";
    }

}

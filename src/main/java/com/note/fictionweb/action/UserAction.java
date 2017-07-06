package com.note.fictionweb.action;

import com.note.base.utils.JsonUtil;
import com.note.base.utils.ObjectUtil;
import com.note.fiction.dto.request.SystemUserLoginReq;
import com.note.fiction.dto.request.SystemUserReq;
import com.note.fiction.dto.request.SystemUserUpdateExtReq;
import com.note.fiction.entity.SystemUserEntity;
import com.note.fiction.proxy.UserServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import static com.note.base.utils.JsonUtil.gson;

/**
 * 用户操作
 */
@Controller
@RequestMapping("user")
public class UserAction {

    @Resource(name="fiction.service.userServiceProxy")
    private UserServiceProxy userServiceProxy;

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
        HashMap<String,Object> resultMap = new HashMap<>();

        SystemUserReq systemUserReq = new SystemUserReq();
        systemUserReq.setName(name);
        systemUserReq.setEmail(email);
        systemUserReq.setLoginName(userName);
        systemUserReq.setPassword(password);
        String result = userServiceProxy.add(JsonUtil.toJson(systemUserReq));
        if("0".equals(result)){
            resultMap.put("status",0);
            return gson.toJson(resultMap);
        }
        resultMap.put("status",1);
        return gson.toJson(resultMap);
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
    public String login(String loginUserName,String loginPassword,Model model,HttpSession session) throws IOException, SQLException {
        HashMap<String,Object> resultMap = new HashMap<>();

        SystemUserLoginReq systemUserLoginReq = new SystemUserLoginReq();
        systemUserLoginReq.setUserName(loginUserName);
        systemUserLoginReq.setPassword(loginPassword);
        String result =  userServiceProxy.find(JsonUtil.toJson(systemUserLoginReq));
        SystemUserEntity systemUserEntity = JsonUtil.fromJson(result,SystemUserEntity.class);
        if(!ObjectUtil.isNull(systemUserEntity)){
            // 首次增加积分
            SystemUserUpdateExtReq systemUserUpdateExtReq = new SystemUserUpdateExtReq();
            systemUserUpdateExtReq.setLoginName(loginUserName);
            systemUserUpdateExtReq.setChangeLevel(0);
            systemUserUpdateExtReq.setChangeScore(2);
            userServiceProxy.updateExtensionInfo(JsonUtil.toJson(systemUserUpdateExtReq));
            session.setAttribute("user",systemUserEntity);
            resultMap.put("status",0);
            return gson.toJson(resultMap);
        }
        resultMap.put("status",1);
        return gson.toJson(resultMap);
    }

    /**
     * 登出
     * @param model
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(Model model,HttpSession session) throws IOException, SQLException {
        HashMap<String,Object> resultMap = new HashMap<>();
        session.removeAttribute("user");
        resultMap.put("status",0);
        return gson.toJson(resultMap);
    }

}

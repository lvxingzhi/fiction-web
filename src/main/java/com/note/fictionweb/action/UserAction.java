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
        HashMap<String,Object> resultMap = new HashMap<>();

        SystemUserReq systemUserReq = new SystemUserReq();
        systemUserReq.setName(name);
        systemUserReq.setEmail(email);
        systemUserReq.setUserName(userName);
        systemUserReq.setPassword(password);
        String result = userApiService.add(JsonUtil.toJson(systemUserReq));
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
        String result =  userApiService.find(JsonUtil.toJson(systemUserLoginReq));
        SystemUserEntity systemUserEntity = JsonUtil.fromJson(result,SystemUserEntity.class);
        if(!ObjectUtil.isNull(systemUserEntity)){
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

package com.note.fictionweb.action;

import com.note.base.utils.JsonUtil;
import com.note.fictionweb.request.FictionAddRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 后台管理
 */
@Controller
@RequestMapping("adminManage")
public class AdminManage {

    /**
     * 创建小说页
     * @param model
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping("/createFictionPage")
    public String createFictionPage(Model model) throws IOException, SQLException {


        return "/admin/createFiction";
    }


    /**
     * 创建小说
     * @param model
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping(value="/createFiction", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String createFiction(FictionAddRequest fictionAddRequest,Model model) throws IOException, SQLException {
        System.out.println(JsonUtil.toJson(fictionAddRequest));
        return "3";
    }

}

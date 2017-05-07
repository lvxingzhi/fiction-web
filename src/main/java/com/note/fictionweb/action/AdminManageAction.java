package com.note.fictionweb.action;

import com.note.base.utils.JsonUtil;
import com.note.fictionweb.request.FictionAddRequest;
import com.note.fictionweb.request.FictionChapterAddRequest;
import com.note.provider.fiction.api.AdminApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 后台管理
 */
@Controller
@RequestMapping("adminManage")
public class AdminManageAction {

    @Resource(name = "adminApiService")
    private AdminApiService adminApiService;

    /**
     * 跳转创建小说页
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
        String result = adminApiService.createFiction(JsonUtil.toJson(fictionAddRequest));
        return result;
    }

    /**
     * 创建章节页
     * @param model
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping("/createFictionChapterPage")
    public String createFictionChapterPage(Model model) throws IOException, SQLException {
        return "/admin/createFictionChapter";
    }

    /**
     * 创建章节
     * @param model
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping(value="/createFictionChapter", produces = "application/json;charset=UTF-8")
    @ResponseBody
   public String createFictionChapter(FictionChapterAddRequest fictionChapterAddRequest, Model model) throws IOException, SQLException {
        String result = adminApiService.createFictionChapter(JsonUtil.toJson(fictionChapterAddRequest));
        return result;
    }

}

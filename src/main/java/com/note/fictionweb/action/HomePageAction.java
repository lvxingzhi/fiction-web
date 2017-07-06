package com.note.fictionweb.action;

import com.google.common.reflect.TypeToken;
import com.note.base.dto.PageDto;
import com.note.base.utils.JsonUtil;
import com.note.base.utils.ObjectUtil;
import com.note.fiction.dto.request.FictionChapterInfoReq;
import com.note.fiction.dto.request.FictionChapterReq;
import com.note.fiction.dto.request.FictionFindOneReq;
import com.note.fiction.dto.response.*;
import com.note.fiction.proxy.FictionServiceProxy;
import com.note.fictionweb.logic.FictionLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


/**
 * 主页
 */
@Controller
@RequestMapping("homepage")
public class HomePageAction {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "fiction.service.fictionServiceProxy")
    private FictionServiceProxy fictionServiceProxy;

    @Resource(name = "web.logic.fictionLogic")
    private FictionLogic fictionLogic;

    /**
     * 主页
     *
     * @param model
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping("/home")
    public String index(Model model, String type) throws IOException, SQLException {
        logger.info("进入主页");
        // 时间排序列表
        List<FictionSearchResp> timeFullList = fictionLogic.findTimeFullList(type);
        // 分数排序
        List<FictionSearchResp> scoreFullList = fictionLogic.findScoreFullList(type);
        // 浏览B
        List<FictionRankSearchResp> viewsList = fictionLogic.findRankViewList();
        // 分数B
        List<FictionRankSearchResp> scoreList = fictionLogic.findRankScoreList();
        model.addAttribute("timeFullList", timeFullList);
        model.addAttribute("scoreFullList", scoreFullList);
        model.addAttribute("viewsList", viewsList);
        model.addAttribute("scoreList", scoreList);
        return "home";
    }

    /**
     * ajax搜索
     *
     * @param searchContent
     * @param model
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping(value = "/ajaxSearch", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String ajaxSearch(String searchContent,String type, Integer size, int page, Model model) throws IOException, SQLException {
        HashMap<String, Object> resultMap = fictionLogic.findListByCondition(type,searchContent,page,size);
        int count = new Integer(resultMap.get("count") + "");
        resultMap.put("maxPage", (count / (ObjectUtil.isNull(size)?PageDto.DEFAULT_SIZE:size)) + 1);
        return JsonUtil.toJson(resultMap);
    }

    /**
     * 搜索页
     *
     * @param model
     * @param headContent
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping("/search")
    public String search(Model model, String headContent) throws IOException, SQLException {
        // 浏览B
        List<FictionRankSearchResp> viewsList = fictionLogic.findRankViewList();
        // 分数B
        List<FictionRankSearchResp> scoreList = fictionLogic.findRankScoreList();
        model.addAttribute("viewsList", viewsList);
        model.addAttribute("scoreList", scoreList);
        model.addAttribute("headContent", ObjectUtil.isNull(headContent) ? "" : headContent);
        model.addAttribute("page", 1);
        return "search";
    }

    /**
     * 小说详情页
     *
     * @param fictionCode
     * @param model
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping("/infoPage")
    public String infoPage(String fictionCode, Model model) throws IOException, SQLException {
        FictionFindOneReq fictionFindOneReq = new FictionFindOneReq();
        fictionFindOneReq.setFictionCode(fictionCode);
        String infoJson = fictionServiceProxy.findFictionInfo(JsonUtil.toJson(fictionFindOneReq));
        FictionFindOneResp fictionFindOneResp = JsonUtil.fromJson(infoJson, new TypeToken<FictionFindOneResp>() {
        }.getType());
        FictionChapterReq fictionChapterReq = new FictionChapterReq();
        fictionChapterReq.setFictionCode(fictionCode);
        fictionChapterReq.setSize(PageDto.MAX);
        String chapterListJson = fictionServiceProxy.findFictionChapters(JsonUtil.toJson(fictionChapterReq));
        List<FictionChapterResp> chapterList = JsonUtil.fromJson(chapterListJson, new TypeToken<List<FictionChapterResp>>() {
        }.getType());
        model.addAttribute("fictionInfo", fictionFindOneResp);
        model.addAttribute("chapterList", chapterList);
        return "infoPage";
    }

    /**
     * 章节详情页
     *
     * @param chapterCode
     * @param model
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping("/contentPage")
    public String contentPage(String chapterCode, Model model) throws IOException, SQLException {
        FictionChapterInfoReq fictionChapterInfoReq = new FictionChapterInfoReq();
        fictionChapterInfoReq.setChapterCode(chapterCode);
        String chapterInfo = fictionServiceProxy.findChapterInfo(JsonUtil.toJson(fictionChapterInfoReq));
        FictionChapterInfoResp fictionChapterInfoResp = JsonUtil.fromJson(chapterInfo, FictionChapterInfoResp.class);
        fictionChapterInfoResp.setChapterContent("<p>" + fictionChapterInfoResp.getChapterContent().replaceAll("\r\n\r\n", "</p><p>").replaceAll("\r\n", "</p><p>").replaceAll("\n", "</p><p>").replaceAll("\r", "</p><p>").replaceAll(" ", "&nbsp;") + "</p>");
        model.addAttribute("chapterInfo", fictionChapterInfoResp);

        FictionFindOneReq fictionFindOneReq = new FictionFindOneReq();
        fictionFindOneReq.setFictionCode(fictionChapterInfoResp.getFictionCode());
        String infoJson = fictionServiceProxy.findFictionInfo(JsonUtil.toJson(fictionFindOneReq));
        FictionFindOneResp fictionFindOneResp = JsonUtil.fromJson(infoJson, new TypeToken<FictionFindOneResp>() {
        }.getType());
        model.addAttribute("fictionInfo", fictionFindOneResp);
        return "contentPage";
    }


}

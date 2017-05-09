package com.note.fictionweb.action;

import com.google.common.reflect.TypeToken;
import com.note.base.dto.PageDto;
import com.note.base.enums.FictionRankTypeEnum;
import com.note.base.utils.JsonUtil;
import com.note.base.utils.ObjectUtil;
import com.note.provider.fiction.api.FictionApiService;
import com.note.provider.fiction.dto.request.*;
import com.note.provider.fiction.dto.response.*;
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

    @Resource(name="fictionApiService")
    private FictionApiService fictionApiService;

    /**
     * 主页
     * @param model
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping("/home")
    public String index(Model model) throws IOException, SQLException {
        FictionSearchReq fictionSearchReq = new FictionSearchReq();
        fictionSearchReq.setOrderBy("create_time");
        fictionSearchReq.setOrderByType("desc");
        fictionSearchReq.setSize(12);
        String fullJson = fictionApiService.findFull(JsonUtil.toJson(fictionSearchReq));
        HashMap<String,Object> resultMap= JsonUtil.fromJson(fullJson,new TypeToken<HashMap<String,Object>>(){}.getType());
        List<FictionSearchResp> fullList = (List<FictionSearchResp>) resultMap.get("list");
        FictionRankSearchReq fictionRankSearchReq = new FictionRankSearchReq();
        fictionRankSearchReq.setRankType(FictionRankTypeEnum.VIEW.getType());
        fictionRankSearchReq.setSize(10);
        String viewsJson = fictionApiService.findRankList(JsonUtil.toJson(fictionRankSearchReq));
        List<FictionRankSearchResp> viewsList = JsonUtil.fromJson(viewsJson,new TypeToken<List<FictionRankSearchResp>>(){}.getType());
        FictionRankSearchReq fictionRankSearchReq2 = new FictionRankSearchReq();
        fictionRankSearchReq2.setRankType(FictionRankTypeEnum.SCORE.getType());
        fictionRankSearchReq2.setSize(10);
        String scoreJson = fictionApiService.findRankList(JsonUtil.toJson(fictionRankSearchReq2));
        List<FictionRankSearchResp> scoreList = JsonUtil.fromJson(scoreJson,new TypeToken<List<FictionRankSearchResp>>(){}.getType());
        model.addAttribute("fullList",fullList);
        model.addAttribute("viewsList",viewsList);
        model.addAttribute("scoreList",scoreList);
        return "home";
    }

    /**
     * ajax搜索
     * @param searchContent
     * @param model
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping(value="/ajaxSearch", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String ajaxSearch(String searchContent,Integer size,int page,Model model) throws IOException, SQLException {
        FictionSearchReq fictionSearchReq = new FictionSearchReq();
        fictionSearchReq.setTitle(searchContent);
        fictionSearchReq.setPage(page);
        fictionSearchReq.setSize(size);
        String json = fictionApiService.findFull(JsonUtil.toJson(fictionSearchReq));
        HashMap<String,Object> resultMap= JsonUtil.fromJson(json,new TypeToken<HashMap<String,Object>>(){}.getType());
        List<FictionSearchResp> list = (List<FictionSearchResp>) resultMap.get("list");
        int count = new Integer(resultMap.get("count")+"");
        resultMap.put("list",list);
        resultMap.put("count",count);
        resultMap.put("maxPage",(count/fictionSearchReq.getSize())+1);
        return JsonUtil.toJson(resultMap);
    }

    /**
     * 搜索页
     * @param model
     * @param headContent
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping("/search")
    public String search(Model model,String headContent) throws IOException, SQLException {

        FictionRankSearchReq fictionRankSearchReq = new FictionRankSearchReq();
        fictionRankSearchReq.setRankType(FictionRankTypeEnum.VIEW.getType());
        fictionRankSearchReq.setSize(10);
        String viewsJson = fictionApiService.findRankList(JsonUtil.toJson(fictionRankSearchReq));
        List<FictionRankSearchResp> viewsList = JsonUtil.fromJson(viewsJson,new TypeToken<List<FictionRankSearchResp>>(){}.getType());
        FictionRankSearchReq fictionRankSearchReq2 = new FictionRankSearchReq();
        fictionRankSearchReq2.setRankType(FictionRankTypeEnum.SCORE.getType());
        fictionRankSearchReq2.setSize(10);
        String scoreJson = fictionApiService.findRankList(JsonUtil.toJson(fictionRankSearchReq2));
        List<FictionRankSearchResp> scoreList = JsonUtil.fromJson(scoreJson,new TypeToken<List<FictionRankSearchResp>>(){}.getType());
        model.addAttribute("viewsList",viewsList);
        model.addAttribute("scoreList",scoreList);
        model.addAttribute("headContent", ObjectUtil.isNull(headContent)?"":headContent);
        model.addAttribute("page",1);
        return "search";
    }

    /**
     * 小说详情页
     * @param fictionCode
     * @param model
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping("/infoPage")
    public String infoPage(String fictionCode,Model model) throws IOException, SQLException {
        FictionFindOneReq fictionFindOneReq = new FictionFindOneReq();
        fictionFindOneReq.setFictionCode(fictionCode);
        String infoJson= fictionApiService.findFictionInfo(JsonUtil.toJson(fictionFindOneReq));
        FictionFindOneResp fictionFindOneResp = JsonUtil.fromJson(infoJson,new TypeToken<FictionFindOneResp>(){}.getType());
        FictionChapterReq fictionChapterReq = new FictionChapterReq();
        fictionChapterReq.setFictionCode(fictionCode);
        fictionChapterReq.setSize(PageDto.MAX);
        String chapterListJson= fictionApiService.findFictionChapters(JsonUtil.toJson(fictionChapterReq));
        List<FictionChapterResp> chapterList = JsonUtil.fromJson(chapterListJson,new TypeToken<List<FictionChapterResp>>(){}.getType());
        model.addAttribute("fictionInfo",fictionFindOneResp);
        model.addAttribute("chapterList",chapterList);
        return "infoPage";
    }

    /**
     * 章节详情页
     * @param chapterCode
     * @param model
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping("/contentPage")
    public String contentPage(String chapterCode,Model model) throws IOException, SQLException {
        FictionChapterInfoReq fictionChapterInfoReq = new FictionChapterInfoReq();
        fictionChapterInfoReq.setChapterCode(chapterCode);
        String chapterInfo = fictionApiService.findChapterInfo(JsonUtil.toJson(fictionChapterInfoReq));
        FictionChapterInfoResp fictionChapterInfoResp = JsonUtil.fromJson(chapterInfo, FictionChapterInfoResp.class);
        fictionChapterInfoResp.setChapterContentStr("<p>"+fictionChapterInfoResp.getChapterContentStr().replaceAll("\r\n\r\n","</p><p>").replaceAll(" ","&ensp;")+"</p>");
        model.addAttribute("chapterInfo",fictionChapterInfoResp);

        FictionFindOneReq fictionFindOneReq = new FictionFindOneReq();
        fictionFindOneReq.setFictionCode(fictionChapterInfoResp.getFictionCode());
        String infoJson= fictionApiService.findFictionInfo(JsonUtil.toJson(fictionFindOneReq));
        FictionFindOneResp fictionFindOneResp = JsonUtil.fromJson(infoJson,new TypeToken<FictionFindOneResp>(){}.getType());
        model.addAttribute("fictionInfo",fictionFindOneResp);
        return "contentPage";
    }

}

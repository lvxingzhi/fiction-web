package com.note.fictionweb.action;

import com.google.gson.reflect.TypeToken;
import com.note.base.enums.FictionRankTypeEnum;
import com.note.base.utils.ObjectUtil;
import com.note.provider.fiction.api.FictionApiService;
import com.note.provider.fiction.dto.request.FictionChapterInfoReq;
import com.note.provider.fiction.dto.request.FictionChapterReq;
import com.note.provider.fiction.dto.request.FictionFindOneReq;
import com.note.provider.fiction.dto.request.FictionRankSearchReq;
import com.note.provider.fiction.dto.request.FictionSearchReq;
import com.note.provider.fiction.dto.response.FictionChapterInfoResp;
import com.note.provider.fiction.dto.response.FictionChapterResp;
import com.note.provider.fiction.dto.response.FictionFindOneResp;
import com.note.provider.fiction.dto.response.FictionRankSearchResp;
import com.note.provider.fiction.dto.response.FictionSearchResp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import static com.note.base.utils.JsonUtil.gson;

/**
 * Created by Administrator on 2017/2/12.
 */
@Controller
@RequestMapping("homepage")
public class HomePageAction {

    @Resource(name="fictionApiService")
    private FictionApiService fictionApiService;

    @RequestMapping("/home")
    public String index(Model model) throws IOException, SQLException {
        FictionSearchReq fictionSearchReq = new FictionSearchReq();
        fictionSearchReq.setOrderBy("create_time");
        fictionSearchReq.setOrderByType("desc");
        String fullJson = fictionApiService.findFull(gson.toJson(fictionSearchReq));
        List<FictionSearchResp> fullList = gson.fromJson(fullJson,new TypeToken<List<FictionSearchResp>>(){}.getType());
        FictionRankSearchReq fictionRankSearchReq = new FictionRankSearchReq();
        fictionRankSearchReq.setRankType(FictionRankTypeEnum.VIEW.getType());
        String viewsJson = fictionApiService.findRankList(gson.toJson(fictionRankSearchReq));
        List<FictionRankSearchResp> viewsList = gson.fromJson(viewsJson,new TypeToken<List<FictionRankSearchResp>>(){}.getType());
        FictionRankSearchReq fictionRankSearchReq2 = new FictionRankSearchReq();
        fictionRankSearchReq2.setRankType(FictionRankTypeEnum.SCORE.getType());
        String scoreJson = fictionApiService.findRankList(gson.toJson(fictionRankSearchReq2));
        List<FictionRankSearchResp> scoreList = gson.fromJson(scoreJson,new TypeToken<List<FictionRankSearchResp>>(){}.getType());
        model.addAttribute("fullList",fullList);
        model.addAttribute("viewsList",viewsList);
        model.addAttribute("scoreList",scoreList);
        return "home";
    }

    @RequestMapping(value="/ajaxSearch", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String ajaxSearch(String searchContent,Model model) throws IOException, SQLException {
        FictionSearchReq fictionSearchReq = new FictionSearchReq();
        fictionSearchReq.setTitle(searchContent);
        String json = fictionApiService.findFull(gson.toJson(fictionSearchReq));
        List<FictionSearchResp> list = gson.fromJson(json,new TypeToken<List<FictionSearchResp>>(){}.getType());
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("list",list);
        return gson.toJson(resultMap);
    }

    @RequestMapping("/search")
    public String search(Model model,String headContent) throws IOException, SQLException {

        FictionRankSearchReq fictionRankSearchReq = new FictionRankSearchReq();
        fictionRankSearchReq.setRankType(FictionRankTypeEnum.VIEW.getType());
        String viewsJson = fictionApiService.findRankList(gson.toJson(fictionRankSearchReq));
        List<FictionRankSearchResp> viewsList = gson.fromJson(viewsJson,new TypeToken<List<FictionRankSearchResp>>(){}.getType());
        FictionRankSearchReq fictionRankSearchReq2 = new FictionRankSearchReq();
        fictionRankSearchReq2.setRankType(FictionRankTypeEnum.SCORE.getType());
        String scoreJson = fictionApiService.findRankList(gson.toJson(fictionRankSearchReq2));
        List<FictionRankSearchResp> scoreList = gson.fromJson(scoreJson,new TypeToken<List<FictionRankSearchResp>>(){}.getType());
        model.addAttribute("viewsList",viewsList);
        model.addAttribute("scoreList",scoreList);
        model.addAttribute("headContent", ObjectUtil.isNull(headContent)?"":headContent);
        return "search";
    }

    @RequestMapping("/infoPage")
    public String infoPage(String fictionCode,Model model) throws IOException, SQLException {
        FictionFindOneReq fictionFindOneReq = new FictionFindOneReq();
        fictionFindOneReq.setFictionCode(fictionCode);
        String infoJson= fictionApiService.findFictionInfo(gson.toJson(fictionFindOneReq));
        FictionFindOneResp fictionFindOneResp = gson.fromJson(infoJson,new TypeToken<FictionFindOneResp>(){}.getType());
        FictionChapterReq fictionChapterReq = new FictionChapterReq();
        fictionChapterReq.setFictionCode(fictionCode);
        String chapterListJson= fictionApiService.findFictionChapters(gson.toJson(fictionChapterReq));
        List<FictionChapterResp> chapterList = gson.fromJson(chapterListJson,new TypeToken<List<FictionChapterResp>>(){}.getType());
        model.addAttribute("fictionInfo",fictionFindOneResp);
        model.addAttribute("chapterList",chapterList);
        return "infoPage";
    }

    @RequestMapping("/contentPage")
    public String contentPage(String chapterCode,Model model) throws IOException, SQLException {
        chapterCode="uuuuuuuuuuu1";
        FictionChapterInfoReq fictionChapterInfoReq = new FictionChapterInfoReq();
        fictionChapterInfoReq.setChapterCode(chapterCode);
        String chapterInfo = fictionApiService.findChapterInfo(gson.toJson(fictionChapterInfoReq));
        FictionChapterInfoResp fictionChapterInfoResp = gson.fromJson(chapterInfo, FictionChapterInfoResp.class);
        fictionChapterInfoResp.setChapterContentStr("<p>"+fictionChapterInfoResp.getChapterContentStr().replaceAll("\r\n\r\n","</p><p>").replaceAll(" ","&ensp;")+"</p>");
        model.addAttribute("chapterInfo",fictionChapterInfoResp);
        return "contentPage";
    }



}

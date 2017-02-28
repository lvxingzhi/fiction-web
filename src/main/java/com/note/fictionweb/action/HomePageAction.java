package com.note.fictionweb.action;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.note.entity.fiction.entity.FictionBaseEntity;
import com.note.provider.fiction.api.FictionApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/2/12.
 */
@Controller
@RequestMapping("homepage")
public class HomePageAction {

    @Resource(name="fictionApiService")
    private FictionApiService fictionApiService;

    private Type type = new TypeToken<ArrayList<FictionBaseEntity>>(){}.getType();
    private Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    @RequestMapping("/home")
    public String home(Model model) throws IOException, SQLException {
        String json = fictionApiService.search("");
        List<FictionBaseEntity> list = gson.fromJson(json,type);
        model.addAttribute("list",list);

        String hotJson = fictionApiService.searchHotList("");
        List<FictionBaseEntity> hotList = gson.fromJson(hotJson,type);

        String viewsJson = fictionApiService.searchViewsList("");
        List<FictionBaseEntity> viewsList = gson.fromJson(viewsJson,type);

        String newJson = fictionApiService.searchNewList("");
        List<FictionBaseEntity> newList = gson.fromJson(newJson,type);

        model.addAttribute("list",list);
        model.addAttribute("hotList",hotList);
        model.addAttribute("viewsList",viewsList);
        model.addAttribute("newList",newList);


        return "home";
    }

    @RequestMapping(value="/ajaxSearch", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String ajaxSearch(String searchContent,Model model) throws IOException, SQLException {
        String json = fictionApiService.search(searchContent);
        List<FictionBaseEntity> list = gson.fromJson(json,type);
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("list",list);
        return gson.toJson(resultMap);
    }

    @RequestMapping("/search")
    public String search(Model model) throws IOException, SQLException {

        String viewsJson = fictionApiService.searchViewsList("");
        List<FictionBaseEntity> viewsList = gson.fromJson(viewsJson,type);

        String newJson = fictionApiService.searchNewList("");
        List<FictionBaseEntity> newList = gson.fromJson(newJson,type);

        model.addAttribute("viewsList",viewsList);
        model.addAttribute("newList",newList);
        return "search";
    }

    @RequestMapping("/infoPage")
    public String infoPage(Model model) throws IOException, SQLException {

        return "infoPage";
    }

    @RequestMapping("/contentPage")
    public String contentPage(Model model) throws IOException, SQLException {

        return "contentPage";
    }



}

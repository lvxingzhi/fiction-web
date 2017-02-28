package com.note.fictionweb.action;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.note.entity.fiction.entity.FictionBaseEntity;
import com.note.provider.fiction.api.FictionApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/12.
 */
@Controller
public class IndexAction {

    @Resource(name="fictionApiService")
    private FictionApiService fictionApiService;

    @RequestMapping("/")
    public String index(Model model) throws IOException, SQLException {
        String json = fictionApiService.search("");
        Type type = new TypeToken<ArrayList<FictionBaseEntity>>(){}.getType();
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
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
}

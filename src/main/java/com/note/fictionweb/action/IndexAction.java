package com.note.fictionweb.action;

import com.note.provider.fiction.api.FictionApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/2/12.
 */
@Controller
public class IndexAction {

    @Resource(name="fictionApiService")
    private FictionApiService fictionApiService;

    @RequestMapping("/")
    public String index(Model model) throws IOException, SQLException {
        return "redirect:/homepage/home";
    }
}

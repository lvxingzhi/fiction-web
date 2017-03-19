package com.note.fictionweb.action;

import com.note.provider.fiction.api.FictionApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 跳转
 */
@Controller
public class IndexAction {

    @Resource(name="fictionApiService")
    private FictionApiService fictionApiService;

    /**
     * 跳转到主页
     * @param model
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @RequestMapping("/")
    public String index(Model model) throws IOException, SQLException {
        return "redirect:/homepage/home";
    }
}

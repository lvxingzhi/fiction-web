package com.note.fictionweb.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.sql.SQLException;

/**
 * 跳转
 */
@Controller
public class IndexAction {

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

    @RequestMapping("/error400")
    public String error400(Model model) throws IOException, SQLException {
        return "/error/400";
    }

    @RequestMapping("/error404")
    public String error404(Model model) throws IOException, SQLException {
        return "/error/404";
    }

    @RequestMapping("/error500")
    public String error500(Model model) throws IOException, SQLException {
        return "/error/500";
    }

}

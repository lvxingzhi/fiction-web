package com.note.fictionweb;

import com.note.provider.fiction.api.Test1Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/2/8.
 */

@Controller
@RequestMapping("test")
public class TestAction {

    @Resource(name="test1ServiceProxy")
    private Test1Service test1Service;

    public void setTest1Service(Test1Service test1Service) {
        this.test1Service = test1Service;
    }

    @RequestMapping(value="t1",method = RequestMethod.GET)
    public void test(){
        System.out.println(test1Service.test());
    }
}

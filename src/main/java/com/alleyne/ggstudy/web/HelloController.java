package com.alleyne.ggstudy.web;

import com.alleyne.ggstudy.Exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/alleyne")
    public String index(ModelMap map){
        map.addAttribute("host", "http://blog.alleyne.com");
        return "index";
    }

    @RequestMapping("/testError-json")
    @ResponseBody
    public String testErrorJson() throws MyException{
        throw new MyException("发生我的错误");
    }

    @RequestMapping("/testError")
    public String testError() throws Exception{
        throw new MyException("发生错误");
    }
}

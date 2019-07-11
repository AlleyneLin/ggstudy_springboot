package com.alleyne.ggstudy.web;

import com.alleyne.ggstudy.domain.UserXML;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserXMLController {
    @PostMapping(value = "/user-xml",
        consumes = MediaType.APPLICATION_XML_VALUE,
        produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public UserXML create(@RequestBody UserXML user){
        user.setName("alleyne.com"+user.getName());
        user.setAge(user.getAge() + 100);
        return user;
    }
}

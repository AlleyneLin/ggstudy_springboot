package com.alleyne.ggstudy;

import com.alleyne.ggstudy.database.UserService;
import com.alleyne.ggstudy.database.UserServiceImpl;
import javafx.application.Application;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void setup(){
        userService.deleteAllUsers();
    }

    @Test
    public void test() throws Exception{
        userService.create("aa", 102);
        userService.create("as", 10);
        userService.create("ad", 150);
        userService.create("af", 128);

        Assert.assertEquals(5, userService.getAllUsers().intValue());

        userService.deleteByName("aa");
        userService.deleteByName("ad");
        Assert.assertEquals(3, userService.getAllUsers().intValue());

        userService.deleteAllUsers();
        Assert.assertEquals(0, userService.getAllUsers().intValue());
    }
}

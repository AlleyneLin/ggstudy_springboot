package com.alleyne.ggstudy.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate mJdbcTemplate;
    @Override
    public void create(String name, Integer age) {
        mJdbcTemplate.update("insert into USER(NAME, AGE) values (?,?)",name, age);
    }

    @Override
    public void deleteByName(String name) {
        mJdbcTemplate.update("delete from USER when name=?", name);
    }

    @Override
    public Integer getAllUsers() {

        return mJdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        mJdbcTemplate.update("delete from USER");
    }
}

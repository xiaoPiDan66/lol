package com.two.dao.impl;

import com.two.dao.UserDao;
import com.two.entity.User;
import com.two.util.BaseDao;

import java.sql.ResultSet;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User loginSelect(String userName, String password) {
        String sql = "select * from user where userName = ? and password = ?";
        Object[] objects = {userName, password};
        User user = null;
        try {
            ResultSet resultSet = super.select(sql, objects);
            if (resultSet.next()) {
                user = new User();
                user.setUserName(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("password"));
                user.setLevel(resultSet.getString("level"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int register(String userName, String password, String level) {
        String sql = "insert into user(userName, password, level) values (?, ?, ?)";
        Object[] objects = {userName, password, level};
        int i = super.setUpdate(sql, objects);
        return i;
    }
}

package com.two.service.impl;

import com.two.dao.impl.UserDaoImpl;
import com.two.entity.User;
import com.two.service.UserService;
import com.two.util.BaseDao;

public class UserServiceImpl extends BaseDao implements UserService {
    @Override
    public User loginSelect(String userName, String password) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.loginSelect(userName, password);
        return user;
    }

    @Override
    public int register(String userName, String password, String level) {
        UserDaoImpl userDao = new UserDaoImpl();
        int i = userDao.register(userName, password, level);
        return i;
    }
}

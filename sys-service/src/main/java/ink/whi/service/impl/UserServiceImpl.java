package ink.whi.service.impl;

import ink.whi.dao.UserDao;
import ink.whi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 * @author: qing
 * @Date: 2023/5/24
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsername(String username) {
        userDao.findByUsername(username);
    }
}

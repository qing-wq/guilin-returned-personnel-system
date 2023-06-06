package ink.whi.service.service.impl;

import ink.whi.api.model.dto.BaseUserInfoDTO;
import ink.whi.api.model.exception.BusinessException;
import ink.whi.api.model.exception.StatusEnum;
import ink.whi.service.dao.UserDao;
import ink.whi.service.entity.UserDO;
import ink.whi.service.service.UserService;
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
    public BaseUserInfoDTO passwordLogin(String username, String password) {
        UserDO user = userDao.queryUserByUserName(username);
        if (user == null) {
            throw BusinessException.newInstance(StatusEnum.USER_NOT_EXISTS, username);
        }
        if (!user.getPassword().equals(password)) {
            throw BusinessException.newInstance(StatusEnum.USER_PWD_ERROR);
        }
        return userDao.queryBasicUserInfo(user.getId());
    }
}

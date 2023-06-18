package ink.whi.service.service.impl;

import ink.whi.api.model.dto.BaseUserInfoDTO;
import ink.whi.api.model.exception.BusinessException;
import ink.whi.api.model.exception.StatusEnum;
import ink.whi.service.dao.UserDao;
import ink.whi.service.entity.UserDO;
import ink.whi.service.security.CustomUser;
import ink.whi.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ink.whi.service.service.help.UserPwdEncoder;

import java.util.Objects;

/**
 * @author: qing
 * @Date: 2023/5/24
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserPwdEncoder userPwdEncoder;

    /**
     * 账号密码登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public BaseUserInfoDTO passwordLogin(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        // authenticate方法会调用loadUserByUsername
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            throw BusinessException.newInstance(StatusEnum.USER_PWD_ERROR);
        }
        // 校验成功，强转对象
        CustomUser customUser = (CustomUser) authenticate.getPrincipal();
        UserDO user = customUser.getUserDO();
        return userDao.queryBasicUserInfo(user.getId());
    }

    @Override
    public UserDO queryByUserName(String username) {
        return userDao.getUserByUserName(username);
    }
}

package ink.whi.service.security;

import ink.whi.api.model.enums.RoleEnum;
import ink.whi.api.model.exception.BusinessException;
import ink.whi.api.model.exception.StatusEnum;
import ink.whi.service.dao.UserDao;
import ink.whi.service.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: qing
 * @Date: 2023/5/24
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO user = userDao.queryByUserName(username);
        if (user == null) {
            throw BusinessException.newInstance(StatusEnum.USER_NOT_EXISTS, username);
        }

        // 添加用户权限
        List<GrantedAuthority> authorities = Collections.emptyList();
        List<String> permission = userDao.getUserPermission(user.getId());
        authorities = permission.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        // 添加用户角色
        String role = RoleEnum.role(user.getUserRole()).name();
        authorities.add(new SimpleGrantedAuthority(role));
        return new CustomUser(user, authorities);
    }
}

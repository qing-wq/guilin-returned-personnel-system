package ink.whi.core.security;

import ink.whi.api.model.exception.BusinessException;
import ink.whi.api.model.exception.StatusEnum;
import ink.whi.service.entity.*;
import ink.whi.service.mapper.RoleResourceMapper;
import ink.whi.service.mapper.UserRoleMapper;
import ink.whi.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: qing
 * @Date: 2023/5/24
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleResourceMapper roleResourceMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO user = userService.queryByUserName(username);
        if (user == null) {
            throw BusinessException.newInstance(StatusEnum.USER_NOT_EXISTS, username);
        }

        List<SimpleGrantedAuthority> authorities;   // Security权限表达式，如user:add等
        // 获取用户角色
        List<UserRegionDO> roles = userRoleMapper.getRoles(user.getId());
        // 通过角色获取权限
        List<String> permissions = new ArrayList<>();
        List<Long> roleIds = roles.stream().map(UserRegionDO::getRoleId).toList();
        roleIds.forEach(r -> {
            roleResourceMapper.getResources(r).stream().map(ResourceDO::getPermission).forEach(permissions::add);
        });
        authorities = permissions.stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new CustomUser(user, authorities);
    }
}

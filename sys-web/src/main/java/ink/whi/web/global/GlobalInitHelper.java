package ink.whi.web.global;

import ink.whi.api.model.context.ReqInfoContext;
import ink.whi.api.model.dto.BaseUserInfoDTO;
import ink.whi.api.model.enums.RoleEnum;
import ink.whi.api.model.exception.BusinessException;
import ink.whi.api.model.exception.StatusEnum;
import ink.whi.core.utils.JwtUtil;
import ink.whi.service.dao.UserDao;
import ink.whi.service.entity.UserDO;
import ink.whi.service.security.CustomUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 初始化用户信息
 *
 * @author: qing
 * @Date: 2023/4/27
 */
@Slf4j
@Component
public class GlobalInitHelper {

    public static final String SESSION_KEY = "sys-token";

    @Autowired
    private UserDao userDao;

    /**
     * 初始化用户信息
     *
     * @param
     * @param reqInfo
     */
    public void initUserInfo(ReqInfoContext.ReqInfo reqInfo) {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
        if (request.getCookies() == null) {
            return;
        }
        for (Cookie cookie : request.getCookies()) {
            if (SESSION_KEY.equalsIgnoreCase(cookie.getName())) {
                BaseUserInfoDTO userInfo = VerifyToken(cookie.getValue(), response);
                // 将用户信息写入Security
                if (userInfo != null) {
                    // 添加用户权限
                    List<GrantedAuthority> authorities;
                    List<String> permission = userDao.getUserPermission(userInfo.getUserId());
                    authorities = permission.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
                    UserDO user = userDao.queryByUserId(userInfo.getUserId());
                    // 添加用户角色
                    String role = RoleEnum.role(user.getUserRole()).name();
                    authorities.add(new SimpleGrantedAuthority(role));
                    CustomUser principal = new CustomUser(user, authorities);
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(principal, null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    reqInfo.setUserId(userInfo.getUserId());
                    reqInfo.setUser(userInfo);
                }
                break;
            }
        }
    }

    /**
     * 校验token
     *
     * @param token
     * @param response
     */
    private BaseUserInfoDTO VerifyToken(String token, HttpServletResponse response) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        Long userId = JwtUtil.isVerify(token);
        BaseUserInfoDTO user = userDao.queryBasicUserInfo(userId);
        if (user == null) {
            throw BusinessException.newInstance(StatusEnum.JWT_VERIFY_EXISTS);
        }

        // 检查token是否需要更新
        if (JwtUtil.isNeedUpdate(token)) {
            token = JwtUtil.createToken(userId);
            response.addCookie(new Cookie(SESSION_KEY, token));
        }
        return user;
    }
}

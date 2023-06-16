package ink.whi.web.global;

import ink.whi.api.model.context.ReqInfoContext;
import ink.whi.api.model.dto.BaseUserInfoDTO;
import ink.whi.api.model.exception.BusinessException;
import ink.whi.api.model.exception.StatusEnum;
import ink.whi.core.utils.JwtUtil;
import ink.whi.service.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 初始化用户信息
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
     * @param
     */
    public void initUserInfo() {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
        if (request.getCookies() == null) {
            return;
        }
        for (Cookie cookie : request.getCookies()) {
            if (SESSION_KEY.equalsIgnoreCase(cookie.getName())) {
                BaseUserInfoDTO user = VerifyToken(cookie.getValue(), response);
                // 将用户信息写入Security
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, null);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                if (user != null) {
//                    reqInfo.setUserId(user.getUserId());
//                    reqInfo.setUser(user);
//                }
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

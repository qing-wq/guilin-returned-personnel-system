package ink.whi.web.login;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import ink.whi.api.model.dto.BaseUserInfoDTO;
import ink.whi.api.model.exception.StatusEnum;
import ink.whi.api.model.vo.ResVo;
import ink.whi.core.utils.JwtUtil;
import ink.whi.core.utils.SessionUtil;
import ink.whi.service.service.UserService;
import ink.whi.web.global.GlobalInitHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 前台登录接口
 * @author: qing
 * @Date: 2023/6/5
 */
@RequestMapping(path = "auth")
@RestController
public class LoginRestController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param request
     * @param response
     * @return
     */
    @PostMapping(path = "login")
    public ResVo<BaseUserInfoDTO> login(HttpServletRequest request,
                                        HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return ResVo.fail(StatusEnum.ILLEGAL_ARGUMENTS_MIXED, "用户名或密码不能为空");
        }
        BaseUserInfoDTO info = userService.passwordLogin(username, password);
        // 签发token
        String token = JwtUtil.createToken(info.getUserId());
        if (StringUtils.isNotBlank(token)) {
            Cookie cookie = SessionUtil.newCookie(GlobalInitHelper.SESSION_KEY, token);
            response.addCookie(cookie);
            return ResVo.ok(info);
        } else {
            return ResVo.fail(StatusEnum.LOGIN_FAILED_MIXED, "登录失败，请重试");
        }
    }

    /**
     * 登出接口
     * @param response
     * @return
     */
    @PreAuthorize("hasAuthority('bnt.sysRole.list')")
    @GetMapping(path = "logout")
    public ResVo<String> logout(HttpServletResponse response) {
        response.addCookie(SessionUtil.delCookie(GlobalInitHelper.SESSION_KEY));
        return ResVo.ok("ok");
    }
}

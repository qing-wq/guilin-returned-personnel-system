package ink.whi.api.model.vo.user;

import lombok.Data;

/**
 * 用户入参
 * @author: qing
 * @Date: 2023/6/6
 */
@Data
public class UserSaveReq {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}

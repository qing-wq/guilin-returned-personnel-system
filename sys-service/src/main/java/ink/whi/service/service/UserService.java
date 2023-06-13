package ink.whi.service.service;

import ink.whi.api.model.dto.BaseUserInfoDTO;
import ink.whi.service.entity.UserDO;
import org.springframework.security.core.userdetails.User;

/**
 * @author: qing
 * @Date: 2023/5/24
 */
public interface UserService {

    BaseUserInfoDTO passwordLogin(String username, String password);

    UserDO quertByUserName(String username);
}

package ink.whi.service.service;

import ink.whi.api.model.dto.BaseUserInfoDTO;
import org.springframework.security.core.userdetails.User;

/**
 * @author: qing
 * @Date: 2023/5/24
 */
public interface UserService {
    User findByUsername(String username);

    BaseUserInfoDTO passwordLogin(String username, String password);
}

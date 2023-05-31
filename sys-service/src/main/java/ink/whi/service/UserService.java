package ink.whi.service;

import org.springframework.security.core.userdetails.User;

/**
 * @author: qing
 * @Date: 2023/5/24
 */
public interface UserService {
    User findByUsername(String username);
}

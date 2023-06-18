package ink.whi.service.security;

import ink.whi.service.entity.UserDO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author: qing
 * @Date: 2023/6/14
 */
public class CustomUser extends User {

    private UserDO userDO;

    public CustomUser(UserDO user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);
        this.userDO = user;
    }

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }
}

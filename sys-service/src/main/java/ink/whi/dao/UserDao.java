package ink.whi.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ink.whi.entity.UserDO;
import ink.whi.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * @author: qing
 * @Date: 2023/5/24
 */
@Repository
public class UserDao extends ServiceImpl<UserMapper, UserDO> {
    public UserDO findByUsername(String username) {

    }
}

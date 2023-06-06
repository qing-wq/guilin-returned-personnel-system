package ink.whi.service.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ink.whi.api.model.dto.BaseUserInfoDTO;
import ink.whi.service.entity.UserDO;
import ink.whi.service.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * @author: qing
 * @Date: 2023/5/24
 */
@Repository
public class UserDao extends ServiceImpl<UserMapper, UserDO> {
    public BaseUserInfoDTO queryBasicUserInfo(Long userId) {

    }
}

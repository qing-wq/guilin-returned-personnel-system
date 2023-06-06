package ink.whi.service.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ink.whi.api.model.dto.BaseUserInfoDTO;
import ink.whi.api.model.enums.YesOrNoEnum;
import ink.whi.service.converter.UserConverter;
import ink.whi.service.entity.UserDO;
import ink.whi.service.entity.UserInfoDO;
import ink.whi.service.mapper.UserInfoMapper;
import ink.whi.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Wrapper;

/**
 * @author: qing
 * @Date: 2023/5/24
 */
@Repository
public class UserDao extends ServiceImpl<UserInfoMapper, UserInfoDO> {

    @Autowired
    private UserMapper userMapper;

    public BaseUserInfoDTO queryBasicUserInfo(Long userId) {
        UserInfoDO userInfo = lambdaQuery().eq(UserInfoDO::getUserId, userId)
                .eq(UserInfoDO::getDeleted, YesOrNoEnum.NO.getCode()).one();
        return UserConverter.toDTO(userInfo);
    }

    public UserDO queryUserByUserName(String username) {
        LambdaQueryWrapper<UserDO> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(UserDO::getUsername, username)
                .eq(UserDO::getDeleted, YesOrNoEnum.NO.getCode());
        return userMapper.selectOne(wrapper);
    }
}

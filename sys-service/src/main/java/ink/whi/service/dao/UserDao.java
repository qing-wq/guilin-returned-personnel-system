package ink.whi.service.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ink.whi.api.model.dto.BaseUserInfoDTO;
import ink.whi.api.model.enums.YesOrNoEnum;
import ink.whi.service.converter.UserConverter;
import ink.whi.service.entity.UserDO;
import ink.whi.service.entity.UserInfoDO;
import ink.whi.service.entity.UserRegionDO;
import ink.whi.service.mapper.RegionMapper;
import ink.whi.service.mapper.UserInfoMapper;
import ink.whi.service.mapper.UserMapper;
import ink.whi.service.mapper.UserRegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: qing
 * @Date: 2023/5/24
 */
@Repository
public class UserDao extends ServiceImpl<UserInfoMapper, UserInfoDO> {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RegionMapper regionMapper;

    public BaseUserInfoDTO queryBasicUserInfo(Long userId) {
        UserInfoDO userInfo = lambdaQuery().eq(UserInfoDO::getUserId, userId)
                .eq(UserInfoDO::getDeleted, YesOrNoEnum.NO.getCode()).one();
        return UserConverter.toDTO(userInfo);
    }

    public UserDO getUserByUserName(String username) {
        LambdaQueryWrapper<UserDO> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(UserDO::getUsername, username)
                .eq(UserDO::getDeleted, YesOrNoEnum.NO.getCode());
        return userMapper.selectOne(wrapper);
    }

    public List<String> getUserPermission(Long userId) {
        return regionMapper.getUserPermission(userId);
    }

    public UserDO queryByUserName(String username) {
        LambdaQueryWrapper<UserDO> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(UserDO::getUsername, username)
                .eq(UserDO::getDeleted, YesOrNoEnum.NO.getCode());
        return userMapper.selectOne(wrapper);
    }
}

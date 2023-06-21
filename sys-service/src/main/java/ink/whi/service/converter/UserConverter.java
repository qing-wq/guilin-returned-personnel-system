package ink.whi.service.converter;

import ink.whi.api.model.context.ReqInfoContext;
import ink.whi.api.model.dto.BaseRegionDTO;
import ink.whi.api.model.dto.BaseUserInfoDTO;
import ink.whi.api.model.enums.RoleEnum;
import ink.whi.api.model.vo.user.UserInfoSaveReq;
import ink.whi.api.model.vo.user.UserSaveReq;
import ink.whi.service.entity.UserInfoDO;
import org.springframework.beans.BeanUtils;
import ink.whi.service.entity.UserDO;

/**
 * 用户转换
 *
 * @author qing
 * @date 2023/6/6
 */
public class UserConverter {

    public static UserDO toDO(UserSaveReq req) {
        if (req == null) {
            return null;
        }
        UserDO userDO = new UserDO();
        userDO.setId(req.getUserId());
        return userDO;
    }

    public static UserInfoDO toDO(UserInfoSaveReq req) {
        if (req == null) {
            return null;
        }
        UserInfoDO userInfoDO = new UserInfoDO();

        return userInfoDO;
    }

    public static BaseUserInfoDTO toDTO(UserInfoDO info) {
        if (info == null) {
            return null;
        }
        BaseUserInfoDTO user = new BaseUserInfoDTO();
        BeanUtils.copyProperties(info, user);
        user.setRegion(new BaseRegionDTO().setRegionId(info.getRegionId()));
        return user;
    }
}

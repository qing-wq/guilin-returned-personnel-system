package ink.whi.service.service;

import ink.whi.api.model.dto.BaseUserInfoDTO;
import ink.whi.api.model.dto.SimpleUserInfoDTO;
import ink.whi.service.entity.UserDO;

import java.util.List;

/**
 * @author: qing
 * @Date: 2023/5/24
 */
public interface UserService {

    BaseUserInfoDTO passwordLogin(String username, String password);

    UserDO queryByUserName(String username);

    List<SimpleUserInfoDTO> queryByRegion(String region);
}

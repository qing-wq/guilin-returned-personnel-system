package ink.whi.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ink.whi.service.entity.UserRegionDO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: qing
 * @Date: 2023/6/14
 */
@Component
public interface UserRegionMapper extends BaseMapper<UserRegionDO> {

    // 获取用户权限
    List<UserRegionDO> getRoles(Long userId);
}

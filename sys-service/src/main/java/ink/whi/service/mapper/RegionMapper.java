package ink.whi.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ink.whi.service.entity.RegionDO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: qing
 * @Date: 2023/6/16
 */
@Component
public interface RegionMapper extends BaseMapper<RegionDO> {

    /**
     * 查询用户时间
     * @param userId
     * @return
     */
    List<String> getUserPermission(Long userId);
}

package ink.whi.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ink.whi.service.entity.ResourceDO;
import ink.whi.service.entity.RoleResourceDO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: qing
 * @Date: 2023/6/14
 */
@Component
public interface RoleResourceMapper extends BaseMapper<RoleResourceDO> {
    List<ResourceDO> getResources(Long roleId);
}

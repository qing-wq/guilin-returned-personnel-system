package ink.whi.service.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import ink.whi.service.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author: qing
 * @Date: 2023/6/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role_resource")
public class RoleResourceDO extends BaseDO {

    private Long roleId;

    private Set<ResourceDO> resources;

}

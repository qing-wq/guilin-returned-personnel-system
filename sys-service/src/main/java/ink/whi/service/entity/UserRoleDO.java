package ink.whi.service.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import ink.whi.service.entity.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: Administrator
 * @Date: 2023/6/4
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user_role")
public class UserRoleDO extends BaseDO {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 是否删除
     */
    private Integer deleted;
}

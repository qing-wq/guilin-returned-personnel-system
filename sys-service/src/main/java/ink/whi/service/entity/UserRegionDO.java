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
@TableName("sys_user_region")
public class UserRegionDO extends BaseDO {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 地区ID
     */
    private Long regionId;

    /**
     * 是否删除
     */
    private Integer deleted;
}

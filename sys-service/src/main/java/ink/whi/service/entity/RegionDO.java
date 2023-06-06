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
@EqualsAndHashCode(callSuper = false)
@TableName("sys_region")
public class RegionDO extends BaseDO {

    /**
     * 父ID
     */
    private Long pid;

    /**
     * 地区名称
     */
    private String regionName;

    /**
     * 地区等级; 0-区县, 1-市级
     */
    private Integer regionLevel;

    /**
     * 是否删除
     */
    private Integer deleted;
}

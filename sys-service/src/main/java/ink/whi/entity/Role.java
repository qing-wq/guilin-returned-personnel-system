package ink.whi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @author: qing
 * @Date: 2023/5/25
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否删除
     */
    private Integer deleted;


}
package ink.whi.service.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import ink.whi.service.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @author: qing
 * @Date: 2023/5/24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
public class UserDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1297014780705531534L;
    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 0-非管理员，1-管理员
     */
    private Integer isAdmin;

    /**
     * 是否删除
     */
    private Integer deleted;
}

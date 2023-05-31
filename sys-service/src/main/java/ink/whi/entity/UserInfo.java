package ink.whi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @author: qing
 * @Date: 2023/5/24
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserInfo extends BaseDO{

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 姓名
     */
    private String userInfoName;

    /**
     * 所属地区
     */
    private String regoin;

    /**
     * 用户角色
     */
    private String userRole;

    /**
     * 国家
     */
    private String country;

    /**
     * 归国时间
     */
    private String returnTime;

    /**
     * 归国后工作
     */
    private String afterWork;

    /**
     * 归国前工作
     */
    private String beforeWork;

    /**
     * 是否删除
     */
    private Integer deleted;
}

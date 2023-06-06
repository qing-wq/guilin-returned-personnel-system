package ink.whi.service.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import ink.whi.service.entity.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @author: qing
 * @Date: 2023/5/24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user_info")
public class UserInfo extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 姓名
     */
    private String userInfoName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 所属地区
     */
    private Long regin_id;

    /**
     * 归国前国家
     */
    private String country;

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 出国时间
     */
    private Data goTime;

    /**
     * 归国时间
     */
    private Data returnTime;

    /**
     * 归国前工作
     */
    private String beforeWork;

    /**
     * 归国后工作
     */
    private String afterWork;

    /**
     * 是否删除
     */
    private Integer deleted;
}

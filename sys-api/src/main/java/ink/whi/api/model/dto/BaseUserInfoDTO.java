package ink.whi.api.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: qing
 * @Date: 2023/5/7
 */
@Data
@Accessors(chain = true)
public class BaseUserInfoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -1854535202157642028L;

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
    private BaseRegionDTO region;

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
    private Date goTime;

    /**
     * 归国时间
     */
    private Date returnTime;

    /**
     * 归国后工作
     */
    private String afterWork;

    /**
     * 归国前工作
     */
    private String beforeWork;
}

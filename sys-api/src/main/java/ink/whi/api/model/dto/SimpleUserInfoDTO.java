package ink.whi.api.model.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author: qing
 * @Date: 2023/6/22
 */
@Data
public class SimpleUserInfoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 8655842695770939646L;

    /**
     * 姓名
     */
    private String userInfoName;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 所在地
     */
    private String region;

    /**
     * 国家
     */
    private String country;

    /**
     * 工作
     */
    private String work;
}

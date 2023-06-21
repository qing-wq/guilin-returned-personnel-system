package ink.whi.api.model.enums;

import lombok.Getter;

import java.util.Objects;

/**
 * @author: qing
 * @Date: 2023/6/21
 */
@Getter
public enum RoleEnum {
    ADMIN(0, "管理员"),
    CITY(1, "市级人员"),
    COUNTY(2, "区县人员")
    ;

    private int role;
    private String desc;

    RoleEnum(int role, String desc) {
        this.role = role;
        this.desc = desc;
    }

    public static RoleEnum role(Integer roleId) {
        for (RoleEnum value : RoleEnum.values()) {
            if (Objects.equals(roleId, value.getRole())) {
                return value;
            }
        }
        return RoleEnum.COUNTY;
    }
}

package ink.whi.api.model.enums;

import lombok.Getter;

/**
 * @author: qing
 * @Date: 2023/6/22
 */
@Getter
public enum RegionEnum {

    GUILIN("guilin", "桂林市"),
    GONGCHENG("gongcheng", "恭城"),
    XIANGSHAN("xiangshan","象山区"),
    QIXING("qixing", "七星区"),
    XINGAN("xingan","兴安县"),
    LONGSHENG("longsheng", "龙胜县"),
    LINGUI("lingui", "临桂区"),




    private String desc;
    private String name;

    RegionEnum(String desc, String name) {
        this.desc = desc;
        this.name = name;
    }
}

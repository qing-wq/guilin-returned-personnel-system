package ink.whi.api.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author: qing
 * @Date: 2023/6/19
 */
@Data
@Accessors(chain = true)
public class BaseRegionDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -1367094145991535384L;

    /**
     * 地区id
     */
    private Long regionId;

    /**
     * 地区名称
     */
    private String regionName;

    /**
     * 地区等级; 0-区县, 1-市级
     */
    private Integer regionLevel;
}

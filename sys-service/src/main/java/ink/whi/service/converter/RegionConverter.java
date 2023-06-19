package ink.whi.service.converter;

import ink.whi.api.model.dto.BaseRegionDTO;
import ink.whi.service.entity.RegionDO;

/**
 * @author: qing
 * @Date: 2023/6/19
 */
public class RegionConverter {

    public static BaseRegionDTO toDto(RegionDO region) {
        BaseRegionDTO dto = new BaseRegionDTO();
        dto.setRegionName(region.getRegionName());
        dto.setRegionLevel(region.getRegionLevel());
        return dto;
    }
}

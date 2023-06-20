package ink.whi.web.front.vo;

import ink.whi.api.model.dto.BaseUserInfoDTO;
import lombok.Data;

import java.util.List;

/**
 * @author: qing
 * @Date: 2023/6/19
 */
@Data
public class StatisticVo {

    /**
     * 人员列表
     */
    private List<BaseUserInfoDTO> userList;

}

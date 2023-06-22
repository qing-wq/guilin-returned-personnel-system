package ink.whi.web.front.statistic;

import ink.whi.api.model.vo.ResVo;
import ink.whi.service.service.UserService;
import ink.whi.web.front.vo.StatisticVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据统计接口
 * @author: qing
 * @Date: 2023/6/19
 */
@RestController
@RequestMapping(path = "statistic")
public class StatisticRestController{

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('region:' + #region) || hasAnyAuthority('ADMIN', 'CITY')")
    @GetMapping(path = "total")
    public ResVo<StatisticVo> queryTotal(@RequestParam(name = "region") String region) {
        userService.queryByRegion(region);
    }
}

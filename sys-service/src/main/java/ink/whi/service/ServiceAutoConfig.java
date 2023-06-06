package ink.whi.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author qing
 * @date 2023/4/26
 */
@Configuration
@ComponentScan(basePackages = "ink.whi")
@MapperScan
public class ServiceAutoConfig {
}

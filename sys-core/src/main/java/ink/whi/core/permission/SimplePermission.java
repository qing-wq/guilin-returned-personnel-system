package ink.whi.core.permission;

import lombok.Data;

import java.util.Map;

/**
 * @author: qing
 * @Date: 2023/5/24
 */
@Data
public class SimplePermission {
    /**
     * 资源id
     */
    private String resourceId;

    /**
     * 资源名
     */
    private String resourceName;

    /**
     * 权限列表
     */
    private Map<String, String> privileges;

    /**
     * 是否被遗弃
     */
    private boolean abandon = false;
}

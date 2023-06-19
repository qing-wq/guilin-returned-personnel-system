package ink.whi.core.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * 自定义密码编码器
 * @author: qing
 * @Date: 2023/6/18
 */
public class CustomMd5PasswordEncoder implements PasswordEncoder {

    /**
     * 盐值
     */
    @Value("${security.salt}")
    private String salt;

    /**
     * 加盐位置
     */
    @Value("${security.salt-index}")
    private Integer saltIndex;

    @Override
    public String encode(CharSequence password) {
        String plainPwd = password.toString();
        if (plainPwd.length() > saltIndex) {
            plainPwd = plainPwd.substring(0, saltIndex) + salt + plainPwd.substring(saltIndex);
        } else {
            plainPwd = plainPwd + salt;
        }

        return DigestUtils.md5DigestAsHex(plainPwd.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encPwd) {
        String plainPwd = rawPassword.toString();
        if (plainPwd.length() > saltIndex) {
            plainPwd = plainPwd.substring(0, saltIndex) + salt + plainPwd.substring(saltIndex);
        } else {
            plainPwd = plainPwd + salt;
        }

        return Objects.equals(DigestUtils.md5DigestAsHex(plainPwd.getBytes(StandardCharsets.UTF_8)), encPwd);
    }
}

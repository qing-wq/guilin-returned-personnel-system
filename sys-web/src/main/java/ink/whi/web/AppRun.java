package ink.whi.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author: qing
 * @Date: 2023/6/5
 */
@ServletComponentScan
@SpringBootApplication
public class AppRun {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AppRun.class).allowCircularReferences(true).run(args);
    }
}

package top.zhu.tcomadminapi.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.zhu.tcomadminapi.common.handler.MyMetaObjectHandler;

@Configuration
public class MybatisPlusConfig {
    @Bean
    public MyMetaObjectHandler myMetaObjectHandler() {
        return new MyMetaObjectHandler();
    }
}

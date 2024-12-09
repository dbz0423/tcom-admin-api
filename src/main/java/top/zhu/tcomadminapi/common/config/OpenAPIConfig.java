package top.zhu.tcomadminapi.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Tcom Admin API",
                version = "1.0",
                description = "API documentation for Tcom Admin",
                contact = @Contact(name = "Support", email = "support@example.com")
        )
)
public class OpenAPIConfig {
}

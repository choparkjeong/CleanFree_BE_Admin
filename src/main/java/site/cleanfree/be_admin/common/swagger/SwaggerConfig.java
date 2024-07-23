package site.cleanfree.be_admin.common.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
@OpenAPIDefinition(
    info = @Info(title = "관리자 API 문서", version = "1.0", description = "Admin API v1.0")
)
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI().components(new Components());
    }
}

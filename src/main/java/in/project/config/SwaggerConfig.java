package in.project.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                .title("Packers-Movers")
                .version("1.0")
                .description("API documentation for the backend"));
    }
}




//http://127.0.0.1:1111/swagger-ui/index.html#/
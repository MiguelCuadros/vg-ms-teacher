package pe.edu.vallegrande.teacher.application.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI teacherOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Teacher API")
                        .description("Teacher API implemented with Spring Boot RESTful service")
                        .version("v1.0")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")
                        )
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Teacher Wiki Documentation")
                        .url("https://vallegrande.edu.pe/teacher")
                );
    }

}

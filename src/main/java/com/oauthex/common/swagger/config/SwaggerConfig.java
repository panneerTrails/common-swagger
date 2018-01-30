package com.oauthex.common.swagger.config;

import com.oauthex.common.swagger.controller.HomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
@ConditionalOnProperty(value = "common.web.config.swagger.enabled", matchIfMissing = true)
@EnableConfigurationProperties(CommonSwaggerProperties.class)
public class SwaggerConfig {

    @Autowired
    CommonSwaggerProperties properties;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(properties.getControllerPackage()))
                .build().apiInfo(apiInfo()).globalOperationParameters(globalOperationParameters());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                properties.getApiName(),
                properties.getApiDescription(),
                properties.getApiVersion(),
                null,
                new Contact(properties.getAuthor(), null, "panneerselvam.sn@gmail.com"),
                null,
                null);
        return apiInfo;
    }

    /**
     * Create global parameter that adds Authorization swagger token to each endpoint
     * http://springfox.github.io/springfox/docs/current
     * https://github.com/springfox/springfox/issues/845
     */
    private List<Parameter> globalOperationParameters() {
        return Collections.singletonList(new ParameterBuilder()
                .name("Authorization")
                .description("Authorization token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .defaultValue("Bearer X")
                .required(true)
                .build());
    }

    @Bean
    public HomeController homeController() {
        return new HomeController();
    }

}

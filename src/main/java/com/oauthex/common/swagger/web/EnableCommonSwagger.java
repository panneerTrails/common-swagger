package com.oauthex.common.swagger.web;

import com.oauthex.common.swagger.config.CommonSwaggerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CommonSwaggerProperties.class)
public @interface EnableCommonSwagger {
}

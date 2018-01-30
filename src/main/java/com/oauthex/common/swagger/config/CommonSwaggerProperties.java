package com.oauthex.common.swagger.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("common.web.config.swagger")
public class CommonSwaggerProperties {

    /**
     * Swagger config is enabled by default. Use this to disable it entirely.
     * Apps will be responsible for defining their @EnableSwagger and misc.
     * configuration themselves
     */
    private boolean enabled;
    /**
     * Base package to scan for Spring Controllers. Ideally this should just
     * be set to your controller package directly to avoid pulling in any
     * extra autoconfigured controllers.
     */
    private String controllerPackage = "com.oauthex";
    /**
     * "Author" of the API, as displayed at the top of your Swagger documentation
     */
    private String author = "Panneerselvam";
    /**
     * Short name of your API. Try to keep this to the microservice name
     */
    private String apiName = "Default API name";
    /**
     * Longer description of your API. Include likely use cases or describe
     * collaborating services here as well.
     */
    private String apiDescription = "This API Needs a description!";
    /**
     * Version of the API, noted at the bottom of the page. This version has no
     * direct influence on any API wiring, it is purely informational.
     */
    private String apiVersion = "v1";

    public boolean isEnabled() {
        return enabled;
    }

    public CommonSwaggerProperties setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    public CommonSwaggerProperties setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public CommonSwaggerProperties setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getApiName() {
        return apiName;
    }

    public CommonSwaggerProperties setApiName(String apiName) {
        this.apiName = apiName;
        return this;
    }

    public String getApiDescription() {
        return apiDescription;
    }

    public CommonSwaggerProperties setApiDescription(String apiDescription) {
        this.apiDescription = apiDescription;
        return this;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public CommonSwaggerProperties setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }
}

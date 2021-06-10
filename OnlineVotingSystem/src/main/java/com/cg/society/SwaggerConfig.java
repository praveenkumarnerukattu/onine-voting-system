package com.cg.society;

import static com.google.common.base.Predicates.or;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("CooperativeSociety-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/CooperativeSociety/.*"),regex("/RegisteredSocietyVoter/.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Customer API").description("PRAVEEN API")
				.termsOfServiceUrl("http://praveen.com").license("PRAVEEN License").licenseUrl("PRAVEEN.ahmad.khan786@gmail.com")
				.version("1.0").build();
	}

}
package com.batch2.onlineshopping.config;


@OpenAPIDefinition(
		info = @Info(
			    title = "Online Shopping API",
			    version = "V.1.0",
			    description = "This API helps us to Users and Products info"
			)
		)
@SecurityScheme(
		  name = "Bearer Authentication",
		  type = SecuritySchemeType.HTTP,
		  bearerFormat = "JWT",
		  scheme = "bearer"
		)

public class SwaggerConfig {

}

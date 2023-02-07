package com.mouse.maps.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

import static io.swagger.v3.oas.annotations.enums.SecuritySchemeType.OPENIDCONNECT;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = OPENIDCONNECT,
        openIdConnectUrl = "http://localhost:9001/api/.well-known/openid-configuration", //,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer"
)
public class OpenAPIConfig { }

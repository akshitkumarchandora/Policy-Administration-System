package com.cognizant.pas.consumer.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtUtility {

    private String secretKey;
    private String tokenPrefix;
    private String tokenHeader;
    private String claimsName;
    private int tokenExpirationDate;
    private String authority;

}

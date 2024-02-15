package com.scaler.productservice.commons;

import com.scaler.productservice.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationCommons {

    private RestTemplate restTemplate;

    public AuthenticationCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public  UserDto validateToken(String token){

        ResponseEntity<UserDto> dto = restTemplate.getForObject(
                "http://localhost:8181/user/validate/" + token,
                null,
                UserDto.class
        );

        if (dto.getBody() == null){
            return null;
        }

        return dto.getBody();
    }
}

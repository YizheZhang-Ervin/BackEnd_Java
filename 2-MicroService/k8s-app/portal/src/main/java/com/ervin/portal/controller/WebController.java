package com.ervin.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebController {

    RestTemplate restTemplate = new RestTemplate();

    private String apiServiceUrl;

    @Autowired
    public WebController(
            @Value("${url.api-service}") String apiServiceUrl
    ) {
        this.apiServiceUrl = apiServiceUrl;
    }

    @GetMapping("/test")
    public ResponseObj testLocal() {
        return new ResponseObj("portal");
    }

    @GetMapping("/test/api-service")
    public ResponseObj testRemote() {
        ResponseEntity<ResponseObj> response = restTemplate.getForEntity(apiServiceUrl + "/test", ResponseObj.class);
        return response.getBody();
    }
}

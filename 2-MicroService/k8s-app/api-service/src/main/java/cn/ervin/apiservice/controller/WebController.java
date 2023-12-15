package cn.ervin.apiservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    public WebController() {
    }

    @GetMapping("/test")
    public ResponseObj test() {
        return new ResponseObj("api-service");
    }
}

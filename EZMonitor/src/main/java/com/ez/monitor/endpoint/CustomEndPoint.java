package com.ez.monitor.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id="xxEndpoint")
public class CustomEndPoint {
    public Map<String,Object> xxMap = new HashMap<>();

    public CustomEndPoint(){
        xxMap.put("old",18);
        xxMap.put("like","xxx");
    }

    @ReadOperation
    public Map<String,Object> show(){
        return xxMap;
    }

    @WriteOperation
    public void write(String key,String value){
        xxMap.put(key,value);
    }

}

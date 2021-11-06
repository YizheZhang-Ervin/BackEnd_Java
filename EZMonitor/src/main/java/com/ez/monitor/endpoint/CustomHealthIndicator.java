package com.ez.monitor.endpoint;
// actuator/health
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception{
        try{
            boolean ischeck = check();
            if(ischeck){
                builder.up().withDetail("total",1);
            }else{
                builder.down();
            }
        }catch(Exception e){
            builder.down().withException(e);
        }
    }
    protected boolean check(){
        int a = 1/0;
        return true;
    }
}

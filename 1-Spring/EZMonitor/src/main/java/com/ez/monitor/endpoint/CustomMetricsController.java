package com.ez.monitor.endpoint;

import io.micrometer.core.instrument.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomMetricsController {
//    @Autowired
//    MeterRegistry meterRegistry;

    @GetMapping("/custommetric")
    public String customMetric(String username){
        // 统计
        Metrics.counter("xxCounter", "username",username).increment();
        // meterRegistry.counter("xxCounter").increment();  // 可用Metrics或meterRegistry
        // 计时
        Timer timer = Metrics.timer("xxTimer");
        timer.record(()->{
            System.out.println("success");
        });
        // 仪表,记录集合数量(如消息数量)
        Metrics.gauge("xxGauge",996);
        // 摘要summary,记录百分比double(如缓存命中率)
        DistributionSummary summary = Metrics.summary("xxSummary");
        summary.record(1.5);

        return "success";
    }
}

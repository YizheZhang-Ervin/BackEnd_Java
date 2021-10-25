package com.ervin.EZSpring.WebEntrance.config;

import com.ervin.EZSpring.WebEntrance.scheduler.MyJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(MyJob.class).storeDurably().build();
    }

//    @Bean
//    public Trigger trigger1(){
//        SimpleScheduleBuilder sb = SimpleScheduleBuilder.simpleSchedule()
//                .withIntervalInSeconds(1)
//                .repeatForever();
//        return TriggerBuilder.newTrigger()
//                .withIdentity("trigger1","group1")
//                .withSchedule(sb)
//                .forJob(jobDetail())
//                .build();
//    }

//    @Bean
//    public Trigger trigger2(){
//        return TriggerBuilder.newTrigger()
//                .withIdentity("trigger2","group1")
//                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? *"))
//                .forJob(jobDetail())
//                .build();
//    }
}
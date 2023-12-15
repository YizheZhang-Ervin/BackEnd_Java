package com.ez.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class EzMonitorApplication {

  public static void main(String[] args) {
    SpringApplication.run(EzMonitorApplication.class, args);
  }
}
package com.example.nativeimage.cli;

import com.example.nativeimage.app.MyApp;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Utility class that wrap a Spring application
 */
//@Component
@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SpringApplicationManager {
  private  final SpringApplication springApplication;
  private  ConfigurableApplicationContext context;

  public static SpringApplicationManager create(String... args) {
    SpringApplication springApplication = new SpringApplicationBuilder(MyApp.class)
        .main(MyApp.class)
        .properties()
        .build(args);
    return new SpringApplicationManager(springApplication);
  }

  public  void start() {
    if (!isRunning()) {
      log.info("Starting Proxy Server...");
      context = springApplication.run();
      log.info("Proxy Server started");
    }
  }
//
  public  void stop() {
    if (context != null) {
      log.info("Stopping Proxy Server...");
      SpringApplication.exit(context);
      log.info("Proxy Server stopped.");
    }
  }

  public  boolean isRunning() {
    return context != null && context.isRunning();
  }

  public  void restart() {
    stop();
    start();
  }

}

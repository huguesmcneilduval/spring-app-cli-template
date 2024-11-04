package com.example.nativeimage.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class MyApp implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    log.info("This is from spring app");
    TestPojo testPojo = new TestPojo("Maria");
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(testPojo);
    log.info("Test pojo: {}. Json={}", testPojo.name(), json);
  }

  public static void main(String... args) {
    SpringApplication.run(MyApp.class, args);
  }
}
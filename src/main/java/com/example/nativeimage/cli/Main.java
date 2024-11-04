package com.example.nativeimage.cli;


import com.example.nativeimage.app.TestPojo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@Slf4j
@CommandLine.Command(name = "server",
    subcommands = {
        StartCommand.class,
        RestartCommand.class,
        StopCommand.class,
        StatusCommand.class
    }
)
public class Main implements Callable<Integer> {
  public static void main(String... args) throws Exception {
    log.info("This is from main");
    TestPojo testPojo = new TestPojo("Jimmy");
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(testPojo);
    log.info("Test pojo: {}. Json={}", testPojo.name(), json);
    int exitCode = new CommandLine(new Main()).execute(args);
    System.exit(exitCode);
  }

  @Override
  public Integer call() throws Exception {
    log.info("What from main");
    log.info("Nothing to do in main");
    return 0;
  }
}

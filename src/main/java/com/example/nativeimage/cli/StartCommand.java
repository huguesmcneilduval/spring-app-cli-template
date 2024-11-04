package com.example.nativeimage.cli;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
    name = "start"
)
@Slf4j
public class StartCommand implements Callable<Integer> {
  @Override
  public Integer call() throws Exception {
    log.info("What up from start");
    ManagementServer.startAsHttpServer();
//    ProxyServer.main();
    return 0;
  }
}

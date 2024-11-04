package com.example.nativeimage.cli;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

import java.net.http.HttpRequest;
import java.util.concurrent.Callable;

@CommandLine.Command(
    name = "restart"
)
@Slf4j
public class RestartCommand extends ManagementServerHttpClient implements Callable<Integer> {
  @Override
  public Integer call() throws Exception {
    log.info("Restart command...");
    request(builder -> builder.PUT(HttpRequest.BodyPublishers.noBody()));
    return 0;
  }
}

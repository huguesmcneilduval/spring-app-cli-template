package com.example.nativeimage.cli;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

import java.net.http.HttpRequest;
import java.util.concurrent.Callable;

@CommandLine.Command(
    name = "stop"
)
@Slf4j
public class StopCommand extends ManagementServerHttpClient implements Callable<Integer> {
  @Override
  public Integer call() throws Exception {
    log.info("Stop command...");
    request(HttpRequest.Builder::DELETE);
    return 0;
  }
}

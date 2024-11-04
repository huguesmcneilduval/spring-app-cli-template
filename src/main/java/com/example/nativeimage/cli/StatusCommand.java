package com.example.nativeimage.cli;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

import java.net.http.HttpRequest;
import java.util.concurrent.Callable;

@CommandLine.Command(
    name = "status"
)
@Slf4j
public class StatusCommand extends ManagementServerHttpClient implements Callable<Integer> {
  @Override
  public Integer call() throws Exception {
    log.info("Get command...");
    request(HttpRequest.Builder::GET);
    return 0;
  }
}

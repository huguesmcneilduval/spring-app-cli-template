package com.example.nativeimage.cli;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

/**
 * HttpClient to ManagementServer
 */
@Slf4j
public abstract class ManagementServerHttpClient {

  protected void request(Consumer<HttpRequest.Builder> requestConfigurer) throws IOException, InterruptedException {
    try (HttpClient httpClient = HttpClient.newHttpClient()) {
      HttpRequest.Builder request = HttpRequest.newBuilder()
          .uri(URI.create("http://localhost:8900"));
      requestConfigurer.accept(request);
      HttpResponse<String> response = httpClient.send(request.build(), HttpResponse.BodyHandlers.ofString());
      log.info("Response: {}", response.body());
    }
  }

}

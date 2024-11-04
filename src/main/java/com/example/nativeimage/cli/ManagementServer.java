package com.example.nativeimage.cli;

import com.sun.net.httpserver.HttpServer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

/**
 * Web Server as endpoint to start/stop/restart/status
 */
@RequiredArgsConstructor
@Slf4j
public class ManagementServer {
  public static void startAsHttpServer(String... args) throws IOException, InterruptedException {
    CountDownLatch countDownLatch = new CountDownLatch(1);
    SpringApplicationManager springApplicationManager = SpringApplicationManager.create(args);
    final int port = Integer.parseInt(Optional.ofNullable(args.length > 0 ? args[0] : null).orElse("8900"));
    HttpServer httpServer = HttpServer.create(new InetSocketAddress(port), 0);
    httpServer.createContext("/", exchange -> {
      String response = exchange.getRequestMethod();
      switch (exchange.getRequestMethod()) {
        case "GET" -> {
          log.info("GET");
          response = springApplicationManager.isRunning() ? "Running" : "Down";
        }
        case "PUT" -> {
          log.info("PUT");
          springApplicationManager.restart();
        }
        case "DELETE" -> {
          log.info("DELETE");
          springApplicationManager.stop();
          countDownLatch.countDown();
        }
        case "POST" -> {
          log.info("POST");
          springApplicationManager.start();
        }
        default -> throw new RuntimeException("Invalid method");
      }
      byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);
      exchange.sendResponseHeaders(200, responseBytes.length);
      try (OutputStream responseBody = exchange.getResponseBody()) {
        responseBody.write(responseBytes);
      }
    });
    httpServer.start();
    springApplicationManager.start();
    log.info("Server listening to port " + port);
    countDownLatch.await();
    log.info("Shutting down the management server...");
    httpServer.stop(10);
    log.info("Server shutdown.");
  }
}

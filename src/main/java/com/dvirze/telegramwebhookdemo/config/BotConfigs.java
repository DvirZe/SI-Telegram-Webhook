package com.dvirze.telegramwebhookdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

/** Test. */
@Configuration
public class BotConfigs {

  @Bean
  WebClient telegramWebClient(BotProperties botProperties) {

    return WebClient.builder()
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .baseUrl(String.format("https://api.telegram.org/bot%s/", botProperties.getToken()))
        .build();
  }
}

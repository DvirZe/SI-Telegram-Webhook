package com.dvirze.telegramwebhookdemo.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.integration.webflux.dsl.WebFlux;
import org.springframework.integration.webflux.dsl.WebFluxMessageHandlerSpec;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import org.telegram.telegrambots.meta.api.objects.ApiResponse;

/** Handlers for telegram api actions. */
@Component
@RequiredArgsConstructor
public class TelegramGateway {

  private final WebClient telegramWebClient;

  /**
   * Send "sendMessage" action using the telegram webclient.
   */
  public WebFluxMessageHandlerSpec sendMessage() {
    return WebFlux.outboundGateway(
            UriComponentsBuilder.fromPath("sendMessage").toUriString(), telegramWebClient)
        .mappedRequestHeaders()
        .mappedResponseHeaders()
        .httpMethod(HttpMethod.POST)
        .expectedResponseType(ApiResponse.class);
  }
}

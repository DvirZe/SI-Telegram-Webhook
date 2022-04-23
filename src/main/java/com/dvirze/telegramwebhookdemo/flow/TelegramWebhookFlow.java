package com.dvirze.telegramwebhookdemo.flow;

import com.dvirze.telegramwebhookdemo.api.TelegramGateway;
import com.dvirze.telegramwebhookdemo.mappers.MessageToResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.webflux.dsl.WebFlux;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Integration flow to support using of telegram bot with webhook.
 */
@Configuration
public class TelegramWebhookFlow {

  @Bean
  IntegrationFlow inboundFlow(MessageToResponse messageToResponse,
                              TelegramGateway telegramGateway) {
    return IntegrationFlows.from(
            WebFlux.inboundGateway("/webhook")
                .requestMapping(m -> m.methods(HttpMethod.POST))
                .statusCodeFunction(r -> HttpStatus.OK))
        .transform(Transformers.fromJson(Update.class))
        .transform(messageToResponse::getPhoneLinks)
        .handle(telegramGateway.sendMessage())
        .get();
  }
}

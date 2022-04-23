package com.dvirze.telegramwebhookdemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Bot info data.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "info.bot")
public class BotProperties {

  private String name;
  private String token;
}

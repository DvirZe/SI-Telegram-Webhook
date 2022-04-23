package com.dvirze.telegramwebhookdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * main.
 */
@SpringBootApplication
@ConfigurationPropertiesScan("com.dvirze.telegramwebhookdemo.config")
public class TelegramDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(TelegramDemoApplication.class, args);
  }
}

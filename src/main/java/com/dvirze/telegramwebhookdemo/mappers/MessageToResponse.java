package com.dvirze.telegramwebhookdemo.mappers;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

/** MessageToResponse. */
@Component
public class MessageToResponse {

  /**
   * Mapper to return links for search phone numbers on the internet.
   */
  public SendMessage getPhoneLinks(Update update) {
    final String text = update.getMessage().getText();
    final String chatId = update.getMessage().getChatId().toString();

    String updatedText = StringUtils.deleteAny(text, "-+()");
    updatedText = StringUtils.trimAllWhitespace(updatedText);
    boolean matches = updatedText.matches("[0-9]+");

    SendMessage.SendMessageBuilder sendMessageBuilder =
        SendMessage.builder().chatId(chatId).parseMode("HTML").disableWebPagePreview(true);
    if (matches) {
      sendMessageBuilder.text(getPhoneLinks(updatedText));
    } else {
      sendMessageBuilder.text("Failed on phone number validation");
    }

    return sendMessageBuilder.build();
  }

  private String getPhoneLinks(String phone) {
    StringBuilder stringBuilder = new StringBuilder(0);
    String phoneWithDash = phone.substring(0, 3) + "-" + phone.substring(3);

    // Link to whatsApp
    stringBuilder
        .append("\uD83D\uDC65 <b>WhatsApp</b>: ")
        .append("<a href=\"https://api.whatsapp.com/send?phone=+972")
        .append(phone.substring(1))
        .append("&text=")
        .append("\">Click here</a>")
        .append("\n");

    // Link to google without dash
    stringBuilder
        .append("\u27A1 <b>Google 1</b>: ")
        .append("<a href=\"https://google.com/search?q=")
        .append(phone)
        .append("\">Click here</a>")
        .append("\n");

    // Link to google with dash
    stringBuilder
        .append("\u27A1 <b>Google 2</b>: ")
        .append("<a href=\"https://google.com/search?q=")
        .append(phoneWithDash)
        .append("\">Click here</a>")
        .append("\n");

    // Link to Facebook without dash
    stringBuilder
        .append("\uD83D\uDCD8 <b>Facebook 1</b>: ")
        .append("<a href=\"https://www.facebook.com/search/top?q=")
        .append(phone)
        .append("\">Click here</a>")
        .append("\n");

    // Link to Facebook with dash
    stringBuilder
        .append("\uD83D\uDCD8 <b>Facebook 2</b>: ")
        .append("<a href=\"https://www.facebook.com/search/top?q=")
        .append(phoneWithDash)
        .append("\">Click here</a>")
        .append("\n");

    // Link to True Caller
    stringBuilder
        .append("\uD83D\uDCDE <b>True Caller</b>: ")
        .append("<a href=\"https://www.truecaller.com/search/il/")
        .append(phone)
        .append("\">Click here</a>")
        .append("\n");

    return stringBuilder.toString();
  }
}


# Telegram Bot webhook with Spring Integration

A simple project to test using of Telegram bot webhook option with Spring Integration
and with Webflux for outbound response.


## Run Locally
1. Create new telegram bot - [See the documentation](https://core.telegram.org/bots#3-how-do-i-create-a-bot)
2. Clone the project

```bash
  git clone https://github.com/DvirZe/SI-Telegram-Webhook.git
```

3. Create application.properties file under src/main/resources
```
  # Name of the bot (without @) and the token (given by @BotFather)
  info.bot.name=
  info.bot.token=

  # Port can be 443 or 80 or 88 or 8443 - see telegram bot api doc
  server.port=
```

4. Run your project

5. Run [ngrok](https://ngrok.com/) - register and auth if needed
```bash
  ngrok http {the number of port}
```

6. Add the webhook to your Telegram bot.
```
  https://api.telegram.org/bot{your bot token}/setWebhook?url={generated url from ngrok}/webhook
```

7. Send message Via Telegram.

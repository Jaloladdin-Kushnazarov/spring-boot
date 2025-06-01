package org.example.spbootpr1;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;


@Component
public class TelegramAppender extends AppenderBase<ILoggingEvent> {


    private static final String botToken = "7910391557:AAHkyvD4ZIOIJr1i88yzMRG6cMsvSOeIkaM";

    private static final String chatID = "518471586";

    private final TelegramBot telegramBot = new TelegramBot(botToken);

    public TelegramAppender() {
        addFilter(new Filter<ILoggingEvent>() {
            @Override
            public FilterReply decide(ILoggingEvent iLoggingEvent) {
                return iLoggingEvent.getLevel().equals(Level.ERROR) ? FilterReply.ACCEPT : FilterReply.DENY;
            }
        });
    }

    @Override
    protected void append(ILoggingEvent iLoggingEvent) {
        String loggingMessage    = iLoggingEvent.toString();
        SendMessage sendMessage = new SendMessage(chatID, loggingMessage);
        System.out.println("----->>>>>>>>>>>>>>>>>"+ sendMessage);
        telegramBot.execute(sendMessage);
    }
}

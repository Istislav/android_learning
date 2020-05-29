package ru.istislav.quotes;

import java.util.concurrent.ThreadLocalRandom;

public class QuoteServer {
    String[] getQuotes() {
        String[] quotes = new String[] {"Мама, я буду хорошим", "Скоро будет новый год", "Семь раз отмерь, один раз отрежь"};
        return quotes;
    }

    String getRandomQuote() {
        String quote;
        int quotesArrayLen = getQuotes().length;
        int randomNum = ThreadLocalRandom.current().nextInt(quotesArrayLen);
        quote = getQuotes()[randomNum];
        return quote;
    }
}

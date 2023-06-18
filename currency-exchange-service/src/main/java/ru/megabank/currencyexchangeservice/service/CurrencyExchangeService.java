package ru.megabank.currencyexchangeservice.service;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import ru.megabank.currencyexchangeservice.model.CurrencyExchange;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class CurrencyExchangeService {

    private final Environment environment;

    public CurrencyExchange getExchangeValue(String from, String to) {
        String port = environment.getProperty("local.server.port");
        return new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50), port);
    }

}
package ru.megabank.currencyconversionservice.service;

import org.springframework.stereotype.Service;
import ru.megabank.currencyconversionservice.model.CurrencyConversion;

import java.math.BigDecimal;

@Service
public class CurrencyConversionService {

    public CurrencyConversion calculateCurrencyConversion(String from, String to, BigDecimal quantity) {
        return new CurrencyConversion(100L, from, to, quantity, BigDecimal.ONE, BigDecimal.ONE,"");
    }

}
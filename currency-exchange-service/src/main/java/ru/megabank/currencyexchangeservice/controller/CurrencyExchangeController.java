package ru.megabank.currencyexchangeservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.megabank.currencyexchangeservice.model.CurrencyExchange;
import ru.megabank.currencyexchangeservice.service.CurrencyExchangeService;

@RestController
@AllArgsConstructor
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getExchangeValue(@PathVariable String from, @PathVariable String to) {
        return currencyExchangeService.getExchangeValue(from, to);
    }

}
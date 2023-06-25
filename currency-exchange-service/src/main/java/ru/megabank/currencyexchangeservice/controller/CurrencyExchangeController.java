package ru.megabank.currencyexchangeservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.megabank.currencyexchangeservice.dto.CurrencyExchangeDto;
import ru.megabank.currencyexchangeservice.service.CurrencyExchangeService;

@Slf4j
@RestController
@AllArgsConstructor
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchangeDto getExchangeValue(@PathVariable String from, @PathVariable String to) {
        log.info("retrieveExchangeValue called with {} to {}", from, to);
        return currencyExchangeService.getExchangeValue(from, to);
    }

}
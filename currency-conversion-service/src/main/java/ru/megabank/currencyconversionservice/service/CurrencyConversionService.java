package ru.megabank.currencyconversionservice.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.megabank.currencyconversionservice.dto.CurrencyExchangeDto;
import ru.megabank.currencyconversionservice.feign.CurrencyExchangeProxy;
import ru.megabank.currencyconversionservice.model.CurrencyConversion;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class CurrencyConversionService {

    private final CurrencyExchangeProxy currencyExchangeProxy;

    public CurrencyConversion calculateCurrencyConversion(String from, String to, BigDecimal quantity) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyExchangeDto> responseEntity =
                new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                        CurrencyExchangeDto.class, uriVariables);
        CurrencyExchangeDto currencyExchangeDto = responseEntity.getBody();
        return new CurrencyConversion(currencyExchangeDto.getId(), from, to, quantity,
                currencyExchangeDto.getConversionMultiple(), quantity.multiply(currencyExchangeDto.getConversionMultiple()),
                currencyExchangeDto.getEnvironment() + " rest template");
    }

    public CurrencyConversion calculateCurrencyConversionFeign(String from, String to, BigDecimal quantity) {
        CurrencyExchangeDto currencyExchangeDto = currencyExchangeProxy.getExchangeValue(from, to);
        return new CurrencyConversion(currencyExchangeDto.getId(), from, to, quantity,
                currencyExchangeDto.getConversionMultiple(), quantity.multiply(currencyExchangeDto.getConversionMultiple()),
                currencyExchangeDto.getEnvironment() + " feign");
    }

}
package ru.megabank.currencyexchangeservice.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import ru.megabank.currencyexchangeservice.dto.CurrencyExchangeDto;
import ru.megabank.currencyexchangeservice.repository.CurrencyExchangeRepository;

@Service
@AllArgsConstructor
public class CurrencyExchangeService {

    private final Environment environment;

    private final CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeDto getExchangeValue(String from, String to) throws RuntimeException {
        String port = environment.getProperty("local.server.port");
        CurrencyExchangeDto currencyExchangeDto = currencyExchangeRepository.findByFromAndTo(from, to)
                .orElseThrow(EntityNotFoundException::new).toDto();
        currencyExchangeDto.setEnvironment(port);
        return currencyExchangeDto;
    }

}
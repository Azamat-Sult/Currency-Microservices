package ru.megabank.limitsservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.megabank.limitsservice.configuration.Configuration;
import ru.megabank.limitsservice.model.Limits;

@Service
@AllArgsConstructor
public class LimitsService {

    private final Configuration configuration;
    public Limits getLimits() {
        return new Limits(configuration.getMin(),configuration.getMax());
    }

}
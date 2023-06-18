package ru.megabank.limitsservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.megabank.limitsservice.model.Limits;
import ru.megabank.limitsservice.service.LimitsService;

@RestController
@AllArgsConstructor
public class LimitsController {

    private final LimitsService limitsService;

    @GetMapping("/limits")
    public Limits getLimits() {
        return limitsService.getLimits();
    }

}
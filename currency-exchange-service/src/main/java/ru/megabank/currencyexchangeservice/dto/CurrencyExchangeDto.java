package ru.megabank.currencyexchangeservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CurrencyExchangeDto {

    public CurrencyExchangeDto(Long id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    private Long id;

    private String from;

    private String to;

    private BigDecimal conversionMultiple;

    private String environment;

}
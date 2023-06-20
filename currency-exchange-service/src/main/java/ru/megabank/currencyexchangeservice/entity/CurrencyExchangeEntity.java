package ru.megabank.currencyexchangeservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.megabank.currencyexchangeservice.dto.CurrencyExchangeDto;

import java.math.BigDecimal;

@Data
@Entity(name = "currency_exchange")
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyExchangeEntity {

    @Id
    private Long id;

    @Column(name = "currency_from")
    private String from;

    @Column(name = "currency_to")
    private String to;

    private BigDecimal conversionMultiple;

    public CurrencyExchangeDto toDto() {
        return new CurrencyExchangeDto(this.id, this.from, this.to, this.conversionMultiple);
    }

}
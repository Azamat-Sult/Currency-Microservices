package ru.megabank.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.megabank.currencyexchangeservice.entity.CurrencyExchangeEntity;

import java.util.Optional;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeEntity, Long> {

    Optional<CurrencyExchangeEntity> findByFromAndTo(String from, String to);

}
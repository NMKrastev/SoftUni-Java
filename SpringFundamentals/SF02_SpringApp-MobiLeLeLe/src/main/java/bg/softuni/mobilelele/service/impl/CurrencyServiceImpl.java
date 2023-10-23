package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.dto.ExchangeRatesDTO;
import bg.softuni.mobilelele.model.entity.ExchangeRate;
import bg.softuni.mobilelele.repository.ExchangeRateRepository;
import bg.softuni.mobilelele.service.CurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final ExchangeRateRepository exchangeRateRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyServiceImpl.class);


    public CurrencyServiceImpl(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public void refreshRates(ExchangeRatesDTO exchangeRatesDTO) {

        LOGGER.info("Exhange rates received {}", exchangeRatesDTO);

        BigDecimal BGN_TO_USD = getExchangeRate(exchangeRatesDTO, "BGN", "USD").orElse(null);
        BigDecimal BGN_TO_EUR = getExchangeRate(exchangeRatesDTO, "BGN", "EUR").orElse(null);

        if (BGN_TO_USD != null) {
            ExchangeRate exchangeRate =
                    new ExchangeRate()
                            .builder()
                            .currency("USD")
                            .rate(BGN_TO_USD)
                            .build();
            this.exchangeRateRepository.save(exchangeRate);
        } else {
            LOGGER.error("Unable to get exchange rate for BGN TO USD");
        }

        if (BGN_TO_EUR != null) {
            ExchangeRate exchangeRate =
                    new ExchangeRate()
                            .builder()
                            .currency("EUR")
                            .rate(BGN_TO_EUR)
                            .build();
            this.exchangeRateRepository.save(exchangeRate);
        } else {
            LOGGER.error("Unable to get exchange rate for BGN TO EUR");
        }

        LOGGER.info("Rates refreshed...");
    }

    private static Optional<BigDecimal> getExchangeRate(
            ExchangeRatesDTO exchangeRatesDTO,
            String from,
            String to
    ) {

        Objects.requireNonNull(from, "From currency cannot be null");
        Objects.requireNonNull(to, "To currency cannot be null");

//    {
//        "base": "USD",
//        "rates": {
//          "BGN": 1.840515,
//          "EUR": 0.937668
//    }

        // e.g. USD -> USD
        if (Objects.equals(from, to)) {
            return Optional.of(BigDecimal.ONE);
        }

        if (from.equals(exchangeRatesDTO.getBase())) {
            // e.g. USD -> BGN
            if (exchangeRatesDTO.getRates().containsKey(to)) {
                return Optional.of(exchangeRatesDTO.getRates().get(to));
            }
        } else if (Objects.equals(to, exchangeRatesDTO.getBase())){
            // e.g. BGN -> USD
            if (exchangeRatesDTO.getRates().containsKey(from)) {
                return Optional.of(BigDecimal.ONE.divide(
                        exchangeRatesDTO.getRates().get(from),
                        3,
                        RoundingMode.DOWN
                ));
            }
        } else if (exchangeRatesDTO.getRates().containsKey(from) &&
                exchangeRatesDTO.getRates().containsKey(to)) {
            return Optional.of(
                    exchangeRatesDTO.getRates().get(to)
                            .divide(exchangeRatesDTO.getRates().get(from),
                                    3, RoundingMode.DOWN)
            );
        }

        return Optional.empty();
    }
}

package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.ExchangeRatesDTO;

public interface CurrencyService {

    void refreshRates(ExchangeRatesDTO exchangeRatesDTO);
}

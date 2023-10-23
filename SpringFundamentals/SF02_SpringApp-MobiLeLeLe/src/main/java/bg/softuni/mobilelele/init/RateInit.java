package bg.softuni.mobilelele.init;

import bg.softuni.mobilelele.config.OpenExchangeRateConfig;
import bg.softuni.mobilelele.model.dto.ExchangeRatesDTO;
import bg.softuni.mobilelele.service.CurrencyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class RateInit implements CommandLineRunner {


    private final OpenExchangeRateConfig openExchangeRateConfig;
    private final RestTemplate restTemplate;
    private final CurrencyService currencyService;

    public RateInit(OpenExchangeRateConfig openExchangeRateConfig, RestTemplate restTemplate, CurrencyService currencyService) {
        this.openExchangeRateConfig = openExchangeRateConfig;
        this.restTemplate = restTemplate;
        this.currencyService = currencyService;
    }


    @Override
    public void run(String... args) throws Exception {

        if (this.openExchangeRateConfig.isEnabled()) {
            String openExchangeRateUrlTemplate =
                    this.openExchangeRateConfig.getSchema()
                            + "://"
                            + this.openExchangeRateConfig.getHost()
                            + this.openExchangeRateConfig.getPath()
                            + "?app_id={app_id}&symbols={symbols}";

            Map<String, String> requestParams = Map.of(
                    "app_id", this.openExchangeRateConfig.getAppId(),
                    "symbols", String.join(",", this.openExchangeRateConfig.getSymbols())
            );

            ExchangeRatesDTO exchangeRatesDTO = this.restTemplate
                    .getForObject(openExchangeRateUrlTemplate,
                            ExchangeRatesDTO.class,
                            requestParams
                    );

            this.currencyService.refreshRates(exchangeRatesDTO);
        }
    }
}

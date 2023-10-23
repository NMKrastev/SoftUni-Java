package bg.softuni.mobilelele.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "open.exchange.rates")
public class OpenExchangeRateConfig {

    private String appId;

    private List<String> symbols;

    private String host;

    private String schema;

    private String path;

    private boolean enabled;

    @Override
    public String toString() {
        return "OpenExchangeRateConfig{" +
                "appId='" + appId + '\'' +
                ", symbols=" + symbols +
                ", host='" + host + '\'' +
                ", schema='" + schema + '\'' +
                ", path='" + path + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}

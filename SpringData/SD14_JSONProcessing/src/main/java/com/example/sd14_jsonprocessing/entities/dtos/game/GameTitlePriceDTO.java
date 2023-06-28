package com.example.sd14_jsonprocessing.entities.dtos.game;

import java.math.BigDecimal;

public class GameTitlePriceDTO {

    private String title;
    private BigDecimal price;

    public GameTitlePriceDTO() {}

    public GameTitlePriceDTO(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

package com.example.sd13_exercisespringdataautomappingobjects.entities.dtos.game;

import org.springframework.format.datetime.DateFormatter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class GameDetailedInfoDTO {

    private String title;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;

    public GameDetailedInfoDTO() {
    }

    public GameDetailedInfoDTO(String title, BigDecimal price, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {

        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("dd-MM-yyyy"));

        final StringBuilder sb = new StringBuilder();

        sb.append(String.format("Title: %s", this.title))
                .append(System.lineSeparator())
                .append(String.format("Price: %.2f", this.price))
                .append(System.lineSeparator())
                .append(String.format("Description: %s", this.description))
                .append(System.lineSeparator())
                .append(String.format("Release date: %s", this.releaseDate.format(formatter)))
                .append(System.lineSeparator());

        return sb.toString().trim();
    }
}

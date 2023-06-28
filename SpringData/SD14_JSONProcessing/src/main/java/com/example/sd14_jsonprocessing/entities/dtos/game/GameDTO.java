package com.example.sd14_jsonprocessing.entities.dtos.game;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.example.sd14_jsonprocessing.constants.Messages.*;

public class GameDTO {

    private String title;

    private String trailerId;

    private String thumbnailUrl;

    private Double size;

    private BigDecimal price;

    private String description;

    private LocalDate releaseDate;

    public GameDTO() {
    }

    public GameDTO(String title, String trailerId, String thumbnailUrl, Double size, BigDecimal price, String description, LocalDate releaseDate) {
        this.setTitle(title);
        this.setTrailerId(trailerId);
        this.setThumbnailUrl(thumbnailUrl);
        this.setSize(size);
        this.setPrice(price);
        this.setDescription(description);
        this.setReleaseDate(releaseDate);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        if (!Character.isUpperCase(title.charAt(0)) && title.length() < 3 || title.length() > 100) {
            throw new IllegalArgumentException(INVALID_GAME_TITLE_MESSAGE);
        }

        this.title = title;
    }

    public String getTrailerId() {
        return trailerId;
    }

    public void setTrailerId(String trailerId) {

        if (trailerId.length() != 11) {
            throw new IllegalArgumentException(INVALID_GAME_TRAILER_SIZE_MESSAGE);
        }

        this.trailerId = trailerId;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {

        if (!thumbnailUrl.startsWith("http://") && !thumbnailUrl.startsWith("https://")) {
            throw new IllegalArgumentException(INVALID_THUMBNAIL_URL_MESSAGE);
        }

        this.thumbnailUrl = thumbnailUrl;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {

        if (size <= 0) {
            throw new IllegalArgumentException(INVALID_GAME_SIZE_MESSAGE);
        }

        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {

        if (price.longValue() <= 0) {
            throw new IllegalArgumentException(INVALID_GAME_PRICE_MESSAGE);
        }

        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {

        if (description.length() < 20) {
            throw new IllegalArgumentException(INVALID_DESCRIPTION_LENGTH_MESSAGE);
        }

        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}

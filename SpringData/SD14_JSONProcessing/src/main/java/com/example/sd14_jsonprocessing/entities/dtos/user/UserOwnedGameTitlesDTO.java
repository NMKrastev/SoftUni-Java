package com.example.sd14_jsonprocessing.entities.dtos.user;

public class UserOwnedGameTitlesDTO {

    private String title;

    public UserOwnedGameTitlesDTO() {
    }

    public UserOwnedGameTitlesDTO(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

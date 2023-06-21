package com.example.A2_UserSystem.models.enums;

public enum BackgroundColorType {

    BLACK("Black"),
    WHITE("White"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow"),
    BROWN("Brown"),
    PINK("Pink"),
    PURPLE("Purple");

    private String colorType;

    BackgroundColorType(String colorType) {
        this.colorType = colorType;
    }

    public String getColorType() {
        return colorType;
    }
}

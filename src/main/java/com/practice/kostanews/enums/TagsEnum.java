package com.practice.kostanews.enums;

public enum TagsEnum {
    GAMES("Игры"),
    COOK("Готовка"),
    PETS("Питомцы"),
    CARS("Машины"),
    IT("IT");

    public String nameTags;

    TagsEnum (String nameTags) {
        this.nameTags = nameTags;
    }
}

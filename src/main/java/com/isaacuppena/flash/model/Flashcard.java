package com.isaacuppena.flash.model;

import lombok.Data;

@Data
public class Flashcard {
    private String term;
    private String definition;
    private String termImageUrl;
    private String definitionImageUrl;
}

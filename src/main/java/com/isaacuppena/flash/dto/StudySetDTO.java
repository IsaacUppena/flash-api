package com.isaacuppena.flash.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isaacuppena.flash.model.Flashcard;
import lombok.Data;

import java.util.List;

@Data
public class StudySetDTO {
    private String title;
    private List<Flashcard> flashcards;
}

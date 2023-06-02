package com.isaacuppena.flash.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "studySets")
@Data
public class StudySet {

    @Id
    private ObjectId id;

    private String setId;

    private String title;

    @DocumentReference
    private User owner;

    private LocalDateTime createDate;

    private LocalDateTime lastModifiedDate;

    private List<Flashcard> flashcards;

    public StudySet(String title, User owner, List<Flashcard> flashcards) {
        this.setId = owner + "-" + title;
        this.title = title;
        this.owner = owner;
        this.createDate = LocalDateTime.now();
        this.lastModifiedDate = LocalDateTime.now();
        this.flashcards = flashcards;
    }
}

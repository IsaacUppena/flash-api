package com.isaacuppena.flash.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "studySets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudySet {
    @Id
    private ObjectId id;
    private String setId;
    private String title;
    @DocumentReference
    private User owner;
    private String createData;
    private String lastModifiedDate;
    private List<String> flashcards;

    public StudySet(String title) {
        this.title = title;
    }
}

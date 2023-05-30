package com.isaacuppena.flash.model;

import com.isaacuppena.flash.model.StudySet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private ObjectId id;
    private String username;
    private String password;
    @DocumentReference
    private List<StudySet> studySets;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

package com.isaacuppena.flash.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private ObjectId id;

    @Indexed
    private String username;

    private String password;

    private String roles;

    @DocumentReference
    private List<StudySet> studySets;

    private LocalDateTime createdDate;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.createdDate = LocalDateTime.now();
        this.roles = "ROLE_USER";
    }
}

package com.isaacuppena.flash.repository;

import com.isaacuppena.flash.model.StudySet;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudySetRepository extends MongoRepository<StudySet, ObjectId> {
    Optional<StudySet> findStudySetBySetId(String setId);
}

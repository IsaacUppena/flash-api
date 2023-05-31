package com.isaacuppena.flash.service;

import com.isaacuppena.flash.model.StudySet;
import com.isaacuppena.flash.model.User;
import com.isaacuppena.flash.repository.StudySetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudySetService {
    @Autowired
    private StudySetRepository studySetRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<StudySet> allStudySets() {
        return studySetRepository.findAll();
    }

    public Optional<StudySet> oneStudySet(String setId) {
        return studySetRepository.findStudySetBySetId(setId);
    }

    public StudySet createStudySet(String username, String title) {
        StudySet studySet = studySetRepository.insert(new StudySet(title));

        mongoTemplate.update(User.class)
                .matching(Criteria.where("username").is(username))
                .apply(new Update().push("studySetIds").value(studySet))
                .first();

        return studySet;
    }
}

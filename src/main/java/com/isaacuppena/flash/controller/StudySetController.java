package com.isaacuppena.flash.controller;

import com.isaacuppena.flash.model.StudySet;
import com.isaacuppena.flash.service.StudySetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/studySets")
public class StudySetController {
    @Autowired
    private StudySetService studySetService;

    @GetMapping
    public ResponseEntity<List<StudySet>> getAllStudySets() {
        return new ResponseEntity<List<StudySet>>(studySetService.allStudySets(), HttpStatus.OK);
    }

    @GetMapping("/{setId}")
    public ResponseEntity<Optional<StudySet>> getOneStudySet(@PathVariable String setId) {
        return new ResponseEntity<Optional<StudySet>>(studySetService.oneStudySet(setId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudySet> createStudySet(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<StudySet>(studySetService.createStudySet(payload.get("userName"), payload.get("title")), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<StudySet> updateStudySet(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<StudySet>(studySetService.createStudySet(payload.get("userName"), payload.get("title")), HttpStatus.CREATED);
    }
}

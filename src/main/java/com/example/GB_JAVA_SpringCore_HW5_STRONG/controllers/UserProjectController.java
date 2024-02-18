package com.example.GB_JAVA_SpringCore_HW5_STRONG.controllers;

import com.example.GB_JAVA_SpringCore_HW5_STRONG.models.Project;
import com.example.GB_JAVA_SpringCore_HW5_STRONG.models.User;
import com.example.GB_JAVA_SpringCore_HW5_STRONG.services.UserProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserProjectController {
    @Autowired
    private UserProjectService userProjectService;

    @GetMapping("/users/{projectId}")
    public ResponseEntity<List<User>> getUsersByProjectId(@PathVariable Long projectId) {
        List<User> users = userProjectService.getUsersByProjectId(projectId);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/projects/{userId}")
    public ResponseEntity<List<Project>> getProjectsByUserId(@PathVariable Long userId) {
        List<Project> projects = userProjectService.getProjectsByUserId(userId);
        return ResponseEntity.ok(projects);
    }

    @PostMapping("/addUserToProject")
    public ResponseEntity addUserToProject(@RequestParam Long userId, @RequestParam Long projectId) {
        userProjectService.addUserToProject(userId, projectId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/removeUserFromProject")
    public ResponseEntity removeUserFromProject(@RequestParam Long userId, @RequestParam Long projectId) {
        userProjectService.removeUserFromProject(userId, projectId);
        return ResponseEntity.ok().build();
    }
}

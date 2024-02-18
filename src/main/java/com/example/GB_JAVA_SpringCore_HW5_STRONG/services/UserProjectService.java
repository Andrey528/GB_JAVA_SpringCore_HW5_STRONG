package com.example.GB_JAVA_SpringCore_HW5_STRONG.services;

import com.example.GB_JAVA_SpringCore_HW5_STRONG.models.Project;
import com.example.GB_JAVA_SpringCore_HW5_STRONG.models.User;
import com.example.GB_JAVA_SpringCore_HW5_STRONG.models.UsersProject;
import com.example.GB_JAVA_SpringCore_HW5_STRONG.repository.ProjectRepository;
import com.example.GB_JAVA_SpringCore_HW5_STRONG.repository.UserRepository;
import com.example.GB_JAVA_SpringCore_HW5_STRONG.repository.UsersProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProjectService {
    @Autowired
    private UsersProjectRepository usersProjectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public List<User> getUsersByProjectId(Long projectId) { // метод, возвращающий список пользователей, связанных с определенным проектом
        List<UsersProject> usersProjects = usersProjectRepository.findByProjectId(projectId);
        List<User> users = new ArrayList<>();
        usersProjects.forEach(up -> {
            User user = userRepository.findById(up.getUserId()).orElse(null);
            if(user != null) {
                users.add(user);
            }
        });
        return users;
    }
    public List getProjectsByUserId(Long userId) { // метод, возвращающий список проектов, связанных с определенным пользователем
        List<UsersProject> usersProjects = usersProjectRepository.findByUserId(userId);
        List<Project> projects = new ArrayList<>();
        usersProjects.forEach(up -> {
            Project project = projectRepository.findById(up.getProjectId()).orElse(null);
            if(project != null) {
                projects.add(project);
            }
        });
        return projects;
    }
    public void addUserToProject(Long userId, Long projectId) { // метод, добавляющий пользователя к проекту
        UsersProject usersProject = new UsersProject();
        usersProject.setUserId(userId);
        usersProject.setProjectId(projectId);
        usersProjectRepository.save(usersProject);
    }
    public void removeUserFromProject(Long userId, Long projectId) { // метод, удаляющий пользователя из проекта
        usersProjectRepository.deleteByUserIdAndProjectId(userId, projectId);
    }
}

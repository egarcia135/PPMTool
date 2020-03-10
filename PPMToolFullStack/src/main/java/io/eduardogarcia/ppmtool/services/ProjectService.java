package io.eduardogarcia.ppmtool.services;

import io.eduardogarcia.ppmtool.domain.Backlog;
import io.eduardogarcia.ppmtool.domain.Project;
import io.eduardogarcia.ppmtool.domain.User;
import io.eduardogarcia.ppmtool.exceptions.ProjectIdException;
import io.eduardogarcia.ppmtool.exceptions.ProjectNotFoundException;
import io.eduardogarcia.ppmtool.repositories.BacklogRepository;
import io.eduardogarcia.ppmtool.repositories.ProjectRepository;
import io.eduardogarcia.ppmtool.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private UserRepository userRepository;

    public Project saveOrUpdateProject(Project project, String username) {
       try {

           User user = userRepository.findByUsername(username);
           project.setUser(user);
           project.setProjectLeader(user.getUsername());


           project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
           if(project.getId() == null) {
               Backlog backlog = new Backlog();
               project.setBacklog(backlog);
               backlog.setProject(project);
               backlog.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
           }
           if(project.getId() != null) {
               project.setBacklog(backlogRepository.findByProjectIdentifier(project.getProjectIdentifier().toUpperCase()));
           }
           return projectRepository.save(project);
       } catch (Exception e){
           throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+ "' already exists.");
       }
    }

    public Project findProjectByIdentifier(String projectId, String username){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project == null) {
            throw new ProjectIdException("Project ID '"+projectId+"' does not exists.");
        }
        if(!project.getProjectLeader().equals(username)) {
            throw new ProjectNotFoundException("Project not found in your account");
        }





        return project;
    }

    public Iterable<Project> findAllProjects(String username) {
        return projectRepository.findAllByprojectLeader(username);
    }


    public void deleteProjectbyIdentifier(String projectId, String username){

        projectRepository.delete(findProjectByIdentifier(projectId, username));
    }






}

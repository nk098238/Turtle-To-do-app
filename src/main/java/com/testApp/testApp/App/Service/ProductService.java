package com.testApp.testApp.App.Service;


import com.testApp.testApp.App.Data.ItemsContainer;
import com.testApp.testApp.App.Entity.Admin;
import com.testApp.testApp.App.Entity.SubTasks;
import com.testApp.testApp.App.Entity.Tasks;
import com.testApp.testApp.App.Entity.User;
import com.testApp.testApp.App.Model.Products;
import com.testApp.testApp.App.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private TasksRepository taskRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private SubTaskRepository subTasksrepo;


   public void registerUser(Admin admin){

            admin.setPassword(admin.getPassword());

       adminRepo.save(admin);

   }

   public String deleteTasks(Integer id){
       taskRepo.deleteById(id);
       Optional<Tasks> task = taskRepo.findById(id);
       if(task.isEmpty()){
           return "SUCCESS";
       }
       return "FAILURE";


   }

   public ItemsContainer getTaksDetails(String username){
       if(!username.isEmpty()) {

           Optional<User> user = userRepo.findByUsername(username);

           if(user.isPresent()) {
               List<Tasks> activeTasks = taskRepo.findByFkUserId(user.get().getId());

               int size = activeTasks.size();

               return new ItemsContainer(activeTasks, size);
           }
       }
           return null;

   }

   public String saveTaskDetails(Tasks tasks){

       String username = userService.getSessionInfo();
        if(!Objects.isNull(tasks) && !username.isEmpty()){
            Optional<User> user = userRepo.findByUsername(username);
            if(user.isPresent()) {
                tasks.setFkUserId(user.get().getId());
                taskRepo.save(tasks);
                return "SUCCESS";
            }
        }

        return "FAILURE";
   }

   public String saveSubTaskDetails(SubTasks subTasks){

       try {
           SubTasks savedSubTask = subTasksrepo.save(subTasks);
           return "SUCCESS";
       }catch (Exception e){
           return "FAILURE";
       }

   }


   public List<SubTasks> getSubTasksDetails(Integer taskId){
      return  subTasksrepo.findByFkTaskId(taskId);
   }



}

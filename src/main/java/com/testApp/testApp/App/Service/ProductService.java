package com.testApp.testApp.App.Service;


import com.testApp.testApp.App.Data.ItemsContainer;
import com.testApp.testApp.App.Entity.*;
import com.testApp.testApp.App.Model.Products;
import com.testApp.testApp.App.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

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

    @Autowired
    private ModuleRepository moduleRepo;


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
       logger.info("inside getTasksDetails");
       if(!username.isEmpty()) {

           Optional<User> user = userRepo.findByUsername(username);

           if(user.isPresent()) {
               logger.info("user is present");
               List<Tasks> activeTasks = taskRepo.findByFkUserId(user.get().getId());

               int size = activeTasks.size();

               logger.info("no of active task :"+ size);

               return new ItemsContainer(activeTasks, size);
           }
       }
           logger.info("no active task found");
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

   public List<Modules> getModuleDetails(Integer fkSubTaskId){
       return moduleRepo.findByFkSubTaskId(fkSubTaskId);
   }

   public String saveModule(Modules module){
       try {
           Modules modules = moduleRepo.save(module);
           return "SUCCESS";
       }catch (Exception e){
           return "FAILURE";
       }
   }

   public String logEffort(Map<String,Integer> obj){
       
       if(obj != null && obj.get("timeLogged") != null && obj.get("moduleId") != null) {
           Integer timeLogged = obj.get("timeLogged");
           Integer moduleId = obj.get("moduleId");
          int result = moduleRepo.updateTimeLoggedByModuleId(moduleId,timeLogged);
          if(result > 0 ){
              return "SUCCESS";
          }
       }
           return "FAILURE";

   }

   public String    crateUser(User user){
       if(!user.toString().isEmpty()){
           User result = userRepo.save(user);
           if(result.getId()!=null){
               return "SUCCESS";
           }

       }
       return "FAILURE";
   }



}

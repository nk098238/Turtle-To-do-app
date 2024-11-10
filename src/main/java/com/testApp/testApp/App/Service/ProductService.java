package com.testApp.testApp.App.Service;


import com.testApp.testApp.App.Data.ItemsContainer;
import com.testApp.testApp.App.Entity.Admin;
import com.testApp.testApp.App.Entity.Tasks;
import com.testApp.testApp.App.Model.Products;
import com.testApp.testApp.App.Repository.AdminRepository;
import com.testApp.testApp.App.Repository.LaptopRepository;
import com.testApp.testApp.App.Repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private TasksRepository taskRepo;



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

   public ItemsContainer getTaksDetails(){

       List<Tasks> tasks = taskRepo.findAll();
       int size = tasks.size();

       return new ItemsContainer(tasks,size);
   }

   public String saveTaskDetails(Tasks tasks){
        if(!Objects.isNull(tasks)){
            taskRepo.save(tasks);
            return "SUCCESS";
        }

        return "FAILURE";
   }



}

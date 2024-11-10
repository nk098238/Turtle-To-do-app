package com.testApp.testApp.App.Controller;


import com.testApp.testApp.App.Data.ItemsContainer;
import com.testApp.testApp.App.Entity.Admin;
import com.testApp.testApp.App.Entity.Laptop;
import com.testApp.testApp.App.Entity.Tasks;
import com.testApp.testApp.App.Entity.User;
import com.testApp.testApp.App.Model.Products;
import com.testApp.testApp.App.Repository.AdminRepository;
import com.testApp.testApp.App.Repository.LaptopRepository;
import com.testApp.testApp.App.Repository.UserRepository;
import com.testApp.testApp.App.Service.ProductService;
import com.testApp.testApp.App.Service.UserDetailService;
import com.testApp.testApp.App.Service.UserService;
import com.testApp.testApp.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
@RestController
public class Controller {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private LaptopRepository repo;

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private Computer cmp;


    @PostMapping("/login")
    public String validateUser(@RequestBody User user){
         return  userService.ValidateUser(user);
    }


    @GetMapping("/getTaskDetails")
    public ItemsContainer getData(){
        return  productService.getTaksDetails();
    }

    @GetMapping("/deleteTaskDetails/{id}")
    public String deleteTasks(@PathVariable("id") Integer id){
        return productService.deleteTasks(id);
    }

    @PostMapping("/saveTaskDetails")
    public String savetaskdetails(@RequestBody Tasks tasks){
        return productService.saveTaskDetails(tasks);
    }



    @RequestMapping("/getLaptopDetails")
    public List<Laptop> about(){
        return repo.findAll();
    }

    @PostMapping("/addLaptop")
    public ResponseEntity<String> addLaptop(@RequestBody Laptop laptop){
        repo.save(laptop);
        return new ResponseEntity<String>("Successfully added", null, HttpStatus. OK);
    }


    @PostMapping("delete/{id}")
    public void deleteLaptop(@PathVariable Integer id) {
        repo.deleteById(id);
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody Admin admin){
        productService.registerUser(admin);
        return "success";
    }





}

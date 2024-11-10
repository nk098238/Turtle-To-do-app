package com.testApp.testApp.App.Repository;

import com.testApp.testApp.App.Entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LaptopRepository extends JpaRepository<Laptop,Integer> {

}

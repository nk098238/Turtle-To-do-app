package com.testApp.testApp.App.Repository;

import com.testApp.testApp.App.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepository extends JpaRepository<Admin,Integer> {
}

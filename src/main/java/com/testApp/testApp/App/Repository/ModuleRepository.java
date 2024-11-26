package com.testApp.testApp.App.Repository;

import com.testApp.testApp.App.Entity.Modules;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository< Modules,Integer> {

    List<Modules> findByFkSubTaskId(Integer fkSubTaskId);
}

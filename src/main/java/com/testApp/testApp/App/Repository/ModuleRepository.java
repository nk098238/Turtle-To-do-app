package com.testApp.testApp.App.Repository;

import com.testApp.testApp.App.Entity.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ModuleRepository extends JpaRepository< Modules,Integer> {

    List<Modules> findByFkSubTaskId(Integer fkSubTaskId);

    @Modifying
    @Transactional
    @Query("UPDATE Modules m SET m.TimeLogged = :timeLogged WHERE m.Id = :moduleId")
    int updateTimeLoggedByModuleId(Integer moduleId, Integer timeLogged);
}

package com.testApp.testApp.App.Repository;

import com.testApp.testApp.App.Entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TasksRepository extends JpaRepository<Tasks,Integer> {

    List<Tasks> findByFkUserId(Long fkUserId);
}

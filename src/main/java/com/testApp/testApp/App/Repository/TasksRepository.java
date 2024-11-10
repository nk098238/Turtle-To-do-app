package com.testApp.testApp.App.Repository;

import com.testApp.testApp.App.Entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Tasks,Integer> {
}

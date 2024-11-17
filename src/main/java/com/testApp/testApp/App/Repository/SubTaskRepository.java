package com.testApp.testApp.App.Repository;

import com.testApp.testApp.App.Entity.SubTasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubTaskRepository extends JpaRepository<SubTasks,Integer> {

    List<SubTasks> findByFkTaskId(Integer taskId);
}

package com.testApp.testApp.App.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sub_tasks")
public class SubTasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sub_task_id")
    private Integer subTaskId;

    @Column(name = "fk_task_id")
    private Integer fkTaskId;

    @Column(name = "sub_task_name")
    private String subTaskName;

    @Column(name="sub_task_desc")
    private String subTaskDesc;

    @Column(name = "total_estimated_time")
    private Integer totalEstimatedTime;

    @Column(name = "priority")
    private String priority;

    @Column(name= "created_by")
    private String createdBy;


}

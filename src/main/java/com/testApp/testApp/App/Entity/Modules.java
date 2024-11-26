package com.testApp.testApp.App.Entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "modules")
@AllArgsConstructor
@NoArgsConstructor
public class Modules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module_id")
    public Integer Id;

    @Column(name = "fk_sub_task_id")
    public Integer fkSubTaskId;

    @Column(name = "module_name")
    public String moduleName;

    @Column(name= "total_estimated")
    public Integer totalEstimated;

    @Column(name = "total_estimated_unit")
    public String totalEstimatedUnit;

    @Column(name= "time_logged")
    public Integer TimeLogged;

    @Column(name=  "created_by")
    public String createdBy;

}

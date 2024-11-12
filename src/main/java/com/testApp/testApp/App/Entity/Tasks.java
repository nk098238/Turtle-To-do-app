package com.testApp.testApp.App.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int taskId;

    @Column(name="task_name")
    private String taskName;

    @Column(name = "task_desc")
    private String taskDesc;

    @Column(name="task_img_path")
        private String taskImgPath;

    @Column(name="created_by")
    private String createdBy;

    public Long getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(Long fkUserId) {
        this.fkUserId = fkUserId;
    }

    @Column(name="fk_user_id")
    private Long fkUserId;


}

package com.testApp.testApp.App.Data;

import com.testApp.testApp.App.Entity.Tasks;

import java.util.List;

public class ItemsContainer {

    public List<Tasks> tasks ;
    public Integer size;

    public ItemsContainer(List<Tasks> tasks, Integer size){
        this.size = size;
        this.tasks = tasks;
    }
}

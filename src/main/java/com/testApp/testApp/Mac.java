package com.testApp.testApp;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Mac implements  Computer{
    @Override
    public void display() {
        System.out.println("This is mac book");
    }
}

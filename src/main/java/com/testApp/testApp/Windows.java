package com.testApp.testApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("windows")
@Primary
public class Windows implements Computer{



    @Override
    public void display() {
        System.out.println("This is windows ");
    }


}

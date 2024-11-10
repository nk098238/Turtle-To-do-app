package com.testApp.testApp.App.Model;


import org.springframework.stereotype.Component;

@Component
public class Products {

    private int prodId;
    private String Name;
    private int price;

    public int getProdId() {
        return prodId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Products(){}

    public Products(int prodId, String name, int price) {
        this.prodId = prodId;
        Name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }
}

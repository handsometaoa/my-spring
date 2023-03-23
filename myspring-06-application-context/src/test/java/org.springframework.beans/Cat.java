package org.springframework.beans;


import lombok.Data;

@Data
public class Cat {
    String name;

    public Cat(){

    }

    public Cat(String name) {
        this.name = name;
    }

}

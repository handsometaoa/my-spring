package org.springframework.beans;


import lombok.Data;

@Data
public class Person {
    private String name;
    private Integer age;

    private Cat cat;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("我爱中国！");
    }
}

package fr.bracchi.myApi.controller;

public class UserRequest {
    private String name;
    private Integer age;

    public UserRequest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }   
}

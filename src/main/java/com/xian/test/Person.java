package com.xian.test;

public class Person {
    private String name;
    private int age;

    public String a;
    String b;

    public void eat(){
        System.out.println(this.name+" is eating!");
    }

    public void eat(String food){
        System.out.println(this.name+" is eating "+food+" !");
    }

    public void sleep(){
        System.out.println(this.name+" is sleeping!");
    }

    public void game(){
        System.out.println(this.name+" is gaming!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}

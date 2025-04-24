package models;

public class Person {
    //Declara los atributos
    private String name;
    private int age;

    public Person(String name, int age) {//Constructor
        this.name = name;
        this.age = age;
    }
    //Inicia con los gets and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //Imprime mostrando el nombre y la edad

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

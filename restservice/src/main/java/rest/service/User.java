package rest.service;

import javax.jws.soap.SOAPBinding;
import java.util.Objects;

public class User {
    private String name;
    private int age;
    private int id;



    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                name.equals(user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, id);
    }

    public String getName() {

        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {

        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }



}
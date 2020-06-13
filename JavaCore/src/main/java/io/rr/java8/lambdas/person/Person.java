package io.rr.java8.lambdas.person;

import java.time.LocalDate;

/**
 * @author romanr on 2/16/2017.
 */
public class Person {
    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        return (LocalDate.now().getYear() - birthday.getYear());
    }

    public void printPerson() {
        System.out.println(toString());
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + getAge() +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}

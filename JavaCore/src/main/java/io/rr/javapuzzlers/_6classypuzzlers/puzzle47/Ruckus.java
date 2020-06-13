package io.rr.javapuzzlers._6classypuzzlers.puzzle47;

class Counter {
    private static int count = 0;
    public static final synchronized void increment() {
        count++;
    }
    public static final synchronized int getCount() {
        return count; 
    } 
}

class Dog /*extends Counter*/ {
    //fix
    private static int count = 0;
    public Dog() { }

    public static int getCount() {
        return count;
    }

    public void woof() { /*increment();*/ count++;}
} 

class Cat /*extends Counter*/ {

    private static int count = 0;
    public Cat() { }

    public static int getCount() {
        return count;
    }

    public void meow() { /*increment();*/ count++;}
}

public class Ruckus {
    private static int count;

    public static void main(String[] args) {
        Dog dogs[] = {new Dog(), new Dog()};
        for (int i = 0; i < dogs.length; i++)
            dogs[i].woof();
        Cat cats[] = {new Cat(), new Cat(), new Cat()};
        for (int i = 0; i < cats.length; i++)
            cats[i].meow();
        System.out.print(Dog.getCount() + " woofs and ");
        System.out.println(Cat.getCount() + " meows");
    }
}

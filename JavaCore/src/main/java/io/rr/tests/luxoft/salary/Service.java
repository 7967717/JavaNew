package io.rr.tests.luxoft.salary;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Service {

    public static void main(String[] args) {

        Department sales = new Department("Sales");
        Department finance = new Department("Finance");
        Department management = new Department("Management");

        Employee john = new Employee("John", 123, sales);
        Employee alex = new Employee("Alex", 345, sales);
        Employee sara = new Employee("Sara", 678, finance);
        Employee bob = new Employee("Bob", 901, finance);
        Employee jena = new Employee("Jena", 234, management);
        Employee liz = new Employee("Liz", 517, management);

        List<Employee> employees = List.of(john, sara, alex, bob, jena, liz);

//        ArrayList list0 = new ArrayList<Employee>();
//        list0.add(john);
//        list0.add(alex);
//        ArrayList list1 = new ArrayList<Employee>();
//        list1.add(sara);
//        list1.add(bob);
//        ArrayList list2 = new ArrayList<Employee>();
//        list2.add(jena);
//        list2.add(liz);

        calculateHighestSalary(employees);
        System.out.println("----------------");
        calculateHighestSalary2(employees);

    }

    private static void calculateHighestSalary(List<Employee> employees) {
        Set<Department> departments = employees.stream().map(Employee::getDepartment)
                .collect(Collectors.toSet());
        for (Department department : departments) {
            var result = employees.stream()
                    .filter(employee -> employee.getDepartment().equals(department))
                    .map(Employee::getSalary).max(Integer::compareTo)
                    .orElseThrow(() -> new IllegalArgumentException("Could not find salary"));
            System.out.println(department + ": " + result);
        }
    }

    private static void calculateHighestSalary1(List<Employee> employees) {
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toSet()))
                .forEach((department, empl) -> System.out.println(department + ": " + empl.stream()
                        .map(Employee::getSalary)
                        .max(Integer::compareTo).orElseThrow(() -> new IllegalArgumentException("Could not find salary"))));

    }

    private static void calculateHighestSalary2(List<Employee> employees) {
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
                .forEach((department, empl) -> System.out.println(department + ": " + empl.map(Employee::getSalary)
                        .orElseThrow(() -> new IllegalArgumentException("Could not find salary"))));

    }
}

package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] words = {"Jack", "John", "Michael", "Gary", "Tom", "Michael", "Tom", "John", "Michael", "Gary", "Tom"};

        Map.Entry<String, Long> key = Arrays.stream(words)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue)).orElseThrow();

        System.out.println("Максимальное кол-во совпадающего имени:  " + key);

        Employee[] employees = {
                new Employee("Bill", 25, 3000),
                new Employee("John", 20, 2000),
                new Employee("Elena", 39, 3500),
                new Employee("Joe", 19, 3500),
                new Employee("Donald", 29, 3500)};

        double average = Arrays.stream(employees)
                .mapToInt(Employee::getSalary)
                .average()
                .orElseThrow();

        System.out.println("средняя зарплата по всем работникам: " + average);

        String names = Arrays.stream(employees)
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .limit(3)
                .map(employee -> employee.name + " - " + employee.age + " лет\n ")
                .collect(Collectors.joining());
        
        System.out.println("3 самых старших сотрудников зовут:\n " + names);


    }

    static class Employee {
        private final String name;
        private final int age;
        private final int salary;

        public Employee(String name, int age, int salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public int getSalary() {
            return salary;
        }

        public int getAge() {
            return age;
        }


        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }
    }
}
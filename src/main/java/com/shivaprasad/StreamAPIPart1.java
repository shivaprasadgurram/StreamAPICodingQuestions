package com.shivaprasad;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPIPart1 {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));


        //Question-1
        //How many male and female employees are there in the organization?
        Map<String, Long> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getEmp_gender, Collectors.counting()));
        System.out.println("Number of male and female employees: " +map);

        //Question-2
        //Print all the unique department names in the organization
        Set<String> set = employeeList.stream().map(emp -> emp.getEmp_dept()).collect(Collectors.toSet());
        System.out.println("Unique Department names: " +set);

        //Question-3
        //Get the details of highest paid employee in the organization
        Optional<Employee> emp = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getEmp_salary)));
        System.out.println("Highest paid employee:  " + emp);

        //Question-4
        //Get the names of all employees who have joined after 2015
        List<String> empNames =  employeeList.stream().filter(emp1 -> emp1.getEmp_doj() > 2015).map(Employee::getEmp_name).collect(Collectors.toList());
        System.out.println("Employee names who joined after 2015: "+ empNames);

        //Question-5
        //Who has the most working experience in the organization?
        Optional<Employee> empMostExp =  employeeList.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getEmp_doj)));
        System.out.println("Most exp emp: " +empMostExp);
    }
}

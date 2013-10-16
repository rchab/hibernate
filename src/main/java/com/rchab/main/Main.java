package com.rchab.main;

import com.rchab.entity.Employee;
import com.rchab.repository.EmployeeRepository;
import com.rchab.utils.SessionFactoryUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeRepository.setFactory(SessionFactoryUtils.getSessionFactory());

        //        Add new employee
        Employee employee = new Employee("Vasyl", "Petrenko", 150);
        Integer addId = EmployeeRepository.addEmployee(employee);

        //        update existing employee
        employee.setId(3);
        employee.setFirstName("Mykola");
        employee.setSalery(350);
        EmployeeRepository.updateEmployee(employee);

        //      List all employee
        List<Employee> employeeList = EmployeeRepository.listEmployees();
        for (Employee emp: employeeList ){
            System.out.println(emp);
        }

        //        find by FirstName
        List<Employee> employees = EmployeeRepository.findByFirstName("Vasyl");
        System.out.println("Search by name: ");
        for (Employee emp: employees){
            System.out.println(emp);
        }

        //        delete employee
        employee.setId(addId);
        EmployeeRepository.deleteEmployee(employee);

        SessionFactoryUtils.shutdown();
    }
}
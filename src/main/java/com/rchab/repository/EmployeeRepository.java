package com.rchab.repository;

import com.rchab.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeRepository {

    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        return factory;
    }

    public static void setFactory(SessionFactory factory) {
        EmployeeRepository.factory = factory;
    }

    public static Integer addEmployee (Employee employee){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeId = null;
        try {
            tx = session.beginTransaction();
            employeeId = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException he){
            if(tx != null){
                tx.rollback();
            }
            System.out.println(he.getMessage());
        }
        session.close();
        return employeeId;
    }

    public static void updateEmployee(Employee employee){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(employee);
            tx.commit();
        } catch (HibernateException he){
            if(tx != null){
                tx.rollback();
            }
            System.out.println(he.getMessage());
        }
        session.close();
    }

    public static List<Employee> listEmployees(){
        Session session = factory.openSession();
        List<Employee> employeeList = null;
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            employeeList = session.createQuery("From Employee").list();
            tx.commit();
        } catch (HibernateException he){
            if(tx != null){
                tx.rollback();
            }
            System.out.println(he.getMessage());
        }
        session.close();
        return employeeList;
    }

    public static void deleteEmployee(Employee employee){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(employee);
            tx.commit();
        } catch (HibernateException he){
            if(tx != null){
                tx.rollback();
            }
            System.out.println(he.getMessage());
        }
        session.close();
    }
}

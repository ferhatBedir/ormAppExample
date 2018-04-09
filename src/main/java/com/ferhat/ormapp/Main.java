package com.ferhat.ormapp;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            String sql = "Select e from" + Employee.class.getName() + "e" + "order by e.empName, e.empNo";
            Query<Employee> query = session.createQuery(sql);

            List<Employee> emloyees = query.getResultList();

            for (Employee emp : emloyees) {
                System.out.println("Emp: " + emp.getEmpName() + ":" + emp.getEmpName());

                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }


    }
}

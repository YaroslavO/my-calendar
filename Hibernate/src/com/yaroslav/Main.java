package com.yaroslav;

import com.yaroslav.entity.Student;
import com.yaroslav.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by employee on 5/27/15.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        HibernateUtil hibernateUtil = new HibernateUtil();

        Session session = hibernateUtil.getSession();

        Transaction transaction = session.beginTransaction();
        Student student = new Student();
        student.setFirstName("Yaroslav");
        student.setLastName("Olenenko");
        student.setMark(5.0);

        session.save(student);
        transaction.commit();

        hibernateUtil = new HibernateUtil();
        session = hibernateUtil.getSession();

        transaction = session.beginTransaction();
        Student surveyInSession = (Student) session.get(Student.class, student.getId());
        transaction.commit();

    }
}

package com.yaroslav;

import com.yaroslav.entitys.Student;
import com.yaroslav.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by employee on 5/27/15.
 */

public class StudentDao {
    private static HibernateUtil hibernateUtil = new HibernateUtil();

    public void saveStudent(Student student) {
        Session session = null;
        try {
            session = hibernateUtil.getSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSessionIsOpen(session);
        }
    }

    private void closeSessionIsOpen(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public Student getStudentById(int id) {
        Session session = null;
        Student student = null;
        try {
            session = hibernateUtil.getSession();
            student = (Student) session.get(Student.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSessionIsOpen(session);
        }
        return student;
    }

    public List<Student> getAllStudent() {
        Session session = null;
        List students = new ArrayList<Student>();
        try {
            session = hibernateUtil.getSession();
            students = session.createCriteria(Student.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSessionIsOpen(session);
        }
        return students;
    }

    public void updateStudent(Student student) {
        Session session = null;
        try {
            session = hibernateUtil.getSession();
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSessionIsOpen(session);
        }
    }
}

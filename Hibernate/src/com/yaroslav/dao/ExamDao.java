package com.yaroslav.dao;

import com.yaroslav.entitys.Exam;
import com.yaroslav.util.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by employee on 5/27/15.
 */
public class ExamDao {
    private static HibernateUtil hibernateUtil = new HibernateUtil();

    private void closeSessionIsOpen(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public void saveExam(Exam exam) {
        Session session = null;
        try {
            session = hibernateUtil.getSession();
            session.beginTransaction();
            session.save(exam);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSessionIsOpen(session);
        }
    }
}

package com.yaroslav;

import com.yaroslav.dao.ExamDao;
import com.yaroslav.dao.StudentDao;
import com.yaroslav.entitys.Exam;
import com.yaroslav.entitys.Student;
import com.yaroslav.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by employee on 5/27/15.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        StudentDao studentDao = new StudentDao();

        List<Exam> examinationsForStudents = createAllExam();

        Student student = createStudent("Yaroslav", "Olenenko");
        studentDao.saveStudent(student);
        getResultExamPeriodForStudent(student, examinationsForStudents);

        student = createStudent("Dimmu", "Smagloc");
        studentDao.saveStudent(student);
        getResultExamPeriodForStudent(student, examinationsForStudents);

        student = createStudent("Vladislav", "Kirilenko");
        studentDao.saveStudent(student);
        getResultExamPeriodForStudent(student, examinationsForStudents);

        List<Student> students = studentDao.getAllStudent();

        for (Student eachStudent: students) {
            System.out.println(eachStudent);
        }

        HibernateUtil.close();
    }

    private static List<Exam> createAllExam() {
        List<Exam> examinationsForStudents = new ArrayList<Exam>();
        Exam exam = createExam("History");
        examinationsForStudents.add(exam);

        exam = createExam("English");
        examinationsForStudents.add(exam);

        exam = createExam("Biology");
        examinationsForStudents.add(exam);

        exam = createExam("Save work");
        examinationsForStudents.add(exam);

        return examinationsForStudents;
    }

    private static void getResultExamPeriodForStudent(Student student, List<Exam> exams) {
        ExamDao examDao = new ExamDao();

        for (Exam exam: exams) {
            Exam newExam = new Exam();
            newExam.setTitle(exam.getTitle());
            newExam.setStudent(student);
            newExam.setRating(5 - new Random().nextInt(3));
            examDao.saveExam(newExam);
        }
    }

    public static Exam createExam(String title) {
        Exam exam = new Exam();
        exam.setTitle(title);
        return exam;
    }

    public static Student createStudent(String firstName, String lastName) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        return student;
    }
}

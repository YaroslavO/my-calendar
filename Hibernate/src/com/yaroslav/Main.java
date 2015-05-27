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

        Student student = createStudent("Yaroslav", "Olenenko");
        studentDao.saveStudent(student);

        student = createStudent("Dimmu", "Smagloc");
        studentDao.saveStudent(student);

        student = createStudent("Vladislav", "Kirilenko");
        studentDao.saveStudent(student);

        List<Exam> examinationsForStudents = createAllExam();

        List<Student> students = studentDao.getAllStudent();

        for (Student eachStudent: students) {
            getResultSessionForStudent(examinationsForStudents, eachStudent);
        }

        students = studentDao.getAllStudent();

        for (Student eachStudent: students) {
            List<Exam> studentExams = new ArrayList<Exam>(eachStudent.getExams());
            eachStudent.setMark(getAverageMark(studentExams));
            System.out.println(eachStudent);
        }

        HibernateUtil.close();
    }

    public static double getAverageMark(List<Exam> exams) {
        double sum = 0.0;

        for (Exam exam: exams) {
            sum += exam.getRating();
        }

        return sum / (exams.size() * 1.0);
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

    private static void getResultSessionForStudent(List<Exam> exams, Student student) {
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

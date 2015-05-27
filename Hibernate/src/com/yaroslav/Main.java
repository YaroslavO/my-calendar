package com.yaroslav;

import com.yaroslav.entitys.Exam;
import com.yaroslav.entitys.Student;

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
            List<Exam> exams = getResultSessionForStudent(examinationsForStudents);
            eachStudent.setExams(exams);
            eachStudent.setMark(getAverageMark(exams));
            studentDao.updateStudent(eachStudent);
        }

        students = studentDao.getAllStudent();

        for (Student eachStudent: students) {
            System.out.println(eachStudent);
        }
    }

    public static double getAverageMark(List<Exam> exams) {
        double sum = 0.0;

        for (Exam exam: exams) {
            sum += exam.getRating();
        }

        return sum / exams.size();
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

    private static List<Exam> getResultSessionForStudent(List<Exam> exams) {
        for (Exam exam: exams) {
            exam.setRating(5 - new Random().nextInt(3));
        }
        return new ArrayList<Exam>(exams);
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

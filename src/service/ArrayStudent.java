package service;

import fact.Student;
import fact.service.Examine;
import service.FileStudent;
import java.io.IOException;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class ArrayStudent {

    private static final int MAX_STUDENTS = 200;
    public static Student[] students = new Student[MAX_STUDENTS];
    public static int studentCount = 0;

    public static void createStudent(int id, String name, LocalDate birthDate, String address, double height, double weight, String studentCode, String university, int startYear, double gpa){
        if(studentCount < MAX_STUDENTS){
            Student newStudent = new Student(id, name, birthDate, address, height, weight, studentCode, university, startYear, gpa);
            students[studentCount++] = newStudent;
            System.out.println("Student has been successfully added : " + "\n" + newStudent);
        }
        else {
            System.out.println("Cannot add Students");
        }
    }

    public static Student findStudent(int id){
        for(int i = 0; i < studentCount; i++){
            if(students[i].getID() == id){
                return students[i];
            }
        }
        System.out.println("No student found with ID: " + id);
        return null;
    }
    public static void updateStudent(int update) throws ParseException {
        Student student = ArrayStudent.findStudent(update);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your choice : ");
        int input = scanner.nextInt();
        switch ((input)){
            case 1:
                String name = Examine.ExamineName();
                student.setName(name);
                break;
            case 2:
                LocalDate birthDate = Examine.ExamineBirthday();
                student.setBirthDay(birthDate);
                break;
            case 3:
                String address =  Examine.ExamineAddress();
                student.setAddress(address);
                break;
            case 4:
                double height = Examine.ExamineHeight();
                student.setHeight(height);
                break;
            case 5:
                double weight =  Examine.ExamineWeight();
                scanner.nextLine();
                student.setWeight(weight);
                break;
            case 6:
                String studentCode = Examine.ExamineStudentCode();
                student.setStudentCode(studentCode);
                break;
            case 7:
                String university = Examine.ExamineUniversity();
                student.setUniversity(university);
                break;
            case 8:
                int startYear = Examine.ExamineStartYear();
                student.setStartYear(startYear);
                break;
            case 9:
                double gpa = Examine.ExamineGPA();
                student.setGPA(gpa);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
        System.out.println("Students were successfully Updated " + student);
    }

    public static void deleteStudent(int id){
        for(int i = 0; i < studentCount; i++){
            if(students[i].getID() == id){
                for(int j = i; j < studentCount; j++){
                    students[j] = students[j + 1];
                }
                students[studentCount - 1] = null;
                studentCount--;
                System.out.println("Student delete successfully");
                return;
            }
        }
        System.out.println("No student found with ID: " + id);
    }

    public static void StudentList(){
        if(studentCount == 0){
            System.out.println("No students exist in the list");
        }
        else{
            System.out.println("Student list includes " + studentCount + " students");
            for(int i = 0; i < studentCount; i++){
                System.out.println(students[i]);
            }
        }
    }
    public static void SaveFile() throws IOException {
        ArrayList<Student> studentList = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            studentList.add(students[i]);
        }
        FileStudent.SaveFile(studentList);
    }
}
